package com.tw.registration.views;

import com.tw.registration.core.Device;
import io.dropwizard.views.View;

public class DeviceView extends View {
    private Device device;

    public DeviceView(Device device) {
        super("device.ftl");
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }
}
