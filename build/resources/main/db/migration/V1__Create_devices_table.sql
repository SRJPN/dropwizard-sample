create table DEVICES (
    ID integer unique,
    IP_ADDRESS text not null,
    OPERATING_SYSTEM text not null,
    BROWSER text not null,
    DEVICE_TYPE text not null,
    TIME_DATE TEXT not null
);