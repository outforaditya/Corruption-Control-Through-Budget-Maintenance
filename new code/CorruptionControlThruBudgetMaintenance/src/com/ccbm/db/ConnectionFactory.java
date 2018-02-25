package com.ccbm.db;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.ccbm.exception.ConnectionException;
import com.ccbm.util.LoggerManager;


public class ConnectionFactory {
	
	
	private static Connection mCon;
	private static Properties mProps;

	/**
	 * @return the props
	 */
	public static Properties getProperties()
	{
		return mProps;
	}

	/**
	 * @param props
	 *            application properties object
	 */
	public void setProperties(Properties aProps)
	{
		mProps = aProps;
	}

	public static Connection getConnection()//throws ConnectionException
	{
		try
		{
			Properties aProps = getProperties();
			Class.forName(aProps.getProperty("driver"));
			mCon = DriverManager.getConnection(aProps.getProperty("url"), aProps.getProperty("duser"), aProps.getProperty("dpass"));
		}
		catch (ClassNotFoundException cnfe)
		{
			LoggerManager.writeLogWarning(cnfe);
			//throw new ConnectionException("Some technical problem occured try later...");
		}
		catch (SQLException se)
		{
			LoggerManager.writeLogWarning(se);
			//throw new ConnectionException("server problem");
		}
		return mCon;
	}


}
