package com.system.dao;

import com.system.bean.Criminal;
import com.system.exception.CriminalException;

public interface CriminalDao {

	
	public String registerCriminal(Criminal criminal);
	public Criminal searchCriminal(String name) throws CriminalException;
}
