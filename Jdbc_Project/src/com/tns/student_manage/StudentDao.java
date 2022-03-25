package com.tns.student_manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudent(Student s) {
		boolean f = false;
		// jdbc code
		try {
			Connection con = Conn.createC();

			String q = "insert into students (sname,sphone,scity) values (?,?,?)";
			// preparedStatement
			PreparedStatement pt = con.prepareStatement(q);

			// set the value
			pt.setString(1, s.getStudentName());
			pt.setString(2, s.getStudentPhone());
			pt.setString(3, s.getStudentCity());

			// exceute
			pt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public static boolean deleteStudent(int userId) {

		boolean f1 = false;
		// jdbc code
		try {
			Connection con = Conn.createC();

			String q = "delete from students where id=?";
			// preparedStatement
			PreparedStatement pt = con.prepareStatement(q);

			// set the value
			pt.setInt(1, userId);
			// exceute
			pt.executeUpdate();
			f1 = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f1;

	}

	public static boolean showAllStudent() {
		// TODO Auto-generated method stub
		boolean f1 = false;
		// jdbc code
		try {
			Connection con = Conn.createC();

			String q = "select * from students;";
			// preparedStatement
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(q);
			// exceute
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String city = rs.getNString("scity");

				System.out.println("ID:" + id);
				System.out.println("Name: " + name);
				System.out.println("Phone: " + phone);
				System.out.println("City: " + city);
				System.out.println("+++++++++++++++++++++");
			}
			f1 = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f1;
	}
}
