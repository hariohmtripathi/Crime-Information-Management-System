package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.system.bean.Criminal;
import com.system.exception.CriminalException;
import com.system.utility.DBUtil;

public class CriminalDaoImpl implements CriminalDao{


	@Override
	public String registerCriminal(Criminal criminal) {
		
		String message=  "Not registerd";
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("insert into criminal(criminalName, age, gender, address, markOnFace, areaArrested, crimeCommited) values(?,?,?,?,?,?,?)");
				
				ps.setString(1, criminal.getCriminalName());
				ps.setInt(2, criminal.getAge());
				ps.setString(3, criminal.getGender());
				ps.setString(4, criminal.getAddress());
				ps.setString(5, criminal.getMarkOnFace());
				ps.setString(6, criminal.getFirstAreaArrested());
				ps.setString(7, criminal.getCriminalCrime());
				
				int x= ps.executeUpdate();
				
				if(x>0) {
					message= "Record inserted";
				}
				
				
				
			} catch (SQLException e) {
			
			message= e.getMessage();
		}
		
		
		return message;
		
	}

	@Override
	public Criminal searchCriminal(String name) throws CriminalException {
		Criminal criminal = null;
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from criminal where criminalName= ?");
			ps.setString(1, name);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String name1= rs.getString("criminalName");
				int age= rs.getInt("age");
				String gender= rs.getString("gender");
				String address= rs.getString("address");
				String mark= rs.getString("markOnface");
				String area= rs.getString("areaArrested");
				String crimeCommited= rs.getString("crimeCommited");
				
				criminal= new Criminal(name1, age, gender, address, mark, area,crimeCommited);
				
				
				
			} else {
				throw new CriminalException("There is no record with this criminal name.");
			}
			
		} catch (SQLException e) {
			throw new CriminalException(e.getMessage());
		}
		
		return criminal;
	}
	
	

}
