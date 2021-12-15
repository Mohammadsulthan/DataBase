package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


//this class use as prepared statement dynamic insert a query so this method use in this programme:
public class JDBCdemo4 
{
	public static void main(String[] args)throws Exception
	{
		bb vv=bb.getobjcet();
		//vv.getoperationinsertdynamic(1,"mohammad sulthan",20,100);
		//vv.getoperationupdate(2);
		vv.getoperationdelete("mohammad");
	}
}
class bb
{
	//singleton
	private bb()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	private static bb obj;
	public static bb getobjcet() throws Exception
	{
		if(obj==null)
		{
			obj=new bb();
		}
		return obj;
	}
	public void getoperationinsertdynamic(int id,String name,int age,int standerd)throws Exception 
	{
		Connection conn=null;
		PreparedStatement st=null;
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost/hh","root","root");
			conn.setAutoCommit(false);
			System.out.println("connection successful:"+conn);
			st=conn.prepareStatement("insert into dd values(?,?,?,?)");
			//String sql="insert into dd values("+id+","+name+","+age+","+standerd+")";
			st.execute("insert into dd values(1,'mohammad suthan',20,2)");
			st.setInt(1, id);
			st.setString(2, name);
			st.setInt(3, age);
			st.setInt(4, standerd);
			boolean aa=st.execute();
			System.out.println("the result of:"+aa);
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
		PreparedStatement st=null;
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost/hh","root","root");
			conn.setAutoCommit(false);
			System.out.println(conn);
			st=conn.prepareStatement("update dd set id=?");
//			int numberofrows=st.executeUpdate("update dd set id="+flag);
//			System.out.println("the number of delete rows :"+numberofrows);
			st.setInt(1, flag);
			boolean bb=st.execute();
			System.out.println("the result of:"+bb);
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
	public void getoperationdelete(String flag) throws SQLException
	{
		//execute return a boolean
		//executeupdate return a integer
		//executequery 
		Connection conn=null;
		PreparedStatement st=null;
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost/hh","root","root");
			conn.setAutoCommit(false);
			System.out.println(conn);
			st=conn.prepareStatement("delete from dd where name=?");
//			int numberofrows=st.executeUpdate("delete from dd where id=?");
//			System.out.println("the number of delete rows :"+numberofrows);
			st.setString(1, flag);
			boolean cc=st.execute();
			System.out.println("the result of:"+cc);
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