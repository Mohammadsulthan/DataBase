package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class readind 
{
	public static void main(String[] args) throws Exception
	{
		re tt=re.t1();
		tt.redaing(2);
	}
}
class re
{
	private re()throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	private static re t;
	public static re t1()throws Exception
	{
		if(t==null)
		{
			t=new re();
		}
		return t;
	}
	public void redaing(int ig)throws Exception
	{
		Connection conn1=null;
		PreparedStatement st=null;
		try
		{
			conn1=DriverManager.getConnection("jdbc:mysql://localhost/hh","root","root");
			System.out.println("connect successfull:");
			conn1.setAutoCommit(false);
			st=conn1.prepareStatement("select * from dd where id=?");
			st.setInt(1, ig);
			ResultSet rt=st.executeQuery();
			while(rt.next())
			{
				System.out.println("dd table id:"+rt.getInt(1));
				System.out.println("dd table name:"+rt.getString(2));
				System.out.println("dd table age:"+rt.getInt(3));
				System.out.println("dd table atanderd:"+rt.getInt(4));
			}
		}
		catch(Exception bb)
		{
			bb.printStackTrace();
			conn1.rollback();
		}
		finally
		{
			conn1.commit();
		}
	}
}