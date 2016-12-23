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
    static Connection conn;
static String usern,passwd,sid;
public jdbcconn(){

conn=null;
usern="vinayak";
passwd="vinpassword";
sid="xe";
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
        conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:"+sid,usern,passwd);
        }
        catch(SQLException e){
        System.out.println(""+e);
        }
    
    }
    
}
