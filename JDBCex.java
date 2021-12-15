package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCex 
{
	public static void main(String[] args) throws Exception
	{
		ex1 tt=ex1.metod();
		//tt.insert();
		//tt.update();
		//tt.delete();
	}
}
class ex1
{
	private ex1()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	private static ex1 ss;
	public static ex1 metod() throws Exception
	{
		if(ss==null)
		{
			ss=new ex1();
		}
		return ss;
	}
	public void insert()throws Exception
	{
		Connection con=null;
		Statement st=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost/hh", "root", "root");
			System.out.println("database connected:");
			con.setAutoCommit(false);
			st=con.createStatement();
			st.execute("insert into dd values(4,'mohammad mokaka',22,4)");
			System.out.println("one row insert successfull:");
		}
		catch(Exception a)
		{
			System.out.println(a);
			con.rollback();
		}
		finally
		{
			con.commit();
			con.close();
			st.close();
		}
	}
	public void update()throws Exception
	{
		Connection con=null;
		Statement st=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost/hh", "root", "root");
			System.out.println("database connected:");
			con.setAutoCommit(false);
			st=con.createStatement();
			st.execute("update dd set id=100 where id=1");
			System.out.println("one row update successfull:");
		}
		catch(Exception b)
		{
			System.out.println(b);
			con.rollback();
		}
		finally
		{
			con.commit();
			con.close();
			st.close();
		}
	}
	public void delete()throws Exception
	{
		Connection con=null;
		Statement st=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost/hh", "root", "root");
			System.out.println("database connected:");
			con.setAutoCommit(false);
			st=con.createStatement();
			st.execute("delete from dd where id=100");
			System.out.println("one row delete successfull:");
		}
		catch(Exception b)
		{
			System.out.println(b);
			con.rollback();
		}
		finally
		{
			con.commit();
			con.close();
			st.close();
		}
	}
	
}