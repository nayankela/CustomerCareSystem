package com.customercare;

import java.sql.Connection;
import java.sql.DriverManager;

public class Utility {

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_care_system", "root", "server.123");

	}
}
