package org.example.helloworld;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.DriverManager;

public class GetDBConnection {
    public Connection getConnection() {
        Connection con = null;
        Context context;

        try{
            context = new InitialContext();

            String url = "jdbc:sqlserver://localhost;databaseName=Test;Trusted_Connection=True;trustServerCertificate=true";
            String username = "Chris";
            String password = "*********";
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e){

        }
        return con;
    }
}
