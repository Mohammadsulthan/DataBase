package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCresultset 
{
	public static void main(String[] args)throws Exception 
	{
		//this programme i sresultset metadata
		re1 ff=re1.t1();
		ff.redaing();
	}
}
class re1
{
	private re1()throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	private static re1 t;
	public static re1 t1()throws Exception
	{
		if(t==null)
		{
			t=new re1();
		}
		return t;
	}
	public void redaing()throws Exception
	{
		Connection conn1=null;
		Statement st=null;
		ResultSet rt=null;
		try
		{
			conn1=DriverManager.getConnection("jdbc:mysql://localhost/dd","root","root");
			System.out.println("connect successfull:");
			//conn1.setAutoCommit(false);
			st=conn1.createStatement();
			rt=st.executeQuery("select * from asp");
			
			ResultSetMetaData rem=rt.getMetaData();
			System.out.println(rem.getColumnCount());
			
			int nc=rem.getColumnCount();
			for(int i=1;i<=nc;i++)
			{
				System.out.print(rem.getColumnName(i)+"\t"+"|");
			}
			
			System.out.println();
			System.out.println("_______________________________________");
			while(rt.next())
			{
				for(int i=1;i<=nc;i++)
				{
					System.out.print(rt.getString(i)+"\t"+"|");
				}
				System.out.println();
			}
//			while(rt.next())
//			{
//				System.out.println("dd table id:"+rt.getInt(1));
//				System.out.println("dd table name:"+rt.getString(2));
//				System.out.println("dd table age:"+rt.getInt(3));
//				System.out.println("dd table atanderd:"+rt.getInt(4));
//			}
		
		}
		catch(Exception bb)
		{
			bb.printStackTrace();
		//	conn1.rollback();
		}
		finally
		{
			//conn1.commit();
		}
	}
}
