package com.system.usecases;

import java.util.Scanner;

import com.system.bean.Criminal;
import com.system.dao.CriminalDao;
import com.system.dao.CriminalDaoImpl;
import com.system.exception.CriminalException;

public class SearchCriminalUseCases {
	
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the name of criminal");
		String name= sc.nextLine();
		
		CriminalDao cd= new CriminalDaoImpl();
		
		try {
			Criminal criminal= cd.searchCriminal(name);
			System.out.println(criminal);
			
		} catch (CriminalException e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
		
		
	}

}
