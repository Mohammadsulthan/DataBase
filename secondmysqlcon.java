package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class secondmysqlcon 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection uu=DriverManager.getConnection("jdbc:mysql://localhost/","root","root");
		
		System.out.println(uu);
		
		Statement st=uu.createStatement();
		
		String sqlquery="create table yy(uid int(5),uname varchar(40),pass varchar(30),flag int(1)";
		
		st.execute(sqlquery);
	}
}
