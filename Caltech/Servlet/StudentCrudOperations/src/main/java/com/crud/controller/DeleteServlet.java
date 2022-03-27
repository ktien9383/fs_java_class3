package com.crud.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.service.StudentDAO;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int rollno=Integer.parseInt(request.getParameter("rollno"));
    	int result=new StudentDAO().getStudentIdDelete(rollno);
    	if(result>0)
    		response.getWriter().println("Record Deleted");
	}

	
}
