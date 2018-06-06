<%-- 
    Document   : home
    Created on : Jun 2, 2018, 4:23:08 PM
    Author     : Clay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .login{
               
                background: #fff;
                padding: 80px;
                margin: auto;
                margin-top: 75px;
            width: 240px;
            }
            form{
                
                text-align: center; 
            }
            input
            {
             width: 240px;
             text-align: center;
             background: #ecf0f1;
             border: 2px solid transparent;
             border-radius: 3px;
             font-size: 16px;
             font-weight: 200;
             padding: 10px 0;
             transition: border .5s;
                 
            }
            input[type = submit]{
                border: 2px solid transparent;
                background: red;
                color: white;
                font-size: 16px;
                line-height: 25px;
                padding: 10px 0;
                border-radius: 3px;
            }
            input[type = submit]:hover{
            background: #2980b9;
            }
                
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#2980b9">
        <%
            HttpSession hs=request.getSession(true);
            if(hs.getAttribute("user")!=null)
            response.sendRedirect("LoginServlet");
        %>
        <div class="login" align="center">
            <h3>Login</h3>
            <form action="LoginServlet" method="POST" onsubmit="return verify()" name="submit">
                <input type="text" name="Id" placeholder="Enter Your Id"  id="id"  /><br><br>
                 <input type="password" name="password" placeholder="Enter Your Password"  id="pw" /><br><br>
               <div id="msg"></div>
               <br>
               <input type="submit" value="Login Here" id="loginbtn"/><br><br>
            </form>
            <form action="form1.html">
                <input type="submit" value="SignUp" id="submitbtn"/>
            </form>
        </div>

    </body>
</html>
