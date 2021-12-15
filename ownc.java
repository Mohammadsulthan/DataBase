package sqlcon;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

public class ownc 
{
	public ownc()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	public static void main(String[] args)throws Exception 
	{
		//this program was flat transaction management:
		Connection conn=null;
		try
		{
			//driver is a heavy object,should be loaded once
			conn= DriverManager.getConnection("jdbc:mysql://localhost:/hh", "root", "root");
			conn.setAutoCommit(false);
			
			System.out.println("connection successful:"+conn);
			
			Statement st=conn.createStatement();
			st.execute("insert dd values(6,'mohammadvenna',988462,2)");
			st.execute("insert dd values(2,'mohammadvenna','45654',2)");
		}
		catch(Exception b)
		{
			System.out.println(b);
			conn.rollback(); //rollback means only the content of correct 
							 //otherwise rollback condition worked
		}
		finally
		{
			conn.commit(); //commite means save 
		}
		
	}
}	
