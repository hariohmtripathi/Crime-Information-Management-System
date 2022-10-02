package com.system.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateDatabaseTable {
	
	public static String createDatabase() {
		String message= "Database not created";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url= "jdbc:mysql://localhost:3306";
		
		try {
			Connection conn= DriverManager.getConnection(url,"root","hari@2001");
			
			Statement state= conn.createStatement();
			
			boolean flag= state.execute("create database crime_management_system");
			state.execute("use crime_management_system");
			boolean flag2= state.execute("create table crime(crimeno int unique auto_increment,crimeName varchar(15), "
					+ "date date, place varchar(15),victim varchar(15), "
					+ "description varchar(30), suspected varchar(15), "
					+ "status varchar(10), "
					+ "Primary Key(crimeName,victim,suspected))");
			boolean flag3= state.execute("create table criminal(serialno int primary key auto_increment,criminalName varchar(15) unique not null, "
					+ "age int, gender varchar(10), address varchar(15), "
					+ "markOnFace varchar(15), areaArrested varchar(15), "
					+ "crimeCommited varchar(15), "
					+ "foreign key(crimeCommited) references crime(crimename))");
			
			
			if(flag==false) {
				message= "Database is created. Crime Table and Criminal Table is not created";
			}
			if(flag2==false) {
				message= " Database and Crime Table created. Criminal Table is not created";
			}
			if(flag3==false) {
				message= "Database, Crime Table and Criminal Table is created";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message= e.getMessage();
		}
		
		return message;
	}

}
