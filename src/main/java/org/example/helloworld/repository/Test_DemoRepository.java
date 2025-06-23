package org.example.helloworld.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.helloworld.entity.Test_Demo;
import org.example.helloworld.GetDBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

@ApplicationScoped
public class Test_DemoRepository implements ITest_DemoRepository {

    public Test_DemoRepository() {

    }

    Statement stmt = null;
    Connection conn;
    ResultSet rs;

    GetDBConnection getDBConnection = new GetDBConnection();

    public List<Test_Demo> getTest_Demos() {
        List<Test_Demo> list = new ArrayList<>();

        conn = getDBConnection.getConnection();

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM dbo.Test_Demo");
            while(rs.next()){
                Test_Demo testDemo = new Test_Demo();
                testDemo.setID(rs.getInt(1));
                testDemo.setName(rs.getString(2));
                list.add(testDemo);
            }

        }catch(SQLException e){

        }

        return list;
    }

    public List<Test_Demo> addNewRecord(int id, String name){
        conn = getDBConnection.getConnection();
        List<Test_Demo> list = new ArrayList<>();
        String sql = "INSERT INTO dbo.Test_Demo(id, name) VALUES(?,?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.setString(2, name);
            int rowsAffected = statement.executeUpdate();
        }catch(SQLException e){

        }

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM dbo.Test_Demo");
            while(rs.next()){
                Test_Demo testDemo = new Test_Demo();
                testDemo.setID(rs.getInt(1));
                testDemo.setName(rs.getString(2));
                list.add(testDemo);
            }
        }catch (SQLException e){

        }
        return list;
    }

    public List<Test_Demo> updateRecord(int id, String name){
        conn = getDBConnection.getConnection();
        List<Test_Demo> list = new ArrayList<>();
        String sql = "UPDATE dbo.Test_Demo SET name = ? WHERE id = ?";

        try(PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected);
        }catch(SQLException e){

        }

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM dbo.Test_Demo");
            while(rs.next()){
                Test_Demo testDemo = new Test_Demo();
                testDemo.setID(rs.getInt(1));
                testDemo.setName(rs.getString(2));
                list.add(testDemo);
            }
        }catch(SQLException e){

        }
        return list;
    }

    public List<Test_Demo> deleteRecord(int id){
        conn = getDBConnection.getConnection();
        List<Test_Demo> list = new ArrayList<>();
        String sql = "DELETE FROM dbo.Test_Demo WHERE id = ?";

        try(PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected);
        }catch(SQLException e){

        }

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM dbo.Test_Demo");
            while(rs.next()){
                Test_Demo testDemo = new Test_Demo();
                testDemo.setID(rs.getInt(1));
                testDemo.setName(rs.getString(2));
                list.add(testDemo);
            }
        }catch(SQLException e){

        }
        return list;
    }
}
