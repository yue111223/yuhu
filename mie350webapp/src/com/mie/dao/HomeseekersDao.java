package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mie.model.Homeseekers;
import com.mie.model.Student;
import com.mie.util.DbUtil;

public class HomeseekersDao {
	/**
	 * This class handles the Member objects and the login component of the web
	 * app.
	 */
	static Connection currentCon = null;
	static ResultSet rs = null;
	private Connection connection;

	public static Homeseekers login(Homeseekers hs) {

		/**
		 * This method attempts to find the member that is trying to log in by
		 * first retrieving the username and password entered by the user.
		 */
		Statement stmt = null;

		String username = hs.getsUserName();
		String password = hs.getPassword();

		/**
		 * Prepare a query that searches the members table in the database
		 * with the given username and password.
		 */
		String searchQuery = "select * from Homeseekers where sUserName='"
				+ username + "' AND Password='" + password + "'";

		try {
			// connect to DB
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			
			if (!more) {
				hs.setValid(false);
			}
			else if (more){
				hs.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		/**
		 * Return the Member object.
		 */
	
		
		return hs;

	}
	
	public HomeseekersDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}

	
	public void addHomeseeker(Homeseekers hs) {
		/**
		 * This method adds a new hs to the database.
		 */
		connection = DbUtil.getConnection();
		//System.out.println(connection);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Home(Long) values (?)");
		// Parameters start with 1
		preparedStatement.setString(1, hs.getLongURL());

		preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql statement error");
		}
	}
	

}
