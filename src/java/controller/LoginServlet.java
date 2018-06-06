/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.UsersDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.Task;
import pojo.UserName;
import pojo.Users;
import pojo.dbutil;

/**
 *
 * @author Clay
 */
public class LoginServlet extends HttpServlet {

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
        String user=null,pw=null;
        try {
            HttpSession hs=request.getSession(false);
            if(hs.getAttribute("user")!=null)
            {user=(String) hs.getAttribute("user");
            pw=(String) hs.getAttribute("pw");
                System.out.println("old user"+user);
            }
            else
            {
             user=request.getParameter("Id"); 
             pw=request.getParameter("password");
             hs.setAttribute("user", user);
             hs.setAttribute("pw", pw);
                System.out.println("new user"+user);
            }
            Date dt=new Date();
            Long time=dt.getTime();
            java.sql.Date dtt=new java.sql.Date(time);
            ServletContext sc=super.getServletContext();
            dbutil db=new dbutil();
            db.setCon((Connection) sc.getAttribute("conn"));
            Users u=new Users();
            u.setUser(user);
            u.setPw(pw);
            if(UsersDao.checkUser(u,db))
            {
                
                UserName un =new UserName();
                un.setUserName(user);
                un.setToday(dtt);
                Task t=UsersDao.todaytask(un, db);
                ArrayList<Task> todo=UsersDao.task(un, db);
                request.setAttribute("name",user);
                request.setAttribute("today", t);
                request.setAttribute("task", todo);
                RequestDispatcher rd=request.getRequestDispatcher("todojsp.jsp");
                rd.include(request, response);
                              
            }
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
