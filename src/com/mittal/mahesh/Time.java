package com.mittal.mahesh;

public class Time {
	
	private int time_id;
	private String fixed_value;
	public Time(int time_id, String fixed_value) {
		this.time_id = time_id;
		this.fixed_value = fixed_value;
	}
	public int getTime_id() {
		return time_id;
	}
	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}
	public String getFixed_value() {
		return fixed_value;
	}
	public void setFixed_value(String fixed_value) {
		this.fixed_value = fixed_value;
	}
	@Override
	public String toString() {
		return "Time [time_id=" + time_id + ", fixed_value=" + fixed_value + "]";
	}
	
	

}
