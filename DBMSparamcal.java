package sqlcon;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBMSparamcal 
{
	public static void main(String[] args) throws Exception
	{
		//this programme in jdbc inner create method or function IN type of an parameter 
		//this is used to apply the parameter value its like a mthod over loading:
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/dd", "root", "root");
		System.out.println(conn);
		
		CallableStatement cal=conn.prepareCall("{call mi(?,?)}");
		//this much formula is one way:
		//this question set like as a (1,2)
		//so this first question mark set a value of age so i am entered 500
		//this 500 set is 1
		//2 set in mohammad 
		//so actually (1,2) is (500,mohammad)
		//2.farmula like below:
		//this much of content is very big you see very easy method is strigthly you can enter () value and values.
		
		cal.setInt(1, 500);
		cal.setString(2,"mohammad");
		cal.execute();
		System.out.println("super connected and very well done its executed:....... iam very happy:.");
	}
}
