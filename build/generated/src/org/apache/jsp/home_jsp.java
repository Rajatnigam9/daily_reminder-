package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"error.jsp", true, 8192, true);
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
      out.write("        <style>\n");
      out.write("            .login{\n");
      out.write("               \n");
      out.write("                background: #fff;\n");
      out.write("                padding: 80px;\n");
      out.write("                margin: auto;\n");
      out.write("                margin-top: 75px;\n");
      out.write("            width: 240px;\n");
      out.write("            }\n");
      out.write("            form{\n");
      out.write("                \n");
      out.write("                text-align: center; \n");
      out.write("            }\n");
      out.write("            input\n");
      out.write("            {\n");
      out.write("             width: 240px;\n");
      out.write("             text-align: center;\n");
      out.write("             background: #ecf0f1;\n");
      out.write("             border: 2px solid transparent;\n");
      out.write("             border-radius: 3px;\n");
      out.write("             font-size: 16px;\n");
      out.write("             font-weight: 200;\n");
      out.write("             padding: 10px 0;\n");
      out.write("             transition: border .5s;\n");
      out.write("                 \n");
      out.write("            }\n");
      out.write("            input[type = submit]{\n");
      out.write("                border: 2px solid transparent;\n");
      out.write("                background: red;\n");
      out.write("                color: white;\n");
      out.write("                font-size: 16px;\n");
      out.write("                line-height: 25px;\n");
      out.write("                padding: 10px 0;\n");
      out.write("                border-radius: 3px;\n");
      out.write("            }\n");
      out.write("            input[type = submit]:hover{\n");
      out.write("            background: #2980b9;\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("        </style>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"#2980b9\">\n");
      out.write("        ");

            HttpSession hs=request.getSession(true);
            if(hs.getAttribute("user")!=null)
            response.sendRedirect("LoginServlet");
        
      out.write("\n");
      out.write("        <div class=\"login\" align=\"center\">\n");
      out.write("            <h3>Login</h3>\n");
      out.write("            <form action=\"LoginServlet\" method=\"POST\" onsubmit=\"return verify()\" name=\"submit\">\n");
      out.write("                <input type=\"text\" name=\"Id\" placeholder=\"Enter Your Id\"  id=\"id\"  /><br><br>\n");
      out.write("                 <input type=\"password\" name=\"password\" placeholder=\"Enter Your Password\"  id=\"pw\" /><br><br>\n");
      out.write("               <div id=\"msg\"></div>\n");
      out.write("               <br>\n");
      out.write("               <input type=\"submit\" value=\"Login Here\" id=\"loginbtn\"/><br><br>\n");
      out.write("            </form>\n");
      out.write("            <form action=\"form1.html\">\n");
      out.write("                <input type=\"submit\" value=\"SignUp\" id=\"submitbtn\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
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
