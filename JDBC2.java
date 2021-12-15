package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC2 
{
	public JDBC2()throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	public static void main(String[] args) throws Exception 
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","root");
		try
		{
			//con.setAutoCommit(false);
			Statement stmt=con.createStatement();
			
			//step-4 execute the statement:
			stmt.execute("insert into fi values(2,'mohammad ali',30,'banggon')");
			stmt.execute("insert into fi values(3,30)");
		}
		catch(Exception b)
		{
			System.out.println(b);
			//con.rollback();
		}
		finally
		{
			//con.commit();
		}
	}
}
