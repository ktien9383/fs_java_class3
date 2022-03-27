package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.model.Student;
import com.crud.service.StudentDAO;


@WebServlet("/ViewRecords")
public class ViewRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//Read data from ArrayList
			ArrayList<Student> list=new StudentDAO().getRecords();
			PrintWriter out=response.getWriter();
			out.println("<table border=2>");
			for(Student student:list) {
				out.println("<tr><td>"+student.getRollno()+"</td><td> "+student.getStudname()+"</td><td> "+student.getDOB()+"</td> ");
			out.println("<td><a href='EditServlet?rollno="+student.getRollno()+"'>edit</a></td>");
			out.println("<td><a href='DeleteServlet?rollno="+student.getRollno()+"'>delete</a></td></tr>");
}
			
			out.println("</table>");
			
		}
			catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
