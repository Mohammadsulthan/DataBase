package sqlcon;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JDBCone 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","root");
		System.out.println("perfectly coneded:."+conn);
		
		
		DatabaseMetaData nn= conn.getMetaData();
		System.out.println("data base name:"+nn.getDatabaseProductName());
		System.out.println(nn.getDatabaseMajorVersion());
		System.out.println(nn.getDriverName());
		System.out.println(nn.getDriverVersion());
		
		
		System.out.println(nn.supportsTransactionIsolationLevel(4));
		
		conn.setTransactionIsolation(8);
		System.out.println(conn.getTransactionIsolation());
		System.out.println(nn.getDefaultTransactionIsolation());
		System.out.println(conn.getAutoCommit());
		conn.setAutoCommit(false);
		System.out.println(conn.getAutoCommit());
		
	}
	
}
