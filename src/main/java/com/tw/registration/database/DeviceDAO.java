package com.tw.registration.database;

import com.tw.registration.core.Device;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class DeviceDAO extends AbstractDAO<Device> {
    public DeviceDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public Device create(Device device) {
        return persist(device);
    }
}