package com.Bean;
import java.io.Serializable;
public class LoginBean implements Serializable
{
  private String uname;
  private String upwd;
  public LoginBean() 
  {
	super();
   }
  public LoginBean(String uname, String upwd) 
  {
	super();
	this.uname = uname;
	this.upwd = upwd;
  }
  public String getUname() 
  {
	return uname;
  }
  public void setUname(String uname) 
  {
	this.uname = uname;
  }
  public String getUpwd() 
  {
	return upwd;
  }
   public void setUpwd(String upwd) 
   {
	this.upwd = upwd;
   }
  @Override
  public String toString() 
  {
	return "LoginBean [uname=" + uname + ", upwd=" + upwd + "]";
   }
}