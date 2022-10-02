package com.system.execute;

import java.util.Scanner;

import com.system.usecases.AreaWiseCrimeUseCases;
import com.system.usecases.ChangeStatusUseCases;
import com.system.usecases.CountCaseUseCases;
import com.system.usecases.CurrentMonthCrimeUseCases;
import com.system.usecases.RegisterCrimeUseCases;
import com.system.usecases.RegisterCriminalUseCases;
import com.system.usecases.SearchCrimeUseCases;
import com.system.usecases.SearchCriminalUseCases;
import com.system.usecases.ShowStatusUseCases;

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
			
			} else if(choice==2) {
				RegisterCriminalUseCases rgcs= new RegisterCriminalUseCases();
				rgcs.main(args);
				
			} else if(choice==3) {
				ShowStatusUseCases st= new ShowStatusUseCases();
				st.main(args);
				
				
			} else if(choice==4) {
				ChangeStatusUseCases cs= new ChangeStatusUseCases();
				cs.main(args);
				
			} else if(choice==5) {
				SearchCrimeUseCases search= new SearchCrimeUseCases();
				search.main(args);
				
			} else if(choice==6) {
				SearchCriminalUseCases searchCriminal= new SearchCriminalUseCases();
				searchCriminal.main(args);
				
			} else if(choice==7) {
				CountCaseUseCases count= new CountCaseUseCases();
				count.main(args);
				
			} else if(choice==8) {
				CurrentMonthCrimeUseCases cmc= new CurrentMonthCrimeUseCases();
				cmc.main(args);
				
			} else if(choice==9) {
				AreaWiseCrimeUseCases area = new AreaWiseCrimeUseCases();
				area.main(args);
				
			} else if(choice==10) {
				String op= sc.next();
				
				if(op.equalsIgnoreCase("yes")) {
					System.out.println("Thank You");
					break;
				}
			}
		
		}
		
		
	}

}
