/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataloader;
import java.sql.*;

/**
 *
 * @author vinayak
 */
public class data2 extends data{
        int CAR_ID;
public void getCarWithCarID(int carid,String table,jdbcconn conctn)
{
String qry="SELECT * FROM "+table+" WHERE CAR_ID ="+carid+"";
 try{ResultSet res;
     res=conctn.executeQuery(qry);
     res.next();
     if (res.getInt("CAR_ID")==carid){
     getFromResultSet(res);
     CAR_ID=carid;
     
     }
 }
 catch(SQLException e){
 System.out.println("ERROR@getcharwithcarid:"+e +qry);
 }
}
    
}
