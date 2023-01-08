package com.example.supplychain;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;

public class Login {

    private byte[] getSHA(String input){

        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(input.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String getEncryptedPassword(String password){

        String encryptedPassword = null;
        try{
            BigInteger number = new BigInteger(1,getSHA(password));
            StringBuilder hexString = new StringBuilder(number.toString(16));
            return hexString.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean customerLogin(String email, String password){

        String query= String.format("select * from customer where email='%s' and password ='%s' ",email,password);
        try{
            DatabaseConnection dbCon= new DatabaseConnection();
            ResultSet rs= dbCon.getQueryTable(query);
            if(rs!=null && rs.next())
                return true;
        }
        catch(Exception e){
                e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args){

        Login login = new Login();
        System.out.println(login.getEncryptedPassword("Misa@1796"));
    }
}

