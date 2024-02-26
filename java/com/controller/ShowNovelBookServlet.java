package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class ShowNovelBookServlet extends HttpServlet 
{
    public ShowNovelBookServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:oracle12c","SYSTEM","Sct#2306");
			PrintWriter out=response.getWriter();
			String uname=request.getParameter("uname");
		    ps=con.prepareStatement("select * from novel_book");
		    ResultSet rs=ps.executeQuery();
		    out.print("<html>");	
		    out.print("<body>");
		    out.print("<p style='text-align:right'>"+uname+"</p>");
		    out.print("<p style='text-align:right'><a href=''>logout</a></p>");
		    out.print("<br><br>Historical Book Detailes are<br>");
		    out.print("<table>");
		    out.print("<tr><th>BookId</th><th>Book Name</th><th><Book Author></th><th>Book Price</th><th>Book Edition</th><th>Book ISBN No</th></tr>");
		    while(rs.next())
		    {
		    	out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6));
		    }
		    out.print("</table>");
		    out.print("</body>");
		    out.print("</html>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}// end doPost
}//end class
