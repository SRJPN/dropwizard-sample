package com.tw.registration.resource;

import com.google.common.base.Optional;
import com.sun.jersey.api.NotFoundException;
import com.tw.registration.core.Device;
import com.tw.registration.database.DeviceDAO;
import com.yammer.dropwizard.hibernate.UnitOfWork;
import com.yammer.dropwizard.jersey.params.LongParam;
import eu.bitwalker.useragentutils.UserAgent;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.*;

//@Path("/registration")
//@Produces(MediaType.APPLICATION_JSON)

//public class DeviceResource {
//    private final DeviceDAO deviceDAO;
//
//    public DeviceResource(DeviceDAO deviceDAO) {
//        this.deviceDAO = deviceDAO;
//    }
//
//    @POST
//    @UnitOfWork
//    public Device createDevice(Device device) {
//        return deviceDAO.create(device);
//    }

@Path("/registration")
@Produces(MediaType.APPLICATION_JSON)
public class DeviceResource {

private DeviceDAO deviceDAO;

public DeviceResource(DeviceDAO deviceDAO) {
    this.deviceDAO = deviceDAO;
    }

    @GET
    @UnitOfWork
    public void createEntry(@Context HttpHeaders headers) {
        MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
        UserAgent userAgent = UserAgent.parseUserAgentString(requestHeaders.get("User-Agent").get(0));
        Set<String> strings = requestHeaders.keySet();
        for (String string : strings) {
            System.out.println(string+"----------------------"+requestHeaders.get(string)+"---------------");
        }
        Device device = new Device();
        device.setOPERATING_SYSTEM(userAgent.getOperatingSystem().getName());
        device.setIP_ADDRESS(requestHeaders.get("Host").toString());
        deviceDAO.create(device);
//
//
//        System.out.println("=========id "+userAgent.getId());
//        System.out.println("=========os "+userAgent.getOperatingSystem());
//        System.out.println("=========browser "+userAgent.getBrowser());
//        System.out.println("=========bversion "+userAgent.getBrowserVersion());
    }
}
