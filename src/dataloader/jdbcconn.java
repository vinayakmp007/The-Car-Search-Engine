/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataloader;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author vinayak
 */
public class jdbcconn {
Connection conn;
Statement state;
String usern,passwd,sid,port;
public jdbcconn(){

conn=null;
usern="";      //your  username
passwd="";     //password
sid="";         //sid
port="";
}
public jdbcconn(String userns,String passwds,String sids,String por){

conn=null;
usern=userns;
passwd=passwds;
sid=sids;
port=por;
}
public void close() throws SQLException{
conn.close();
}
public void makeStatement() throws  InterruptedException
{
    try{
state =conn.createStatement();
    }
    catch(NullPointerException |SQLException e)
    {
    
        System.out.println("ERRor"+e.toString());
       
    }
}
public void executeUpdate(String a) throws SQLException, InterruptedException 
{
try{
    state.executeUpdate(a);
}
  catch(NullPointerException |SQLException e)
    {
    
        System.out.println("ERRor"+e.toString());
    }
}

public ResultSet executeQuery(String a) throws SQLException
{
return state.executeQuery(a);
}
    public boolean connectToDB()
    {
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        }
        catch(ClassNotFoundException e)
        {
        System.out.println("No class found"+e);
          return false;          
        }
        
        try{
        conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"+port+":"+sid,usern,passwd);
        }
        catch(SQLException e){
        System.out.println(""+e);
        return false;
        }
    return true;
    }
    
}
