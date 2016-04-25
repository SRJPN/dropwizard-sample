package com.tw.registration;

import com.tw.registration.configuration.RegistrationServiceConfiguration;
import com.tw.registration.core.Device;
import com.tw.registration.database.DeviceDAO;
import com.tw.registration.resource.DeviceResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.HibernateBundle;
import com.yammer.dropwizard.migrations.MigrationsBundle;

public class RegistrationService extends Service<RegistrationServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new RegistrationService().run(args);
    }

    private final HibernateBundle<RegistrationServiceConfiguration> hibernateBundle = new HibernateBundle<RegistrationServiceConfiguration>(Device.class) {
        @Override
        public DatabaseConfiguration getDatabaseConfiguration(RegistrationServiceConfiguration configuration) {
            return configuration.getDatabaseConfiguration();
        }
    };

    @Override
    public void initialize(Bootstrap<RegistrationServiceConfiguration> bootstrap) {
        bootstrap.setName("Registration");
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<RegistrationServiceConfiguration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(RegistrationServiceConfiguration configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(RegistrationServiceConfiguration configuration, Environment environment) throws Exception {
        final DeviceDAO dao = new DeviceDAO(hibernateBundle.getSessionFactory());
        environment.addResource(new DeviceResource(dao));
    }
}
