package com.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.system.bean.Crime;
import com.system.bean.CrimeDTO;
import com.system.exception.CrimeException;
import com.system.utility.DBUtil;

public class CrimeDaoImpl implements CrimeDao{

	@Override
	public String registerCrime(Crime crime) {
		
		String message="Not registered";
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement pr= conn.prepareStatement("insert into crime(crimeName, date, place, victim,description,suspected,status) values(?,?,?,?,?,?,?)");
			
			pr.setString(1, crime.getCrime());
			pr.setString(2, crime.getDate());
			pr.setString(3, crime.getPlace());
			pr.setString(4, crime.getVictims());
			pr.setString(5, crime.getDescription());
			pr.setString(6, crime.getSuspected());
			pr.setString(7, crime.getSolved());
			
			
			int x= pr.executeUpdate();
			
			if(x>0) {
				message= "Crime is registered";
			}
			
			
			
			
			
		} catch (SQLException e) {
			
			message= e.getMessage();
		}
		
		return message;
	}

	@Override
	public Crime alterStatus(String crimeName, String victim, String suspected) throws CrimeException {
		Crime crime= null;
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select status from crime where crimeName=? AND victim=? AND suspected=?");
			
			ps.setString(1, crimeName);
			ps.setString(2, victim);
			ps.setString(3, suspected);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				String status= rs.getString("status");
				
				if(status.equalsIgnoreCase("not solved")) {
					
					PreparedStatement ps2= conn.prepareStatement("update crime set status='solved' where crimeName=? And victim=? And suspected=?");
					
					ps2.setString(1, crimeName);
					ps2.setString(2, victim);
					ps2.setString(3, suspected);
					
					int x= ps2.executeUpdate();
					
					if(x>0) {
						PreparedStatement ps3= conn.prepareStatement("select * from crime where crimeName=? AND victim=? AND suspected=?");
						ps3.setString(1, crimeName);
						ps3.setString(2, victim);
						ps3.setString(3, suspected);
						
						ResultSet rs2= ps3.executeQuery();
						
						if(rs2.next()) {
							int count= rs2.getInt("crimeno");
							String name= rs2.getString("crimeName");
							String date= rs2.getString("date");
							String place= rs2.getString("place");
							String vic= rs2.getString("victim");
							String description= rs2.getString("description");
							String suspect= rs2.getString("suspected");
							String sta= rs2.getString("status");
							
							crime= new Crime(count,name,date,place,vic,description,suspect,sta);
							
						} else {
							throw new CrimeException("There is no record present with given details");
						}
					}
					
				} else if(status.equalsIgnoreCase("solved")) {
                   PreparedStatement ps2= conn.prepareStatement("update crime set status='not solved' where crimeName=? And victim=? And suspected=?");
					
					ps2.setString(1, crimeName);
					ps2.setString(2, victim);
					ps2.setString(3, suspected);
					
					int x= ps2.executeUpdate();
					
					if(x>0) {
						PreparedStatement ps3= conn.prepareStatement("select * from crime where crimeName=? AND victim=? AND suspected=?");
						ps3.setString(1, crimeName);
						ps3.setString(2, victim);
						ps3.setString(3, suspected);
						
						ResultSet rs2= ps3.executeQuery();
						
						
						if(rs2.next()) {
							int count= rs2.getInt("crimeno");
							String name= rs2.getString("crimeName");
							String date= rs2.getString("date");
							String place= rs2.getString("place");
							String vic= rs2.getString("victim");
							String description= rs2.getString("description");
							String suspect= rs2.getString("suspected");
							String sta= rs2.getString("status");
							
							crime= new Crime(count,name,date,place,vic,description,suspect,sta);
							
					
				        }else {
							throw new CrimeException("There is no record present with given details");
						}
				     }else {
							throw new CrimeException("There is no record present with given details");
						}
			     }
				
			
			} else {
				throw new CrimeException("There is no record present with given details");
			}
			
			
			}  catch (SQLException e) {
				
			throw new CrimeException(e.getMessage());
		    }
		return crime;
	}

	@Override
	public Crime changeStatus(String crimeName, String victim, String suspected, String status) throws CrimeException {
		
		Crime crime= null;
		
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("update crime set status=?  where crimeName=? AND victim=? AND suspected=?");
			ps.setString(1, status);
			ps.setString(2, crimeName);
			ps.setString(3, victim);
			ps.setString(4, suspected);
			
			int x= ps.executeUpdate();
			
			if(x>0) {
				PreparedStatement ps2= conn.prepareStatement("select * from crime where crimeName=? AND victim=? AND suspected=?");
				
				ps2.setString(1, crimeName);
				ps2.setString(2, victim);
				ps2.setString(3, suspected);
				
				ResultSet rs= ps2.executeQuery();
				
				if(rs.next()) {
				
					int count= rs.getInt("crimeno");
					String name= rs.getString("crimeName");
					String date= rs.getString("date");
					String place= rs.getString("place");
					String vic= rs.getString("victim");
					String description= rs.getString("description");
					String suspect= rs.getString("suspected");
					String sta= rs.getString("status");
					
					crime= new Crime(count,name,date,place,vic,description,suspect,sta);
					
				}
				
			} else {
				throw new CrimeException("No record of crime present with given details");
			}
			
			
		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		return crime;
	}

	@Override
	public Crime changeStatus(String crimeName, String victim, String suspected) throws CrimeException {
		Crime crime= null;
		
        try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("update crime set status='Solved'  where crimeName=? AND victim=? AND suspected=?");
		
			ps.setString(1, crimeName);
			ps.setString(2, victim);
			ps.setString(3, suspected);
			
			int x= ps.executeUpdate();
			
			if(x>0) {
				PreparedStatement ps2= conn.prepareStatement("select * from crime where crimeName=? AND victim=? AND suspected=?");
				
				ps2.setString(1, crimeName);
				ps2.setString(2, victim);
				ps2.setString(3, suspected);
				
				ResultSet rs= ps2.executeQuery();
				
				if(rs.next()) {
					int count= rs.getInt("crimeno");
					String name= rs.getString("crimeName");
					String date= rs.getString("date");
					String place= rs.getString("place");
					String vic= rs.getString("victim");
					String description= rs.getString("description");
					String suspect= rs.getString("suspected");
					String sta= rs.getString("status");
					
					crime= new Crime(count,name,date,place,vic,description,suspect,sta);
					
				}
				
			} else {
				throw new CrimeException("No record of crime present with given details");
			}
			
			
		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		
		
		return crime;
	}

	@Override
	public String showStatus(String crimeName, String victim, String suspected) throws CrimeException {
		
		String message= "There is some error in showing status";
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select status from crime where crimeName=? AND victim=? AND suspected=?");
			
			ps.setString(1, crimeName);
			ps.setString(2, victim);
			ps.setString(3, suspected);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				message= rs.getString("status");
				
			} else {
				throw new CrimeException("There is no record present with given details");
			}
			
		} catch (SQLException e) {
			message= e.getMessage();
		}
		
		return message;
	}

	@Override
	public List<CrimeDTO> areawiseCrime() throws CrimeException {
		List<CrimeDTO> crimesDto= new ArrayList<>();
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select place, crimeName, suspected  from crime group by place, crimeName, suspected");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				String place= rs.getString("place");
				String crimeName= rs.getString("crimeName");
				String criminal= rs.getString("suspected");
				
				CrimeDTO cdt= new CrimeDTO(place, crimeName, criminal);
				
				crimesDto.add(cdt);
			} 
			
			if(crimesDto.size()==0){
				throw new CrimeException("There is no record present");
			}
			
		} catch (SQLException e) {
			
			throw new CrimeException(e.getMessage());
			
			
		}
		
		
		return crimesDto;
		
		
	}

	@Override
	public Crime searchCrime(String crimeName, String victim, String suspected) throws CrimeException {

        Crime crime= null;
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from crime where crimeName=? AND victim=? AND suspected=?");
			
			ps.setString(1, crimeName);
			ps.setString(2, victim);
			ps.setString(3, suspected);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {

				int count= rs.getInt("crimeno");
				String name= rs.getString("crimeName");
				String date= rs.getString("date");
				String place= rs.getString("place");
				String vic= rs.getString("victim");
				String description= rs.getString("description");
				String suspect= rs.getString("suspected");
				String sta= rs.getString("status");
				
				crime= new Crime(count,name,date,place,vic,description,suspect,sta);
				
			} else{
				throw new CrimeException("There is no record present with such detail");
			}
			
			} catch (SQLException e) {
				throw new CrimeException(e.getMessage());
			}
			
			return crime;
		
	}

	@Override
	public int countCase(String status) throws CrimeException {
		int count=0;
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select count(*) from crime where status= ?");
			ps.setString(1, status);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				int num= rs.getInt("count(*)");
				
				count= num;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public List<Crime> currentMonthCrime() throws CrimeException {
		List<Crime> crimes= new ArrayList<>();
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from crime where Month(date) = Month(sysdate()) AND Year(date) = Year(sysdate())");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {

				int count= rs.getInt("crimeno");
				String name= rs.getString("crimeName");
				String date= rs.getString("date");
				String place= rs.getString("place");
				String vic= rs.getString("victim");
				String description= rs.getString("description");
				String suspect= rs.getString("suspected");
				String sta= rs.getString("status");
				
				Crime crime= new Crime(count,name,date,place,vic,description,suspect,sta);
				crimes.add(crime);
				
			}
			
			if(crimes.size()==0) {
				throw new CrimeException("There is no crime in current month.");
			}
			
		} catch (SQLException e) {
			
			throw new CrimeException(e.getMessage());
		}
		
		return crimes;
	}

	
	
	

}
