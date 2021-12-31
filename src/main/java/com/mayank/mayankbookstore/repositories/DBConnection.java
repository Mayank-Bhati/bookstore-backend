package com.mayank.mayankbookstore.repositories;

import com.mayank.mayankbookstore.constants.IDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con;

    private DBConnection() {
    }

    ;

    static {

        try {

            Class.forName(IDatabase.DRIVER_NAME);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            con = DriverManager.getConnection(IDatabase.CONNECTION_STRING, IDatabase.USER_NAME, IDatabase.PASSWORD);

        } catch (SQLException e) {

            e.printStackTrace();

        }


    }//End of static block

    public static Connection getCon() {
        return con;
    }
}
