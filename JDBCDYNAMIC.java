package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBCDYNAMIC 
{
	public static void main(String[] args) throws Exception
	{
		ex2 tt=ex2.metod();
		//tt.insertdynamic(5, "mohammad", 100, 2);
		//tt.updatedynamic(1);
		tt.deletedynamic("mohammad");
	}
}
class ex2
{
	private ex2()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	private static ex2 ss;
	public static ex2 metod() throws Exception
	{
		if(ss==null)
		{
			ss=new ex2();
		}
		return ss;
	}
	public void insertdynamic(int it,String name,int age,int stand)throws Exception
	{
		Connection con=null;
		PreparedStatement st=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost/hh", "root", "root");
			System.out.println("database connected:");
			con.setAutoCommit(false);
			st=con.prepareStatement("insert into dd values(?,?,?,?)");
			st.setInt(1, it);
			st.setString(2, name);
			st.setInt(3, age);
			st.setInt(4, stand);
			st.execute();
			//st.execute("insert into dd values(4,'mohammad mokaka',22,4)");
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
	public void updatedynamic(int set)throws Exception
	{
		Connection con=null;
		PreparedStatement st=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost/hh", "root", "root");
			System.out.println("database connected:");
			con.setAutoCommit(false);
			st=con.prepareStatement("update dd set id=?");
			//st.execute("update dd set id=100 where id=1");
			st.setInt(1, set);
			st.execute();
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
	public void deletedynamic(String string)throws Exception
	{
		Connection con=null;
		PreparedStatement st=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost/hh", "root", "root");
			System.out.println("database connected:");
			con.setAutoCommit(false);
			st=con.prepareStatement("delete from dd where name=?");
			//st.execute("delete from dd where id=100");
			st.setString(1, string);
			st.execute();
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