package com.crm.sharphawk.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class is used to perform the database operations
 * @author iamsachin
 *
 */
public class DataBaseUtility
{

	static Driver driver;
	static Connection connection;
	static ResultSet result;

	/**
	 * This method will establish  mysql database connection
	 * @throwsSQLException
	 */
	public void connectDB() throws SQLException
	{
		try 
		{
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
	/**
	 * This method will execute the querry
	 * @param query
	 * @return
	 * @throwsThrowable
	 */
	public ResultSet execyteQuery(String query) throws Throwable
	{	
		result = connection.createStatement().executeQuery(query);
		return result;		
	}
	public void closeDatabase() throws SQLException
	{
		connection.close();
	}
	
}
