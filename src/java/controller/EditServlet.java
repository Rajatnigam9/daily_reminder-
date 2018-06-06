/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.UsersDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Task;
import pojo.UserName;
import pojo.dbutil;

/**
 *
 * @author Clay
 */
public class EditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {          
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
            t.setId(Integer.parseInt(request.getParameter("taskid")));
            boolean q=UsersDao.editTask(t,db);
            if(q==true)
            response.sendRedirect("home.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(TodoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
             ServletException se=new ServletException(ex.toString());
            throw se;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
