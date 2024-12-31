package com.block.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Home() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to a JSP page
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        String action =request.getServletPath();
        
        switch(action) {
        	case "/register":
        		requestDispatcher=request.getRequestDispatcher("index.jsp");
        		requestDispatcher.forward(request, response);
        		break;
    		case "/dashboard":
    			requestDispatcher=request.getRequestDispatcher("dashboard.jsp");
    			requestDispatcher.forward(request, response);
    			break;
        }
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
