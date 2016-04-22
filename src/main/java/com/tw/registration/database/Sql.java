package com.tw.registration.database;

public class Sql {

    public String createQuery(String mac_id, String device_name, String ip_address, String device_type, String operating_system) {
        return  String.format("INSERT INTO DEVICES (MAC_ID,DEVICE_NAME,IP_ADDRESS,DEVICE_TYPE,OPERATING_SYSTEM)\n" +
                " VALUES (%s,%s,%s,%s,%s);",mac_id,device_name,ip_address,device_type,operating_system);
    }
}
