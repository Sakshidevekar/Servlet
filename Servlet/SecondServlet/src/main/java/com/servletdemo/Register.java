package com.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/registerform")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response ) throws ServletException , IOException{
		String name=request.getParameter("name1");
		String email=request.getParameter("email1");
		String Pass=request.getParameter("pass1");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/thekiran?useSSL=false","root","root");
			PreparedStatement ps=c.prepareStatement("insert into register(name,email,password) values (?,?,?)");
			ps.setString(1, name);
			ps.setString(2,email);
			ps.setString(3, Pass);
			ps.executeUpdate();
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println(name+" your data inserted...");
			System.out.println("data inserted.... ");
			RequestDispatcher rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
			c.close();
		} catch (Exception e) {
			
		}
		

}

	public static boolean validate(String email, String pass) {
		// TODO Auto-generated method stub
		return false;
	}
}
