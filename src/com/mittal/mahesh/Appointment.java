package com.mittal.mahesh;

public class Appointment {
	
	private int appId;
	private int pat_id;
	private int dr_id;
	private String date;
	private String appTime;
	private String reason;
	public Appointment(int appId, int pat_id, int dr_id, String date, String appTime, String reason) {
		
		this.appId = appId;
		this.pat_id = pat_id;
		this.dr_id = dr_id;
		this.date = date;
		this.appTime = appTime;
		this.reason = reason;
	}
	public Appointment(int pat_id, int dr_id, String date, String appTime, String reason) {
		super();
		this.pat_id = pat_id;
		this.dr_id = dr_id;
		this.date = date;
		this.appTime = appTime;
		this.reason = reason;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getPat_id() {
		return pat_id;
	}
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	public int getDr_id() {
		return dr_id;
	}
	public void setDr_id(int dr_id) {
		this.dr_id = dr_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAppTime() {
		return appTime;
	}
	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Appointment [appId=" + appId + ", pat_id=" + pat_id + ", dr_id=" + dr_id + ", date=" + date
				+ ", appTime=" + appTime + ", reason=" + reason + "]";
	}
	
	
	
	
	
	
	

}
