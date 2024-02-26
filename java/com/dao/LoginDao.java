package com.dao;
import java.sql.*;
import com.Bean.*;
import com.util.*; 
public class LoginDao 
{
 public String AuthenticateUser(LoginBean lb) throws ClassNotFoundException, SQLException
 {
	 String u=lb.getUname(); 
	 String p=lb.getUpwd();
	 Connection con=DBConnection.dbConnect();
	 PreparedStatement ps= con.prepareStatement("select userid,uname,upwd from library where uname=? and upwd=?");
	 ps.setString(1,u);
	 ps.setString(2,p);
	 ResultSet rs=ps.executeQuery();
	 if(rs.next())
         return "success";	 
	 return "Invalid username or password...!!!";	
 }//end method
}//end class