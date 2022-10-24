package com.yamin.gym.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.yamin.gym.admin.model.participants;
import com.yamin.gym.dao.DAO;
import com.yamin.gym.utility.DBUtility;

public class participantsDAO implements DAO<participants> {
	DBUtility db = DBUtility.getDBUtility();
	@Override
	public List<participants> getAll() {
		List<participants> participantList  = new ArrayList<participants>();
		try {
			String sql = "select * from participants";
			ResultSet res = db.executeQuery(sql);
			while(res.next()) {
				participants participant = new participants();
				participant.setParticipantId(res.getInt("participantId"));
				participant.setFirst_name(res.getString("first_name"));
				participant.setLast_name(res.getString("last_name"));
				participant.setD_o_birth(res.getString("d_o_birth"));
				participant.setEmail(res.getString("email"));
				participant.setAdress(res.getString("adress"));
				participant.setPhone(res.getInt("phone"));
				String date = res.getString("addedOn");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date addedOn = format.parse(date);
				participant.setAddedOn(addedOn);
				participantList.add(participant);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong :: " + e.getMessage());
		}
		return participantList;
	}

	@Override
	public participants getOne(long id) {
		participants participant = new participants();
		try {
			String sql = "select * from participants where participantId="+id;
			ResultSet res = db.executeQuery(sql);
			// object mapping
			if(res.next()) {
				participant.setParticipantId(res.getInt("participantId"));
				participant.setFirst_name(res.getString("first_name"));
				participant.setLast_name(res.getString("last_name"));
				participant.setD_o_birth(res.getString("d_o_birth"));
				participant.setEmail(res.getString("email"));
				participant.setAdress(res.getString("adress"));
				participant.setPhone(res.getInt("phone"));
				String date = res.getString("addedOn");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date addedOn = format.parse(date);
				participant.setAddedOn(addedOn);
				
			}
		} catch (Exception e) {
			System.out.println("Something went wrong :: " + e.getMessage());
		}
		return participant;
	}
	@Override
	public void save(participants obj) {
		try {
			String sql = "insert into participants (first_name,last_name, d_o_birth, email,adress,phone,) values ('"+obj.getFirst_name()+"', '"+obj.getLast_name()+"','"+obj.getD_o_birth()
			+"', "+obj.getEmail()+"',"+obj.getAdress()+"',"+obj.getPhone()+")";
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Participants record saved successfully" : "Unable to save Participants data.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e.getMessage());
		}		
	}

	@Override
	public void update(participants obj) {
		try {
			String sql = "update participants set first_name = '"+obj.getFirst_name()+"', last_name ='"+obj.getLast_name()+"', d_o_birth = '"+obj.getD_o_birth()
			+"', email = "+obj.getEmail()+"',adress ='"+obj.getAdress()+"',phone='"+obj.getPhone()+" where adminId = "+obj.getParticipantId();    
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Participants record updated successfully" : "Unable to update Admin data.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e.getMessage());
		}	
		
	}

	@Override
	public void delete(long id) {
		try {
			String sql = "delete from participants where participantId = " + id;
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Participants record deleted successfully" : "Unable to delete Participants data.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e.getMessage());
		}	
		
	}

}