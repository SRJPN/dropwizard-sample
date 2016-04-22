package com.tw.registration.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private static final String USER_NAME = "postgres";
    private static final String PSWD = "Why$ishigh";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";

    public static Database create(){
        Database database = new Database();
        database.initialise();
        return database;
    }

    private void initialise(){
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(DATABASE_URL,USER_NAME,PSWD);

            stmt = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS DEVICES " +
                    "(MAC_ID               INT    PRIMARY KEY     NOT NULL," +
                    " DEVICE_NAME          TEXT       NOT NULL, " +
                    " IP_ADDRESS           TEXT       NOT NULL, " +
                    " DEVICE_TYPE          CHAR(50)   NOT NULL, " +
                    " OPERATING_SYSTEM     TEXT       NOT NULL)";

            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        System.out.println("Opened database successfully");
    }

    public void addEntry(Device device){
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(DATABASE_URL, USER_NAME, PSWD);

            stmt = connection.createStatement();

            Sql sql = new Sql();

            stmt.executeUpdate(device.fillData(sql));
            stmt.close();
            connection.close();

        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }

    }
}
