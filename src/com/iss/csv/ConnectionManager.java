package com.iss.csv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager
{
	private static Connection con=null;	
	private static String url=null;
	private static String Driver=null;
	PreparedStatement stmt=null;
	
	public static Connection getConnection()
	{
		Properties props=new Properties();
		try
		{
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("Demo.properties"));
			
			Driver=props.getProperty("Driver");
			url=props.getProperty("connectionURL");
			
			Class.forName(Driver);
			con=DriverManager.getConnection(url);
			
		}catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return con;
	}
}
