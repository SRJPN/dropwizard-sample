package com.tw.registration.core;


import javax.persistence.*;

@Entity
@Table(name = "DEVICES")

public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "IP_ADDRESS", nullable = false)
    private String IP_ADDRESS;

//    @Column(name = "DEVICE_TYPE", nullable = false)
//    private String DEVICE_TYPE;

    @Column(name = "OPERATING_SYSTEM", nullable = false)
    private String OPERATING_SYSTEM;

    public long getId() {
        return id;
    }

    public String getIP_ADDRESS() {
        return IP_ADDRESS;
    }

//    public String getDEVICE_TYPE() {
//        return DEVICE_TYPE;
//    }

    public String getOPERATING_SYSTEM() {
        return OPERATING_SYSTEM;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIP_ADDRESS(String IP_ADDRESS) {
        this.IP_ADDRESS = IP_ADDRESS;
    }

//    public void setDEVICE_TYPE(String DEVICE_TYPE) {
//        this.DEVICE_TYPE = DEVICE_TYPE;
//    }

    public void setOPERATING_SYSTEM(String OPERATING_SYSTEM) {
        this.OPERATING_SYSTEM = OPERATING_SYSTEM;
    }
}

