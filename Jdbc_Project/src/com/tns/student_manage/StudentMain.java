package com.tns.student_manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Welcome to Student Management App");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to DELETE student");
			System.out.println("PRESS 3 to display student");
			System.out.println("PRESS 4 TO EXIT APP");
			int c = Integer.parseInt(br.readLine());
			if (c == 1) {
				// add student
				
				System.out.println("Enter username");
				String name = br.readLine();

				System.out.println("Enter user phone");
				String ph = br.readLine();

				System.out.println("Enter user city");
				String city = br.readLine();

				// create Student obj to store
				Student s = new Student(name, ph, city);

				boolean answer = StudentDao.insertStudent(s);
				if (answer) {
					System.out.println("Student is added successfully");
				} else {
					System.out.println("Something went wrong try again");
				}
				System.out.println(s);

			} else if (c == 2) {

				// delete

				System.out.println("Enter Student id to delete");
				int userId = Integer.parseInt(br.readLine());
				boolean f1 = StudentDao.deleteStudent(userId);
				if (f1) {
					System.out.println("Deleted......");
				} else {
					System.out.println("Something went wrong try again");
				}

			} else if (c == 3) {
				// display

				StudentDao.showAllStudent();
			} else if (c == 4) {
				// exit
				break;
			} else {

			}
		}

		System.out.println("Thank you for using my application....");
		System.out.println("See you soon...");
	}

}
