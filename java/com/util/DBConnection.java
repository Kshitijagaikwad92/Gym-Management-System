package com.util;
import java.sql.*;
public class DBConnection 
{
  public static Connection dbConnect() throws ClassNotFoundException
  {
    Connection con=null;  
	try 
	{
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:oracle12c","System","Sct#2306");
	}
	catch (SQLException e) 
	{
	  e.printStackTrace();
	}
	 return con;
  }// end method 
}//end class