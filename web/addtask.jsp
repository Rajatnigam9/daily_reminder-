<%-- 
    Document   : addtask
    Created on : Jun 2, 2018, 3:18:33 PM
    Author     : Clay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.SQLException,java.text.ParseException,java.text.SimpleDateFormat,java.util.Date,pojo.Task,pojo.UserName,pojo.dbutil,java.sql.Connection,Model.UsersDao"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try {
            int id;
            
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date dt=sdf.parse(request.getParameter("date"));
            System.out.println(dt);
            Long time=dt.getTime();
            java.sql.Date dtt=new java.sql.Date(time);
            System.out.println(dtt);
            ServletContext sc=super.getServletContext();
            dbutil db=new dbutil();
            db.setCon((Connection) sc.getAttribute("conn"));
            
            Task t=new Task();
            t.setUser(request.getParameter("user"));
            System.out.println(request.getParameter("user"));
            System.out.println(dtt);
            t.setTaskdate(dtt);
            t.setTask(request.getParameter("task"));
            System.out.println(request.getParameter("task"));
            UserName u=new UserName();
            u.setUserName(request.getParameter("user"));
            id=UsersDao.idretrieve(db,u)+1;
            t.setId(UsersDao.idretrieve(db,u)+1);
            boolean q=UsersDao.setTask(t,db);
            if(q==true)
            out.println("Task Added Successfully");
        } catch (ParseException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
             ServletException se=new ServletException(ex.toString());
            throw se;
        }

            %>
            
    </body>
</html>
