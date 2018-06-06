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
import pojo.Task;
import pojo.UserName;

import pojo.Users;
import pojo.dbutil;


/**
 *
 * @author ~Mystery Man~
 */
public class UsersDao {
    public static boolean checkUser(Users u,dbutil db)throws SQLException
    {
      
             Connection con=db.getCon();
        PreparedStatement ps=con.prepareStatement("select * from users where userid=? and pawwsord=?");
        ps.setString(1, u.getUser());
        ps.setString(2, u.getPw());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            return true;
        else 
            return false;
    }
    public static ArrayList<Task> task(UserName u,dbutil db) throws SQLException
    {
        ArrayList<Task> t=new ArrayList<>();
        Connection con=db.getCon();
        Task ts;
        PreparedStatement ps=con.prepareStatement("select * from task where userid=? order by taskdate desc");
        ps.setString(1, u.getUserName());
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            ts=new Task();
            ts.setTaskdate(rs.getDate(2));
            ts.setTask(rs.getString(3));
            ts.setId(rs.getInt(4));
            t.add(ts);
        }
        return t;
    }
    public static Task todaytask(UserName u,dbutil db) throws SQLException
    {
        ArrayList<Task> t=new ArrayList<>();
        Connection con=db.getCon();
        Task ts=null;
        PreparedStatement ps=con.prepareStatement("select * from task where userid=? and taskdate=? ");
        ps.setString(1, u.getUserName());
        ps.setDate(2, u.getToday());
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            ts=new Task();
            ts.setTaskdate(rs.getDate(2));
            ts.setTask(rs.getString(3));
            
        }
        return ts;
    }
    public static boolean setTask(Task t,dbutil db) throws SQLException
    {
          Connection con=db.getCon();
           PreparedStatement ps=con.prepareStatement("insert into task values (?,?,?,?)");
        ps.setString(1, t.getUser());
        ps.setDate(2, t.getTaskdate());
        ps.setString(3, t.getTask());
        ps.setInt(4, t.getId());
        int i=ps.executeUpdate();
        if(i!=0)
            return true;
        else 
            return false;
    }
    public static boolean editTask(Task t,dbutil db) throws SQLException
    {
        Connection con=db.getCon();
        PreparedStatement ps=con.prepareStatement("update task set taskdate=?, task=? where userid=? and id=?");
        ps.setString(3, t.getUser());
        ps.setDate(1, t.getTaskdate());
        ps.setString(2, t.getTask());
        ps.setInt(4, t.getId());
        int i=ps.executeUpdate();
        if(i!=0)
            return true;
        else 
            return false;
        
    }
    public static boolean delete(Task t, dbutil db) throws SQLException
    {
        Connection con=db.getCon();
        PreparedStatement ps=con.prepareStatement("delete from task where id=? and userid=? ");
        ps.setString(2, t.getUser());
       ps.setInt(1, t.getId());
         int i=ps.executeUpdate();       
        if(i!=0)
            return true;
        else 
            return false;
    }
    public static int idretrieve(dbutil db, UserName u) throws SQLException
    {
        int id=0;
        Connection con=db.getCon();
        PreparedStatement ps=con.prepareStatement("select count(*) as no from task where userid=?");
        ps.setString(1, u.getUserName());
        ResultSet rs=ps.executeQuery();
        rs.next();
        id=rs.getInt("no");
return id;
        
    }
}
