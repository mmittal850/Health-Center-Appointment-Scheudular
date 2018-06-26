package com.mittal.mahesh;

public class Doctor {
	
	private int dr_id;
	private String firstname;
	private String lastname;
	private String spec;
	private String user_id;
	private String password;
	public Doctor(int dr_id, String firstname, String lastname, String spec, String user_id, String password) {
		this.dr_id = dr_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.spec = spec;
		this.user_id = user_id;
		this.password = password;
	}
	public Doctor(int dr_id, String firstname, String lastname) {
		this.dr_id = dr_id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public int getDr_id() {
		return dr_id;
	}
	public void setDr_id(int dr_id) {
		this.dr_id = dr_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Doctor [dr_id=" + dr_id + ", firstname=" + firstname + ", lastname=" + lastname + ", spec=" + spec
				+ ", user_id=" + user_id + ", password=" + password + "]";
	}
	
	
	
	

}
