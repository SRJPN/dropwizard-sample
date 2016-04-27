package com.tw.registration.views;

import com.tw.registration.core.Device;
import io.dropwizard.views.View;

import java.util.List;

public class DeviceListView extends View {
    private List<Device> devices;

    public DeviceListView(List<Device> devices) {
        super("deviceList.ftl");
        this.devices = devices;
    }

    public List<Device> getDevices() {
        return devices;
    }
}
