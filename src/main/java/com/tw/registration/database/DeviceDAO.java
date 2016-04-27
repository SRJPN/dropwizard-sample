package com.tw.registration.database;

import com.google.common.base.Optional;
import com.tw.registration.core.Device;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class DeviceDAO extends AbstractDAO<Device> {
    public DeviceDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public Device create(Device device) {
        return persist(device);
    }


    public Optional<Device> find(int id) {
        return Optional.fromNullable(get(id));
    }

    public List<Device> findAll() {
        return list(namedQuery("com.tw.registration.core.Device.findAll"));
    }
}