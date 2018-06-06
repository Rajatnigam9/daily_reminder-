<%-- 
    Document   : deletejsp
    Created on : May 30, 2018, 1:44:24 PM
    Author     : Clay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<form action="DeleteServlet" method="POST">
        enter task id<input type="text" name="taskid" value="" />  
        <%System.out.println(request.getParameter("uname")); %>
        <input type="hidden" name="user" value="<%=request.getParameter("uname")%>" id="qwerty" />
        <input type="submit" value="Delete Task"  />
             </form>
    </body>
</html>
