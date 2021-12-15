package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class dd 
{
	public void connnect()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception h)
		{
			h.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception
	{
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/dd","root","root");
		System.out.println(conn);
		PreparedStatement ps=conn.prepareStatement("insert into asp values(?,?,?,?)");
		ps.setInt(1, 4);
		ps.setString(2,"mohammad");
		ps.setString(3, "8989");
		ps.setInt(4, 1);
		ps.execute();
		
	}
}
