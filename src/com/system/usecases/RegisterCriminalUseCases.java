package com.system.usecases;

import java.util.Scanner;

import com.system.bean.Criminal;
import com.system.dao.CriminalDao;
import com.system.dao.CriminalDaoImpl;

public class RegisterCriminalUseCases {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the criminal name");
		String name= sc.nextLine();
		
		System.out.println("Enter the age of criminal");
		int age= sc.nextInt();
		
		System.out.println("Enter the criminal gender");
		String gender= sc.next();
		
		System.out.println("Enter the address");
		sc.nextLine();
		String address= sc.nextLine();
		
		System.out.println("Enter the mark on face");
		String mark= sc.next();
		
		System.out.println("Enter the area first arrested");
		String area= sc.next();
		
		System.out.println("Enter the crime commited");
		String crimeCommited= sc.next();
		
		
		
		Criminal criminal= new Criminal();
		
		criminal.setCriminalName(name);
		criminal.setAge(age);
		criminal.setGender(gender);
		criminal.setAddress(address);
		criminal.setMarkOnFace(mark);
		criminal.setFirstAreaArrested(area);
		criminal.setCriminalCrime(crimeCommited);
		
		
		CriminalDao cd= new CriminalDaoImpl();
		
		String message= cd.registerCriminal(criminal);
		
		System.out.println(message);
		
		
		
		
		
		
		
		
		
		
	}

}
