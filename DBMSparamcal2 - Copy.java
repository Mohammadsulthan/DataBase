package sqlcon;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class DBMSparamcal2 
{
	public static void main(String[] args) throws Exception
	{
		//this method is OUT to call a jdbc inner method and print a statement
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dd","root","root");
		System.out.println("connected very well:"+conn);
		
		CallableStatement cal=conn.prepareCall("{call adde(?)}");
		
		cal.registerOutParameter(2,Types.INTEGER);
		cal.execute();
		
		//this programme how many rows find it using this method OUT parameter
		int noo=cal.getInt(1);
		System.out.println(noo);
	}
}
