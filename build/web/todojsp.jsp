<%-- 
    Document   : todojsp
    Created on : May 30, 2018, 12:17:57 AM
    Author     : Clay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="pojo.Task,java.util.ArrayList,java.text.SimpleDateFormat" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            body{
                font-family: arial;
                background: #3498db;
            }
            .todo{
                background: #fff;
                padding: 80px;
                width: 300px;
                margin: auto;
                margin-top: 50px;
                height: 150px;
            }
            input[type= submit], input[type= button]
            {
                border: 1px solid transparent;
                background: red;
                color: white;
                font-size: 16px;
                line-height: 17px;
                padding: 9px 6px;
                border-radius: 3px;
            }
            input[type=submit]:hover
            {
                background: #2980b9;
            }
            input[type=button]:hover
            {
                background: #2980b9;
            }
           .today{
                background: aquamarine;

            }

            
        </style>
        <script type="text/javascript">
         var ajaxreq=new XMLHttpRequest();
            function show()
            {
                var txt=document.getElementById("qwerty").value;
                var date=document.getElementById("date").value;
                var text=document.getElementById("text").value;
                ajaxreq.onreadystatechange=check;
                ajaxreq.open("GET","addtask.jsp?user="+txt+"&date="+date+"&task="+text,true);
                ajaxreq.send(null);

                            }
            function check()
            {
                if(ajaxreq.readyState==4)
                {

                        var as=document.getElementById("result");
                        as.innerHTML=ajaxreq.responseText;

                }
                
            }
           
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Hello <%=request.getAttribute("name")%>
        <div align="right" color="black"><a href="logout.jsp" >Logout</a></div>
        <div class="todo" align = "center">
            <form action="TodoServlet" method="POST">
       
                <div>Choose Date<input type="date" name="date" value="" id="date" /> </div>
                <div><textarea name="task" rows="4" cols="35" placeholder="Enter Your Task" id="text">
            </textarea></div>
        <input type="hidden" value="<%=(String)request.getAttribute("name")%>"  name="username" id="qwerty" />
        <input type="button" value="Add Task" onclick="show()" />
        <div id="result"></div>
             </form>
        <form action="edit.jsp">
            <input type="submit" value="Edit Data" />
            <input type="hidden" value="<%=(String)request.getAttribute("name")%>"  name="usname" id="qwerty" />
        
        </form>
        <form action="deletejsp.jsp">
            <input type="submit" value="Delete Data"  />
            <input type="hidden" value="<%=(String)request.getAttribute("name")%>"  name="uname" id="qwerty" />
        
        </form>
        </div>
        <div align="center">
            
            <table cellpadding="10" width="40%" bgcolor="white" align="center" cellspacing="2">
<% 
Task t=(Task)request.getAttribute("today");
String str="";
String task="";
if(t!=null)
{
java.sql.Date dt=t.getTaskdate();
Long time= dt.getTime();
java.util.Date dtt= new java.util.Date(time);
SimpleDateFormat sdp= new SimpleDateFormat("dd-MM-YYYY:EEEE");
str=sdp.format(dtt);
task=t.getTask();
}           %>
<tr>
    <td class="today"><%=str+" (Today's Task) "%></td>
    <td class="today"><%=task%></td>
  </tr>
 </table>
        </div>
  <div id="task" align="center">
      <table cellpadding="10" width="40%" bgcolor="white" align="center"

  cellspacing="2">

      <% 
      ArrayList<Task> arr=(ArrayList)request.getAttribute("task");
      if(!arr.isEmpty())
      for(Task ts:arr)
      {
          SimpleDateFormat sdq= new SimpleDateFormat("dd-MM-YYYY");
            String stw=sdq.format(ts.getTaskdate());
          out.println("<tr><td>"+ts.getId()+"</td><td>"+stw+"</td><td>"+ts.getTask()+"</td></tr>");
          
      }
      %>
      
  </div>
    </body>
</html>
