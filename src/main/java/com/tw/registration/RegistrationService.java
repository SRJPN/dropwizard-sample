package com.tw.registration;

import com.tw.registration.database.Database;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import com.tw.registration.configuration.RegistrationServiceConfiguration;
import com.tw.registration.resource.RegistrationResource;

public class RegistrationService extends Service<RegistrationServiceConfiguration> {
    private Database database;

    public static void main(String[] args) throws Exception {
        new RegistrationService().run(args);
    }

    public RegistrationService() {
        super("Registration");
    }

    @Override
    protected void initialize(RegistrationServiceConfiguration registrationServiceConfiguration, Environment environment) throws Exception {
        database = Database.create();
        environment.addResource(new RegistrationResource(database));
    }
}
