/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.Registration;
import pojo.dbutil;

/**
 *
 * @author Clay
 */
public class RegistrationDao {
    public static boolean insertData(Registration reg, dbutil db) throws SQLException
    {
    Connection con=db.getCon();
    PreparedStatement ps=con.prepareStatement("insert into users values (?,?,?,?)");
     ps.setString(1,reg.getUserid());
     ps.setString(2, reg.getName());
     ps.setLong(3, reg.getContact());
     ps.setString(4, reg.getPassword());
     int i=ps.executeUpdate();
     if(i==0)
         return false;
     else return true;
    }
        
}
