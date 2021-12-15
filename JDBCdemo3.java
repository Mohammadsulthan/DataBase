package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo3 
{
	public static void main(String[] args) throws Exception
	{
		aa va=aa.getobjcet();
		
		va.getoperationinsert();
		//va.getoperationupdate(1);
		//va.getoperationdelete(1);

	}
}
class aa
{
	//singleton
	private aa()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	private static aa obj;
	public static aa getobjcet() throws Exception
	{
		if(obj==null)
		{
			obj=new aa();
		}
		return obj;
	}
	public void getoperationinsert()throws Exception 
	{
		Connection conn=null;
		Statement st=null;
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost/hh","root","root");
			conn.setAutoCommit(false);
			System.out.println("connection successful:"+conn);
			st=conn.createStatement();
			//String sql="insert into dd values("+id+","+name+","+age+","+standerd+")";
			st.execute("insert into dd values(1,'mohammad suthan',20,2)");
			//st.execute(sql);
			
		}
		catch(Exception b)
		{
			b.printStackTrace();
			conn.rollback();
		}
		finally
		{
			conn.commit();
			conn.close();
			st.close();
		}
	}
	public void getoperationupdate(int flag) throws SQLException
	{
		//execute return a boolean
		//executeupdate return a integer
		//executequery 
		Connection conn=null;
		Statement st=null;
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost/hh","root","root");
			conn.setAutoCommit(false);
			System.out.println(conn);
			st=conn.createStatement();
			int numberofrows=st.executeUpdate("update dd set id="+flag);
			System.out.println("the number of update rows :"+numberofrows);
		}
		catch(Exception b)
		{
			System.out.println(b);
			conn.rollback();
		}
		finally
		{
			conn.commit();
		}
	}
	public void getoperationdelete(int flag) throws SQLException
	{
		//execute return a boolean
		//executeupdate return a integer
		//executequery 
		Connection conn=null;
		Statement st=null;
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost/hh","root","root");
			conn.setAutoCommit(false);
			System.out.println(conn);
			st=conn.createStatement();
			int numberofrows=st.executeUpdate("delete from dd where id="+flag);
			System.out.println("the number of delete rows :"+numberofrows);
		}
		catch(Exception b)
		{
			System.out.println(b);
			conn.rollback();
		}
		finally
		{
			conn.commit();
		}
	}
}