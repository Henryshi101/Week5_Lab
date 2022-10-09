/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;
import models.User;

/**
 *
 * @author 14686
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User newUser = (User)session.getAttribute("newUser");
        String logout = request.getParameter("logout");
        if (logout != null) {
            session.invalidate();
        } else if (newUser != null) {
            response.sendRedirect("home");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userIn = request.getParameter("username");
        String passIn = request.getParameter("password");
        
        User user = new User(userIn, passIn);
        HttpSession session = request.getSession();
        
        AccountService as = new AccountService();
        
        if(as.login(userIn, passIn)== null){
          request.setAttribute("username", user);
          session.setAttribute("user", userIn);

          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
          else{
            response.sendRedirect("home");
            session.setAttribute("username", user);
            session.setAttribute("user", userIn);

            
        }
    }
}
