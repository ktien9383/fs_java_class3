package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.model.Student;
import com.crud.service.StudentDAO;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Read values
			int rollno=Integer.parseInt(request.getParameter("txtRollno"));
			String name= request.getParameter("txtname");
			Date dob=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("txtdob"));
			
			//Wrap data in Object
			Student student=new Student(rollno,name,dob);
			
			StudentDAO sdao=new StudentDAO();
			int result=sdao.UpdateData(student);
			PrintWriter out=response.getWriter();
			if(result>0)
				out.println("Record Updated");
			
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
	}

	

}
