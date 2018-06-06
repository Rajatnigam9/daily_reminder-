<%-- 
    Document   : logout
    Created on : Jun 2, 2018, 5:08:58 PM
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
        <%
            HttpSession hs=request.getSession(false);
            if(hs.getAttribute("user")!=null)
            {
                hs.removeAttribute("user");
                hs.removeAttribute("pw");
                response.sendRedirect("home.jsp");
            }
        %>
    </body>
</html>
