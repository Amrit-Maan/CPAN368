package com.ak.week2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.ak.week2.RegistrationClass;

//DAO class is responsible for database operations
public class RegistrationDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/week2";
	private String jdbcUsername = "cpan368_AmritpalKaurMaan";
	private String jdbcPassword = "class123";

	// INSERT QUERY
	private static final String INSERT_SQL = "INSERT INTO registration (username, password, mobile, email) VALUES (?, ?, ?, ?)";

	// SELECT QUERY
	private static final String SELECT_SQL = "SELECT * FROM registration WHERE username = ?";

	// 1. INSERT METHOD
	public int registerUser(RegistrationClass reg) throws ClassNotFoundException {

		int result = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {

			ps.setString(1, reg.getUserName());
			ps.setString(2, reg.getPassword());
			ps.setString(3, reg.getMobileNumber());
			ps.setString(4, reg.getEmailID());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	//  2. SELECT METHOD
	public RegistrationClass selectUser(String username) throws ClassNotFoundException {

		RegistrationClass reg = null;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				PreparedStatement ps = con.prepareStatement(SELECT_SQL)) {

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				reg = new RegistrationClass();
				reg.setUserName(rs.getString("username"));
				reg.setPassword(rs.getString("password"));
				reg.setMobileNumber(rs.getString("mobile"));
				reg.setEmailID(rs.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reg;
	}
}