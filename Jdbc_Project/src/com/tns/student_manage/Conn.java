package com.tns.student_manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	static Connection con;

	public static Connection createC() {
		try {

			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			String user = "root";
			String password = "mkyounus@249";
			String url = "jdbc:mysql://localhost:3306/studentmgmt";
			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
