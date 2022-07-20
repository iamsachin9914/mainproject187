package pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest 
{

	public static void main(String[] args) throws SQLException 
	{
		Driver driverRef=new Driver();
		//step1:register to the database
		DriverManager.registerDriver(driverRef);
		//step2:connect to the database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("Connection is done");
			try
			{
				//step3:create query statement
				Statement stat=conn.createStatement();
				//execute the query
				ResultSet result=stat.executeQuery("select * from students_info");
				while(result.next())
				{
					System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
				}
			}
			catch(Exception e)
			{
				System.out.println("DataBaseException");
			}
			finally
			{
				//close the connection
				conn.close();
		
			}
	}

}
