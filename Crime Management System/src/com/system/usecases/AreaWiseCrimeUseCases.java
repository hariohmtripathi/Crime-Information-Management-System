package com.system.usecases;

import java.util.List;

import com.system.bean.CrimeDTO;
import com.system.dao.CrimeDao;
import com.system.dao.CrimeDaoImpl;
import com.system.exception.CrimeException;

public class AreaWiseCrimeUseCases {
	
	public static void main(String[] args) {
		
		CrimeDao cd= new CrimeDaoImpl();
		
		try {
			List<CrimeDTO> crimesDto= cd.areawiseCrime();
			
			crimesDto.forEach(s-> System.out.println(s +"\n"));
		} catch (CrimeException e) {
			System.out.println(e.getMessage());
		}
	}

}
