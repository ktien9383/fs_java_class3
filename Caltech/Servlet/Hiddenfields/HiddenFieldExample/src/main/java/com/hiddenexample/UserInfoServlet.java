package com.hiddenexample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("txtuid");
		String uname=request.getParameter("txtuname");
		PrintWriter out=response.getWriter();
		/*RequestDispatcher rd= request.getRequestDispatcher("UserCurrentInfo");//?txtuid="+uid+"&txtuname="+uname);
		rd.forward(request, response);*/
		response.sendRedirect("UserCurrentInfo?txtuid="+uid+"&txtuname="+uname);
		
		/*out.println("<form action='UserCurrentInfo'>");
		out.println("<input type='hidden' name='txtuid' value='"+uid+"'>" );
		out.println("<input type='hidden' name='txtuname' value='"+uname+"'>" );
		out.println("<input type='text' name='txtphone'>");
		out.println("<input type='submit' value='submit'>");
		
		out.println("</form>");*/
		
		
	}

}
