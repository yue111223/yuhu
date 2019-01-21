package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Home;
import com.mie.model.Homeseekers;
import com.mie.model.Info;
import com.mie.model.OwnerRule;
import com.mie.model.Preferences;
import com.mie.model.Student;
import com.mie.util.DbUtil;

public class HomeDao {
	static Connection currentCon = null;
	static ResultSet rs = null;
	private Connection connection;
	
	public HomeDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public void addHome(Home h) {
		/**
		 * This method adds a new preference to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Home(HomeID, oUserName, Price, District, Description) values (?, ?, ?, ? ,?)");
			// Parameters start with 1
			preparedStatement.setString(1, h.getHomeID());
			preparedStatement.setString(2, h.getoUserName());
			preparedStatement.setString(3, h.Price());
			preparedStatement.setString(4, h.District());
			preparedStatement.setString(5, h.Description());
			System.out.println(h);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void editHome(Home h) {
		/**
		 * This method adds a new preference to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE Home SET Price = ?,District = ?,Description =? WHERE oUserName = ? AND HomeID = ?");
			// Parameters start with 1

			preparedStatement.setString(1, h.Price());
			preparedStatement.setString(2, h.District());
			preparedStatement.setString(3, h.Description());
			preparedStatement.setString(4, h.getoUserName());
			preparedStatement.setString(5, h.getHomeID());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Info> searchHomes(Homeseekers hs, Preferences p) {
	
		List<Info> info = new ArrayList<Info>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT Home.HomeID, Home.District, Home.Price, Home.Description, Homeowners.Email, Homeowners.FirstName"
							+ " FROM ((Home INNER JOIN Homeowners ON Home.oUserName = Homeowners.oUserName) INNER JOIN OwnerRule ON Homeowners.oUserName = OwnerRule.oUserName) "
							+ "WHERE Home.Price = ? AND Home.District = ? AND OwnerRule.Smoke = ? AND OwnerRule.Pets = ? AND OwnerRule.Gender = ? ");

			preparedStatement.setString(1, p.Price());
			preparedStatement.setString(2, p.Districts());
			preparedStatement.setString(3, p.Smoke());
			preparedStatement.setString(4, p.Pets());
			preparedStatement.setString(5, hs.Gender());

			//System.out.println(hs);
			//System.out.println(p);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Info i = new Info();
				i.setHomeID(rs.getString("HomeID"));
				i.setDistrict(rs.getString("District"));
				i.setPrice(rs.getString("Price"));
				i.setDescription(rs.getString("Description"));
				i.setoEmail(rs.getString("Email"));
				i.setFirstName(rs.getString("FirstName"));
				info.add(i);
				//System.out.println(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return info;
	}
	
	public Home getHomeById(String id) {

		Home h = new Home();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Home where oUserName=?");
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				h.setHomeID(rs.getString("HomeID"));
				h.setoUserName(rs.getString("oUserName"));
				h.setPrice(rs.getString("Price"));
				h.setDistrict(rs.getString("District"));
				h.setDescription(rs.getString("Description"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return h;
	}
	
	public List<Info> getHomeKeyword(String keyword) {
		/**
		 * This method retrieves a list of students that matches the keyword
		 * entered by the user.
		 */
		List<Info> info = new ArrayList<Info>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT Home.HomeID, Home.District, Home.Price, Home.Description, Homeowners.Email, Homeowners.FirstName"
							+ " FROM ((Home INNER JOIN Homeowners ON Home.oUserName = Homeowners.oUserName) INNER JOIN OwnerRule ON Homeowners.oUserName = OwnerRule.oUserName) "
							+ "WHERE Home.HomeID LIKE ? OR Home.oUserName LIKE ? Home.Price  LIKE ? OR Home.District LIKE ? OR Home.Description LIKE ? "
							+ "OR OwnerRule.Smoke LIKE ? OR OwnerRule.Pets LIKE ? OR OwnerRule.Gender LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");
			preparedStatement.setString(4, "%" + keyword + "%");
			preparedStatement.setString(5, "%" + keyword + "%");
			preparedStatement.setString(6, "%" + keyword + "%");
			preparedStatement.setString(7, "%" + keyword + "%");
			preparedStatement.setString(8, "%" + keyword + "%");
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Info i = new Info();
				i.setHomeID(rs.getString("HomeID"));
				i.setDistrict(rs.getString("District"));
				i.setPrice(rs.getString("Price"));
				i.setDescription(rs.getString("Description"));
				i.setoEmail(rs.getString("Email"));
				i.setFirstName(rs.getString("FirstName"));
				info.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return info;
	}
	
}
