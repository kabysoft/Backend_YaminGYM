package com.yamin.gym.admin.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.yamin.gym.admin.model.batches;
import com.yamin.gym.dao.DAO;
import com.yamin.gym.utility.DBUtility;

public class batchesDAO implements DAO<batches>{
	
	DBUtility db = DBUtility.getDBUtility();

	@Override
	public List<batches> getAll() {
		List<batches> batcheList  = new ArrayList<batches>();
		try {
		String sql = "select * from batches";
		ResultSet res = db.executeQuery(sql);
		while(res.next()) {
			batches batche = new batches();
			batche.setBatche_Id(res.getInt("batche_Id"));
			batche.setBatche_time(res.getString("batche_time"));
			batche.setParticipantId(res.getInt("participantId"));
						
			batcheList.add(batche);
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Something went wrong :: " + e.getMessage());
	}

		return batcheList;
	}

		@Override
	public batches getOne(long id) {
	     batches  batche = new batches();
	     try {
	    	 String sql = "select * from  where batches = "+id;
				ResultSet res = db.executeQuery(sql);
				// object mapping
				if(res.next()) {
					batche.setBatche_Id(res.getInt("batche_Id"));
					batche.setBatche_time(res.getString("batche_time"));
					batche.setParticipantId(res.getInt("participantId"));
					}
			} catch (Exception e) {
				System.out.println("Something went wrong :: " + e.getMessage());
			}
			return batche;
		}

	@Override
	public void save(batches obj) {
		try {
			String sql = "insert into batches (batche_time) values ('"+obj.getBatche_time();
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Bathes record saved successfully" : "Unable to save Bathces data.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e.getMessage());
		}		
	}

	@Override
	public void update(batches obj) {
		try {
			String sql = "update ADMINS set batche_time = '"+obj.getBatche_time()+" where adminId = "+obj.getBatche_Id();   
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Batches record updated successfully" : "Unable to update Batches data.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e.getMessage());
		}	
		
	}
	@Override
	public void delete(long id) {
		try {
			String sql = "delete from bathces where batche_Id = " + id;
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Batches record deleted successfully" : "Unable to delete Batches data.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e.getMessage());
		}	
		
	}

}