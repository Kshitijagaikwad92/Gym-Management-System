package com.controller;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
import com.Bean.*;
import com.dao.*;
public class LoginServlet extends HttpServlet 
{
    public LoginServlet() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
	    RequestDispatcher rd1= request.getRequestDispatcher("./books.html");
	    RequestDispatcher rd2= request.getRequestDispatcher("./login.html");
	    PrintWriter out=response.getWriter();
		LoginBean lb= new LoginBean();
	    lb.setUname(uname);
	    lb.setUpwd(upwd);
	    
	    LoginDao daoobj= new LoginDao();
	    try 
	    {
		  String result=daoobj.AuthenticateUser(lb);
		  if(result.equals("success"))
			  rd1.forward(request, response);
		  else
		  {
			  out.print(""+result);
		      rd2.include(request, response);
		  }
		} 
	    catch (ClassNotFoundException | SQLException e) 
	    {
				e.printStackTrace();
		}
   }//end post method
}//End class