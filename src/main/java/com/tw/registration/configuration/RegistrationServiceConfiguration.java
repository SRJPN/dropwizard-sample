package com.tw.registration.configuration;

import com.yammer.dropwizard.config.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.NotNull;

public class RegistrationServiceConfiguration extends Configuration {
    @NotNull
    @JsonProperty("DATABASE_URL")
    private String url;

    @NotNull
    @JsonProperty("USER_NAME")
    private String userName;

    @NotNull
    @JsonProperty("PASSWORD")
    private String password;

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
