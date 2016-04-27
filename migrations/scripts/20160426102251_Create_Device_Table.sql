--// Create Device Table
-- Migration SQL that makes the change goes here.
create table DEVICES (
    id integer unique,
    IP_ADDRESS text,
    OPERATING_SYSTEM text,
    BROWSER text,
    DEVICE_TYPE text,
    TIME_DATE TEXT
);


--//@UNDO
-- SQL to undo the change goes here.

drop table DEVICES;
