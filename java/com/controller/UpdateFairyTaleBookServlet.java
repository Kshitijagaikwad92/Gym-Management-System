package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UpdateFairyTaleBookServlet extends HttpServlet {
    public UpdateFairyTaleBookServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:oracle12c","SYSTEM","Sct#2306");
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			String book_name=request.getParameter("book_name");
			String author=request.getParameter("author");
			int price=Integer.parseInt(request.getParameter("price"));
			String edition=request.getParameter("edition");
			String ISBN=request.getParameter("ISBN");
			String updateQuery="update fairy_book set book_name=? , author=? ,price=? ,edition=?,ISBN=? where bookid=?";
			PreparedStatement ps=con.prepareStatement(updateQuery);
			ps.setString(1,book_name);
			ps.setString(2,author);
			ps.setInt(3,price);
			ps.setString(4,edition);
			ps.setString(5,ISBN);
			ps.setInt(6, bookid);
			
			int rowUpdated=ps.executeUpdate();
			ps.close();
			con.close();
			out.print("<html><body>");
			out.print("<h2><b>Record Updated Successfully...</h2>");
			out.print("<p>Record Updated : "+ rowUpdated + "</p>");	
			out.print("</body></html>");		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}// end doPost
}//end class
