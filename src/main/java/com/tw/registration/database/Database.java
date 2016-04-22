package com.tw.registration.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private final String url;
    private final String userName;
    private final String password;

    public Database(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public static Database create(String url, String userName, String password){
        Database database = new Database(url, userName, password);
        database.initialise();
        return database;
    }

    private void initialise(){
        String sql = "CREATE TABLE IF NOT EXISTS DEVICES " +
                "(MAC_ID               INT    PRIMARY KEY     NOT NULL," +
                " DEVICE_NAME          TEXT       NOT NULL, " +
                " IP_ADDRESS           TEXT       NOT NULL, " +
                " DEVICE_TYPE          CHAR(50)   NOT NULL, " +
                " OPERATING_SYSTEM     TEXT       NOT NULL)";
        queryStatement(sql);
        System.out.println("Opened database successfully");
    }

    public void addEntry(Device device){
        Sql sql = new Sql();
       queryStatement(device.fillData(sql));
    }

    private void queryStatement(String statement){
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(url, userName, password);

            stmt = connection.createStatement();

            stmt.executeUpdate(statement);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
    }
}
