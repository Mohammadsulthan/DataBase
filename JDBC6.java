package sqlcon;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
//this is use to database function call method using code:
public class JDBC6 
{	
	public static void main(String[] args)throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hh","root","root");
		System.out.println("databse connected:");
		CallableStatement call=con.prepareCall("{call my()}");
		
		call.execute();
	}
}
