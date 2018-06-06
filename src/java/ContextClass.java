


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

public class ContextClass implements ServletContextListener {
Connection con;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    
      ServletContext sc=sce.getServletContext();
      try {
            Class.forName(sc.getInitParameter("driver"));
            System.out.println("driver loaded");
             con=DriverManager.getConnection(sc.getInitParameter("ip"), sc.getInitParameter("user"), sc.getInitParameter("pwd"));
             System.out.println("Connection open");
            sc.setAttribute("conn", con);
        } catch (Exception ex) {
            
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
        
    try {
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(ContextClass.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
