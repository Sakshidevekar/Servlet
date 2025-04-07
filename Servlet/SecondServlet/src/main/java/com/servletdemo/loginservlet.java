package com.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/loginform")
public class loginservlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException{
		String email=request.getParameter("email1");
		String pass=request.getParameter("pass1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/thekiran?useSSL=false","root","root");
			PreparedStatement ps=c.prepareStatement("select * from register where  email=? and password=? ");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("login successful");
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");
				request.setAttribute("name", rs.getString(1));
				request.setAttribute("email", rs.getString(2));
				request.setAttribute("pass", rs.getString(3));
				out.println("<h5 style='color:green'> login successfully...</h5>");
				RequestDispatcher rd=request.getRequestDispatcher("/Profile.jsp");
				rd.include(request, response);
			}
			else {
				System.out.println("try again....");
				PrintWriter out=response.getWriter();
				out.println("<h1 style='color:green'> try again...</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("/login.html");
				rd.include(request, response);
			}
			
			c.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	}
	


