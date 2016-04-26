package com.tw.registration.core;


import javax.persistence.*;

@Entity
@Table(name = "DEVICES")

public class Device {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "IP_ADDRESS", nullable = false)
    private String IP_ADDRESS;

    @Column(name = "OPERATING_SYSTEM", nullable = false)
    private String OPERATING_SYSTEM;

    @Column(name = "BROWSER", nullable = false)
    private String BROWSER;

    @Column(name = "DEVICE_TYPE", nullable = false)
    private String DEVICE_TYPE;

    @Column(name = "TIME_DATE", nullable = false)
    private String TIME;

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {

        this.TIME = TIME;
    }

    public void setDEVICE_TYPE(String DEVICE_TYPE) {
        this.DEVICE_TYPE = DEVICE_TYPE;
    }

    public String getDEVICE_TYPE() {
        return DEVICE_TYPE;
    }

    public void setBROWSER(String BROWSER) {
        this.BROWSER = BROWSER;
    }

    public String getBROWSER() {
        return BROWSER;
    }

    public long getId() {
        return id;
    }

    public String getIP_ADDRESS() {
        return IP_ADDRESS;
    }

    public String getOPERATING_SYSTEM() {
        return OPERATING_SYSTEM;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIP_ADDRESS(String IP_ADDRESS) {
        this.IP_ADDRESS = IP_ADDRESS;
    }

    public void setOPERATING_SYSTEM(String OPERATING_SYSTEM) {
        this.OPERATING_SYSTEM = OPERATING_SYSTEM;
    }
}

