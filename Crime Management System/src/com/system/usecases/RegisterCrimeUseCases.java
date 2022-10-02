package com.system.usecases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.system.bean.Crime;
import com.system.dao.CrimeDao;
import com.system.dao.CrimeDaoImpl;
import com.system.utility.CreateDatabaseTable;

public class RegisterCrimeUseCases {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the crime name");
		String name= sc.next();
		
		System.out.println("Enter the crime date (yyyy-mm-dd)");
		String date= sc.next();
		
		System.out.println("Enter the crime place");
		String place= sc.next();
		
		System.out.println("Enter the victim name");
		sc.nextLine();
		String victim= sc.nextLine();
		
		System.out.println("Enter the crime detail");
		String description= sc.nextLine();
		
		System.out.println("Enter the suspect name");
		String suspect= sc.next();
		
		System.out.println("Enter the status of crime case (Solved/Not Solved)");
		sc.nextLine();
		String status= sc.nextLine();		
		CrimeDao cd= new CrimeDaoImpl();
		
		Crime cr= new Crime();
		cr.setCrime(name);
		cr.setDate(date);
		cr.setPlace(place);
		cr.setVictims(victim);
		cr.setDescription(description);
		cr.setSuspected(suspect);
		cr.setSolved(status);
		
		String registerMessage= cd.registerCrime(cr);
		
		System.out.println(registerMessage);
		
		
		
		
		
		
	}

}
