package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCreading1 
{
	public static void main(String[] args)throws Exception 
	{
		JDBCreading nn=JDBCreading.r();
		//nn.reading();
		nn.readingdynamic(1);
	}
}
class JDBCreading
{
	private JDBCreading()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	private static JDBCreading jr;
	public static JDBCreading r()throws Exception
	{
		if(jr==null)
		{
			jr=new JDBCreading();
		}
		return jr;
	}
	public void reading()throws Exception
	{
		//this method is use to executeQuery of reading in a data base inside data: 
		Connection conn=null;
		Statement st=null;
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost/dd","root","root");
			//conn.setAutoCommit(false);
			System.out.println(conn);
			st=conn.createStatement();
			ResultSet re=st.executeQuery("select * from dd");
			System.out.println("the database hh inside a table of dd content:");
			while(re.next())
			{
				//integer of how many coloum number requried enter a number 
				System.out.println("id:"+re.getInt(1));
				System.out.println("name:"+re.getString("name"));//coloum name  also be given
				System.out.println("age"+re.getInt(3));
				System.out.println("standerd:"+re.getInt(4));
			}
		}
		catch(Exception b)
		{
			System.out.println(b);
			//conn.rollback();
		}
		finally
		{
			//conn.commit();
		}
	}
	public void readingdynamic(int id)throws Exception
	{
		//this method is use to executeQuery of reading in a data base inside data: 
		Connection conn=null;
		PreparedStatement st=null;
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dd","root","root");
			System.out.println(conn);
			st=conn.prepareStatement("select * from asp where uid=?");
			st.setInt(1, id);
			ResultSet re=st.executeQuery();

			if(re.next())
			{
				//integer of how many coloum number requried enter a number 
				System.out.println("id:"+re.getInt(1));
				System.out.println("name:"+re.getString("name"));//coloum name  also be given
				System.out.println("age"+re.getInt(3));
				System.out.println("standerd:"+re.getInt(4));
			}
		}
		catch(Exception b)
		{
			System.out.println(b);
			//conn.rollback();
		}
		finally
		{
			//conn.commit();
		}
	}
}
