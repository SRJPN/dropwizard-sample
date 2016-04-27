package com.tw.registration.resource;
import com.tw.registration.core.Device;
import com.tw.registration.database.DeviceDAO;
import com.tw.registration.views.DeviceListView;
import com.tw.registration.views.DeviceView;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.IntParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/findDevice")
@Produces(MediaType.APPLICATION_JSON)
public class DeviceFinder  {
    private final DeviceDAO deviceDAO;

    public DeviceFinder(DeviceDAO deviceDAO) {
        this.deviceDAO = deviceDAO;
    }

    @GET
    @UnitOfWork
    @Path("/byId={id}")
    @Produces(MediaType.TEXT_HTML)
    public DeviceView findDevice(@PathParam("id") IntParam id) {
        DeviceView deviceView = new DeviceView(deviceDAO.find(id.get()).get());
        return deviceView;
    }

    @GET
    @UnitOfWork
    @Path("/all")
    @Produces(MediaType.TEXT_HTML)
    public DeviceListView findAllDevices() {
        return new DeviceListView(deviceDAO.findAll());
    }

}
