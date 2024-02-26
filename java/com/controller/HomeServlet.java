package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet 
{
    public HomeServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String uname= request.getParameter("uname");
            PrintWriter out=response.getWriter();
            out.print("<html>");
            out.print("<body bgcolor='yellow' align='center'>");
            out.print("<div background-color='hotpink' border:'3px solid black'>");
            out.print("<p style='text-align:right'>"+uname+"</p>");
            out.print("<p style='text-align:right'><a href=''>logout</a></p>");
            
            
            out.print("<br><br><a href='InsertBook.html'></a>");
            out.print("<br><input type='submit' value='Add Book'");

      
            out.print("<br><form action='./ShowBookServlet' method='post'>");
            out.print("<br><input type='hidden' name='uname' value='"+uname+"'");
            out.print("<br><input type='submit' value='Show Book'");
            out.print("<br></form>");
            
            out.print("<br><br><a href='UpdateBook.html'></a>");
            out.print("<br><input type='submit' value='Update Book'");
            
            out.print("</body>");
            out.print("</html>");
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		  doPost(request, response);	
		}
	}//end class