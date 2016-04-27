package com.tw.registration;

import com.tw.registration.configuration.RegistrationServiceConfiguration;
import com.tw.registration.core.Device;
import com.tw.registration.database.DeviceDAO;
import com.tw.registration.resource.DeviceFinder;
import com.tw.registration.resource.DeviceResource;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.dropwizard.views.freemarker.FreemarkerViewRenderer;
import jersey.repackaged.com.google.common.collect.ImmutableList;

import java.util.Map;

public class RegistrationApplication extends Application<RegistrationServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        RegistrationApplication registrationApplication = new RegistrationApplication();
        registrationApplication.run(args);
    }

    private final HibernateBundle<RegistrationServiceConfiguration> hibernateBundle = new HibernateBundle<RegistrationServiceConfiguration>(Device.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(RegistrationServiceConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public String getName() {
        return "Registration";
    }

    @Override
    public void initialize(Bootstrap<RegistrationServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<RegistrationServiceConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(RegistrationServiceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(new ViewBundle<RegistrationServiceConfiguration>(){
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(RegistrationServiceConfiguration configuration) {
                return configuration.getViewRendererConfiguration();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(RegistrationServiceConfiguration configuration, Environment environment) throws Exception {
        final DeviceDAO dao = new DeviceDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new DeviceResource(dao));
        environment.jersey().register(new DeviceFinder(dao));
    }
}
