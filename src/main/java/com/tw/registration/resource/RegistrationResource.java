package com.tw.registration.resource;

import com.tw.registration.database.Database;
import com.tw.registration.database.Device;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/registration")
@Produces(MediaType.APPLICATION_JSON)

public class RegistrationResource {
    private final AtomicLong counter;
    private Database database;

    public RegistrationResource(Database database) {
        this.database = database;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Device sayHello(@QueryParam("macId") String MAC_ID,
                           @QueryParam("deviceName") String DEVICE_NAME,
                           @QueryParam("ipAddress") String IP_ADDRESS,
                           @QueryParam("deviceType") String DEVICE_TYPE,
                           @QueryParam("operatingSystem") String OPERATING_SYSTEM) {
        Device device = new Device(MAC_ID, DEVICE_NAME, IP_ADDRESS, DEVICE_TYPE, OPERATING_SYSTEM);
        database.addEntry(device);
        return device;
    }
}
