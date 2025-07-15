package com.infosys.servlet_simple_demo_crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class StudentConnection {
	public static Connection getStudentConnection() {
		try {
			DriverManager.registerDriver(new Driver());

			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-a7", "root", "Shakya");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
