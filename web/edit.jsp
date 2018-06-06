<%-- 
    Document   : edit
    Created on : May 30, 2018, 3:41:49 PM
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
       <form action="EditServlet" method="POST">
           
        enter task id<input type="text" name="taskid" value="" />  
        <%System.out.println(request.getParameter("usname")); %>
        <div>Choose Date<input type="date" name="date" value="" id="date" /> </div>
                <div><textarea name="task" rows="4" cols="35" placeholder="Enter Your Task" id="text">
            </textarea></div>
        <input type="hidden" name="user" value="<%=request.getParameter("usname")%>" id="qwerty" />
        <input type="submit" value="Edit Task"  />
             </form>
    </body>
</html>
