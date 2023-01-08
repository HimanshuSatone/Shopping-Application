package com.example.supplychain;
import java.sql.*;

public class DatabaseConnection {


    public Statement getStatement(){

        Statement statement =null;
        Connection conn;
        try{
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/supply_chain","root","12345678");
            statement=conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        return statement;
    }

    public ResultSet getQueryTable(String query){

        Statement statement= getStatement();
        try{
            return statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Function to execute insert dn updates queries to the database
    public int executeUpdateQuery(String query){

        Statement statement= getStatement();
        try{
            return statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

//    public static void main(String args[]){
//
//        DatabaseConnection databaseConnection= new DatabaseConnection();
//        ResultSet rs= databaseConnection.getQueryTable("SELECT email,first_name from customer");
//
//        try{
//            while (rs.next()){
//                System.out.println(rs.getString("email")+" "+rs.getString("first_name"));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
