package com.mittal.mahesh;

public class Patient {
	private int id;
	private String firstName;
	private String lastName;
	private String dateofbirth;
	private String email;
	private String password;
	private String ssn;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String insuranceCompany;
	private String insuranceId;
	private String status;
	
	public Patient(int id, String firstName, String lastName, String dateofbirth, String email, String password,
			String ssn, String address, String city, String state, String zip, String insurance, String insuranceId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.password = password;
		this.ssn = ssn;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.insuranceCompany = insurance;
		this.insuranceId = insuranceId;
		this.status ="1";
	}
	
	
	
	
	
	

	public Patient(int id, String firstName, String lastName, String dateofbirth, String email, String ssn,
			String address, String city, String state, String zip) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.ssn = ssn;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}







	public Patient(String firstName, String lastName, String dateofbirth, String email, String password, String ssn,
			String address, String city, String state, String zip, String insuranceCompany, String insuranceId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.password = password;
		this.ssn = ssn;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.insuranceCompany = insuranceCompany;
		this.insuranceId = insuranceId;
		this.status="1";
	}







	public String getStatus() {
		return status;
	}







	public void setStatus(String status) {
		this.status = status;
	}







	public String getInsuranceCompany() {
		return insuranceCompany;
	}





	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}





	public String getInsuranceId() {
		return insuranceId;
	}





	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}





	 



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	 



	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateofbirth="
				+ dateofbirth + ", email=" + email + ", password=" + password + ", ssn=" + ssn + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", insurance=" + insuranceCompany + "]";
	}
	
	
	
	
	

}
