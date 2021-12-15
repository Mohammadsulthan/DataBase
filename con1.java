package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class con1 
{
	public static void main(String[] args)throws Exception
	{
		//step one load are register the  driver:
		//load the driver:
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step-2 establish a connection
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/one", "root","root");
		System.out.println(conn);
		
		//step-3 create a statement
		Statement stmt=conn.createStatement();
		
		//step-4 execute the statement:
		stmt.execute("insert into fi values(2,'mohammad sul',20,'venna')");
	}
}
