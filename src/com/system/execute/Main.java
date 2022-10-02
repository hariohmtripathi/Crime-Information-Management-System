package com.system.execute;

import java.util.Scanner;

import com.system.usecases.RegisterCrimeUseCases;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to crime management system\n");
	
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Choose the option");
			System.out.println("1. Register crime"
					+ "\n2. Register Criminal Details"
					+ "\n3. Show status of case"
					+ "\n4. Change status of case"
					+ "\n5. Search case in records"
					+ "\n6. Search criminal in records"
					+ "\n7. Get report on status of case"
					+ "\n8. Get all cases of crime of current month"
					+ "\n9. Get report of crime cases area wise"
					+ "\n10. Do you want to exit");
			
			int choice= sc.nextInt();
			
			if(choice==1) {
				RegisterCrimeUseCases rgs= new RegisterCrimeUseCases();
				rgs.main(args);
				
				
				
			}
		
		}
		
		
	}

}
