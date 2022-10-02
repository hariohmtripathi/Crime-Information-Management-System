package com.system.usecases;

import java.util.List;

import com.system.bean.Crime;
import com.system.dao.CrimeDao;
import com.system.dao.CrimeDaoImpl;
import com.system.exception.CrimeException;

public class CurrentMonthCrimeUseCases {
	
	
	public static void main(String[] args) {
		
		CrimeDao cd= new CrimeDaoImpl();
		
		try {
			List<Crime> crimes= cd.currentMonthCrime();
			
			crimes.forEach(s-> System.out.println(s));
		} catch (CrimeException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
