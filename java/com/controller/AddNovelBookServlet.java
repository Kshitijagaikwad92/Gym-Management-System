package com.controller;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddNovelBookServlet extends HttpServlet {
    public AddNovelBookServlet() {
        super();
        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:oracle12c","SYSTEM","Sct#2306");
			PreparedStatement st=con.prepareStatement("insert into novel_book values(?,?,?,?,?,?)");
			PrintWriter out=response.getWriter();
			st.setInt(1,Integer.valueOf(request.getParameter("bookid")));
			st.setString(2,request.getParameter("book_name"));
			st.setString(3,request.getParameter("author"));
			st.setInt(4,Integer.valueOf(request.getParameter("price")));
			st.setString(5,request.getParameter("edition"));
			st.setString(6,request.getParameter("ISBN"));
			st.executeUpdate();
			st.close();
			con.close();
			
			out.print("<html><body><b>Record Inserted Successfully..."+ "</b></body></html>");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}// end doPost
}//end class
