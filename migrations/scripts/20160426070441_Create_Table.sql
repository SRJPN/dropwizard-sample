--// Create Table
-- Migration SQL that makes the change goes here.
create table DEVICES (
    ID integer unique,
    IP_ADDRESS text not null,
    OPERATING_SYSTEM text not null,
    BROWSER text not null,
    DEVICE_TYPE text not null,
    TIME_DATE TEXT not null
);


--//@UNDO
-- SQL to undo the change goes here.
DROP TABLE DEVICES

