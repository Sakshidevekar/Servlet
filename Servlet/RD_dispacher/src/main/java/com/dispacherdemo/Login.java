package com.dispacherdemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email1");
		String pass=req.getParameter("pass1");
		
		if(email.equals("aniket@gmail.com") && pass.equals("aniket@123")) {
			PrintWriter out=resp.getWriter();
			resp.setContentType("text/html");
			out.println("login successfuly");
			RequestDispatcher rd =req.getRequestDispatcher("/Profile.jsp");
			rd.include(req, resp);
			
		}else {
			PrintWriter out=resp.getWriter();
			resp.setContentType("text/html");
			out.println("try again");
			RequestDispatcher rd =req.getRequestDispatcher("/login.html");
			rd.include(req, resp);
			
		}
	}
	
	

}
