package com.tw.registration.resource;

import com.google.common.base.Optional;
import com.tw.registration.core.Device;
import com.tw.registration.database.DeviceDAO;
import com.tw.registration.views.DeviceView;
import eu.bitwalker.useragentutils.UserAgent;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Date;

@Path("/registration")
@Produces(MediaType.APPLICATION_JSON)
public class DeviceResource {

    private DeviceDAO deviceDAO;

    public DeviceResource(DeviceDAO deviceDAO) {
    this.deviceDAO = deviceDAO;
    }

    @GET
    @UnitOfWork
    public Device createEntry(@Context HttpHeaders headers, @Context HttpServletRequest http) {
        MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
        UserAgent userAgent = UserAgent.parseUserAgentString(requestHeaders.get("User-Agent").get(0));

        Device device = new Device();
        Date date = new Date();
        device.setOPERATING_SYSTEM(userAgent.getOperatingSystem().getName());
        device.setIP_ADDRESS(http.getRemoteHost());
        device.setBROWSER(userAgent.getBrowser().toString());
        device.setDEVICE_TYPE(userAgent.getOperatingSystem().getDeviceType().toString());
        device.setTIME(date.toString());
        deviceDAO.create(device);

        return device;
    }
}
