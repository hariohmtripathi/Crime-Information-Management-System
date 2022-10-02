package com.system.dao;

import java.util.List;

import com.system.bean.Crime;
import com.system.bean.CrimeDTO;
import com.system.exception.CrimeException;

public interface CrimeDao {
	
	
	public String registerCrime(Crime crime);
	public Crime alterStatus(String crimeName, String victim, String suspected) throws CrimeException;
	public Crime changeStatus(String crimeName, String victim, String suspected, String status) throws CrimeException;
	public Crime changeStatus(String crimeName, String victim, String suspected) throws CrimeException;
	public String showStatus(String crimeName, String victim, String suspected) throws CrimeException;
	public List<CrimeDTO> areawiseCrime() throws CrimeException;
	public Crime searchCrime(String crimeName, String victim, String suspected ) throws CrimeException;
	public int countCase(String status) throws CrimeException;
	public List<Crime> currentMonthCrime() throws CrimeException;
	
}
