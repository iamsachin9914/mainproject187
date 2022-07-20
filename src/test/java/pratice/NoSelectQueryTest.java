package pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSelectQueryTest 
{

	public static void main(String[] args) throws SQLException 
	{
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("Connection is done");
		try 
		{
			Statement stat=conn.createStatement();
			String query="insert into students_info (regno, firstName, middleName, lastName) values('4', 'sachin','bramin', 'k')";
			stat.executeUpdate(query);
		}
		catch(Exception a)
		{
			System.out.println("Exception");
		}
		finally
		{
			System.out.println("row has been inserted");
			conn.close();
		}
	}	

}
