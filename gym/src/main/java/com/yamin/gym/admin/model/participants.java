package com.yamin.gym.admin.model;

import java.util.Date;

public class participants {
	
	int participantId;
	String first_name;
	String last_name;
	String d_o_birth;
	String email;
	String adress;
	long phone;
	Date addedOn;
	
	//default constructor
	
	public participants() {
		
	}

	//parameterized Constructor
	
	public participants(int participantId, String first_name, String last_name, String d_o_birth, String email,
			String adress, long phone, Date addedOn) {
		super();
		this.participantId = participantId;
		this.first_name = first_name;
		this.last_name = last_name;
		this.d_o_birth = d_o_birth;
		this.email = email;
		this.adress = adress;
		this.phone = phone;
		this.addedOn = addedOn;
	}

	// getter and setter methods 
	
	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getD_o_birth() {
		return d_o_birth;
	}

	public void setD_o_birth(String d_o_birth) {
		this.d_o_birth = d_o_birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	//override to String
	
	@Override
	public String toString() {
		return "participants [participantId=" + participantId + ", first_name=" + first_name + ", last_name="
				+ last_name + ", d_o_birth=" + d_o_birth + ", email=" + email + ", adress=" + adress + ", phone="
				+ phone + ", addedOn=" + addedOn + "]";
	}
	
	

	
	
	
	
	

}
