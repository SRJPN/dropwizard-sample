package com.tw.registration.database;

public class Device {
    public String MAC_ID,DEVICE_NAME,IP_ADDRESS,DEVICE_TYPE,OPERATING_SYSTEM;

    public Device(String MAC_ID, String DEVICE_NAME, String IP_ADDRESS, String DEVICE_TYPE, String OPERATING_SYSTEM) {
        this.MAC_ID = MAC_ID;
        this.DEVICE_NAME = DEVICE_NAME;
        this.IP_ADDRESS = IP_ADDRESS;
        this.DEVICE_TYPE = DEVICE_TYPE;
        this.OPERATING_SYSTEM = OPERATING_SYSTEM;
    }

    public String fillData(Sql sql) {
        return sql.createQuery(MAC_ID, DEVICE_NAME, IP_ADDRESS, DEVICE_TYPE, OPERATING_SYSTEM);
    }
}

