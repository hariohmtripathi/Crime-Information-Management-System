package com.system.usecases;

import java.util.Scanner;

import com.system.dao.CrimeDao;
import com.system.dao.CrimeDaoImpl;
import com.system.exception.CrimeException;

public class CountCaseUseCases {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the status of case to get the record. (Solved/ Not Solved)");
		String status= sc.nextLine();
		
		
		CrimeDao cd= new CrimeDaoImpl();
		
		int count;
		try {
			count = cd.countCase(status);
			System.out.println(status.toUpperCase() + " cases are: " +count);
		} catch (CrimeException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
	}

}
