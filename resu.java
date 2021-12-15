package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class resu 
{
	public static void main(String[] args)throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		int a=1;
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/hh", "root", "root");
		System.out.println(conn);
		
		Statement st=conn.createStatement();
		
		ResultSet re=st.executeQuery("select * from dd");

		ResultSetMetaData rw=re.getMetaData();

		int coloumcount=rw.getColumnCount();
		for(int i=1;i<=coloumcount;i++)
		{
			System.out.print(rw.getColumnName(i)+"\t");
		}
		System.out.println();
		System.out.println("::_____________:___________:____________::");
	}

}
