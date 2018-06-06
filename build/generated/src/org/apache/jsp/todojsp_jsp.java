package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import pojo.Task;
import java.util.ArrayList;

public final class todojsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"todo\" align = \"center\">\n");
      out.write("            <form action=\"TodoServlet\" method=\"POST\">\n");
      out.write("        <div>Choose Date<input type=\"date\" name=\"date\" value=\"\" /> </div>\n");
      out.write("        <div><textarea name=\"task\" rows=\"4\" cols=\"20\" placeholder=\"Enter Your Task\">\n");
      out.write("            </textarea></div>\n");
      out.write("        <input type=\"submit\" value=\"Add Task\" />\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"today\" align=\"center\">\n");
      out.write("            ");
 
Task t=(Task)request.getAttribute("today");
            
      out.write("\n");
      out.write("            <table cellpadding=\"10\" width=\"20%\" bgcolor=\"white\" align=\"center\" cellspacing=\"2\">\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("    <td>");
      out.print(t.getTaskdate()+"");
      out.write("</td>\n");
      out.write("    <td>");
      out.print(t.getTask());
      out.write("</td>\n");
      out.write("  </tr>\n");
      out.write(" </table>\n");
      out.write("        </div>\n");
      out.write("  <div id=\"task\" align=\"center\">\n");
      out.write("      <table cellpadding=\"10\" width=\"20%\" bgcolor=\"white\" align=\"center\"\n");
      out.write("\n");
      out.write("  cellspacing=\"2\">\n");
      out.write("\n");
      out.write("      ");
 
      ArrayList<Task> arr=(ArrayList)request.getAttribute("task");
      for(Task ts:arr)
      {
          out.println("<tr><td>"+ts.getTaskdate()+"</td><td>"+ts.getTask()+"</td></tr>");
          
      }
      
      out.write("\n");
      out.write("  </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
