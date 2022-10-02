package com.system.usecases;

import java.util.Scanner;

import com.system.bean.Crime;
import com.system.dao.CrimeDao;
import com.system.dao.CrimeDaoImpl;
import com.system.exception.CrimeException;



public class SearchCrimeUseCases {
	
	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the crime name");
		String name= sc.next();
		
		System.out.println("Enter the victim name");
		String victim= sc.next();
		
		System.out.println("Enter the suspect name");
		String suspect= sc.next();
		
		CrimeDao cd= new CrimeDaoImpl();
		
		try {
			Crime crime= cd.searchCrime(name,victim,suspect);
			
			System.out.println(crime);
			
			
		} catch (CrimeException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
