<%-- 
    Document   : logincheck
    Created on : May 29, 2018, 8:26:40 PM
    Author     : Clay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.SQLException,java.text.SimpleDateFormat,java.text.ParseException,java.util.Date,pojo.dbutil,pojo.Task,Model.UsersDao"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try
            {
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
            t.setTaskdate(dtt);
            t.setTask(request.getParameter("task"));
            boolean q=UsersDao.setTask(t, db);
            if(q==true)
            out.println("true");
        } 
catch (ParseException ex) {
              } 
catch (SQLException ex) {
             ServletException se=new ServletException(ex.toString());
            throw se;
        }

   
            %>
    </body>
</html>
