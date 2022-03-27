package com.hiddenexample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserCurrentInfo
 */
@WebServlet("/UserCurrentInfo")
public class UserCurrentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCurrentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uid=request.getParameter("txtuid");
		//String phone=request.getParameter("txtphone");
		String uname=request.getParameter("txtuname");
		PrintWriter out=response.getWriter();
		out.println("user id="+uid);
		//out.println("phone no="+phone);
		out.println("name="+uname);
	}

}
