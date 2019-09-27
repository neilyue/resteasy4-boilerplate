/**
 * 
 */
package com.nfsmith.data;

import java.sql.Connection;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
 
/**
 * 
 * @author 
 *
 */
public class ConnectionFactory
{
	private static ConnectionFactory connectionFactory = null;
	
	private final static Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	
	public Connection getOracleConnection(String database)
	{
		Connection conn = null;

		try
		{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/" + database);
		
			if (ds != null) {
				conn = ds.getConnection();
			}
			else {
				LOGGER.info("Cannot establish the JDBC connection by JNDI context.");
			}
		}
		catch (Exception ex)
		{
			LOGGER.info(ex.getMessage());
			ex.printStackTrace();
		}

		return conn;
	}
	
	public Connection getMySqlConnection(String database)
	{
		Connection conn = null;

		try
		{
			String DATASOURCE_CONTEXT = "java:comp/env/jdbc/" + database;
			InitialContext initialContext = new InitialContext();
			DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
			if (datasource != null) {
				conn = datasource.getConnection();
			}
			else {
				LOGGER.info("Cannot establish the JDBC connection by JNDI context.");
			}
		}
		catch (Exception ex)
		{
			LOGGER.info(ex.getMessage());
			ex.printStackTrace();
		}

		return conn;
	}
	
	public static ConnectionFactory getInstance()
	{
		if(connectionFactory==null)
		{
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
