/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataloader;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author vinayak
 */
public class jdbcconn {
Connection conn;
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
    public void connectdb()
    {
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        }
        catch(ClassNotFoundException e)
        {
        System.out.println("No class found"+e);
                    
        }
        
        try{
        conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"+port+":"+sid,usern,passwd);
        }
        catch(SQLException e){
        System.out.println(""+e);
        }
    
    }
    
}
