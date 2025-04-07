package com.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regfrom")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException , IOException{
		
		String name=request.getParameter("name1");
		String Email=request.getParameter("email1");
		String pass=request.getParameter("Password1");
		String mobNO=request.getParameter("mob1");
		String add=request.getParameter("add1");
		String gender=request.getParameter("gender");
		String DOB=request.getParameter("dob");
		String city=request.getParameter("city1");
		String state=request.getParameter("state1");
		String Country=request.getParameter("con1");
		String age=request.getParameter("age1");
		String Degree=request.getParameter("Degree");
		
		
		System.out.println(name);
		System.out.println(Email);
		System.out.println(pass);
		System.out.println(mobNO);
		System.out.println(add);
		System.out.println(gender);
		System.out.println(DOB);
		System.out.println(city);
		System.out.println(state);
		System.out.println(Country);
		System.out.println(age);
		System.out.println(Degree);
		
		
		
		PrintWriter out=response.getWriter();
		out.print(name);
		out.print(Email);
		out.print(pass);
		out.print(mobNO);
		out.println(add);
		out.println(gender);
	    out.println(DOB);
		out.println(city);
		out.println(state);
		out.println(Country);
	    out.println(age);
		out.println(Degree);
		
		
		
	}

}
