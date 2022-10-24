package com.yamin.gym.admin.model;

public class batches {
	
	private int batche_Id;
	private String batche_time;
	private int participantId;
	
	//default constructor
	
	public batches() {
		
	}
	//parameterized Constructor

	public batches(int batche_Id, String batche_time, int participantId) {
		super();
		this.batche_Id = batche_Id;
		this.batche_time = batche_time;
		this.participantId = participantId;
	}
	// getter and setter methods

	public int getBatche_Id() {
		return batche_Id;
	}

	public void setBatche_Id(int batche_Id) {
		this.batche_Id = batche_Id;
	}

	public String getBatche_time() {
		return batche_time;
	}

	public void setBatche_time(String batche_time) {
		this.batche_time = batche_time;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	
	
	//override to String
	@Override
	public String toString() {
		return "batches [batche_Id=" + batche_Id + ", batche_time=" + batche_time + ", participantId=" + participantId
				+ "]";
	}

}
