package com.mittal.mahesh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;




public class PatientDatabaseUtil {
	
	private DataSource datasource;
	
	
	public PatientDatabaseUtil(DataSource datasource) {
		this.datasource = datasource;
	}


	 
	
	public Patient getPatient(int id) throws Exception {
		// TODO Auto-generated method stub
		
		Patient thepatient = null;
		Connection conn= null;
		PreparedStatement stm= null;
		
		try
		{ 
		conn= datasource.getConnection();
		 stm= conn.prepareStatement("select * from registration "
					+ "where pat_id=? ");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			if(rs.next())
			{
				
				int pat_id=rs.getInt(1);
				String firstName= rs.getString(2);
				String lastName= rs.getString(3);
				String dateofbirth= rs.getString(4);
				String email= rs.getString(5);
				String password= rs.getString(6);
				String ssn= rs.getString(7);
				String address= rs.getString(8);
				String city= rs.getString(9);
				String state= rs.getString(10);
				String zip= rs.getString(11);
				String insurance= rs.getString(12);
				String insuranceId=rs.getString(13);
				
				thepatient= new Patient(pat_id, firstName, lastName, dateofbirth, email, password, ssn, address, city, state, zip, insurance,insuranceId);
				
 		
				return thepatient;
				
			}
			
			return thepatient;
		}
		finally {
		
				close(conn,stm,null);
		
				}
		
	}

	public Patient login(String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		
		Patient thepatient = null;
		Connection conn= null;
		PreparedStatement stm= null;
		
		try
		{ 
		conn= datasource.getConnection();
		 stm= conn.prepareStatement("select * from registration "
					+ "where email_id=? and password=?");
			stm.setString(1, user);
			stm.setString(2, pass);
			ResultSet rs = stm.executeQuery();
			if(rs.next())
			{
				
				int id=rs.getInt(1);
				String firstName= rs.getString(2);
				String lastName= rs.getString(3);
				String dateofbirth= rs.getString(4);
				String email= rs.getString(5);
				String password= rs.getString(6);
				String ssn= rs.getString(7);
				String address= rs.getString(8);
				String city= rs.getString(9);
				String state= rs.getString(10);
				String zip= rs.getString(11);
				String insurance= rs.getString(12);
				String insuranceId=rs.getString(13);
				
				thepatient= new Patient(id, firstName, lastName, dateofbirth, email, password, ssn, address, city, state, zip, insurance,insuranceId);
				
 		
				return thepatient;
				
			}
			
			return thepatient;
		}
		finally {
		
				close(conn,stm,null);
		
				}
		
	}
	
	
	
	public List<Appointment> getPreviousAppointments(int patid) throws Exception{
	
		List<Appointment> appointment = new ArrayList<>();
		Connection conn= null;
		PreparedStatement stm= null;
		
		try
		{ 
		conn= datasource.getConnection();
		 stm= conn.prepareStatement("select * from appoinment where date < curdate() and pat_id=?");
			stm.setInt(1,patid);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				
				int id=rs.getInt(1);
				int pat_id= rs.getInt(2);
				int dr_id= rs.getInt(3);
				String date= rs.getString(4);
				String appTime= rs.getString(5);
				String reason= rs.getString(6);
				appointment.add(new Appointment(id, pat_id, dr_id, date, appTime, reason));
			}
			
			
			return appointment;
	
	}
		finally {
			
			close(conn,stm,null);
	
			}

	}
	
	
	public List<Appointment> getFutureAppointments(int patid) throws Exception{
		
		List<Appointment> appointment = new ArrayList<>();
		Connection conn= null;
		PreparedStatement stm= null;
		
		try
		{ 
		conn= datasource.getConnection();
		 stm= conn.prepareStatement("select * from appoinment where date > curdate() and pat_id=?");
			stm.setInt(1,patid);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				
				int id=rs.getInt(1);
				int pat_id= rs.getInt(2);
				int dr_id= rs.getInt(3);
				String date= rs.getString(4);
				String appTime= rs.getString(5);
				String reason= rs.getString(6);
				appointment.add(new Appointment(id, pat_id, dr_id, date, appTime, reason));
			}
			
			
			return appointment;
	
	}
		finally {
			
			close(conn,stm,null);
	
			}
	}
	
	
	
	public int cancelUpcomingAppointments(int app_id) throws Exception{
		
		Connection conn= null;
		PreparedStatement stm= null;
		PreparedStatement stm2= null;

		ResultSet rs=null;
		
		try
		{ 
		conn= datasource.getConnection();
		 stm= conn.prepareStatement("select pat_id, dr_id, date, app_time from sedatabase.appoinment where app_id=?");
			stm.setInt(1,app_id);
			 rs = stm.executeQuery();
			if(rs.next())
			{
				
				int pat_id= rs.getInt(1);
				int dr_id= rs.getInt(2);
				String date= rs.getString(3);
				String appTime= rs.getString(4);
				
				String message="Appointment cancelled for "+date+ " at "+ appTime;
				Message msg= new Message(pat_id, dr_id, message);
				saveAppointmentMessage(msg);
				
			}
			stm2= conn.prepareStatement("delete from sedatabase.appoinment where app_id=?");
			stm2.setInt(1, app_id);
			int a= stm2.executeUpdate();
			stm2.close();
			return a;
	}
		finally {
			
			close(conn,stm,rs);
	
			}

	}
	
	public List<Message> getMessages(int patid) throws Exception{
		
		List<Message> message = new ArrayList<>();
		Connection conn= null;
		PreparedStatement stm= null;
		ResultSet rs=null;
		
		try
		{ 
		conn= datasource.getConnection();
		 stm= conn.prepareStatement("select * from message "
					+ "where pat_id=?");
			stm.setInt(1,patid);
			 rs = stm.executeQuery();
			while(rs.next())
			{
				
				int id=rs.getInt(1);
				int pat_id= rs.getInt(2);
				int dr_id= rs.getInt(3);
				String msg= rs.getString("message");
 				message.add(new Message(id, pat_id, dr_id, msg));
			}
			
			
			return message;
	
	}
		finally {
			
			close(conn,stm,rs);
	
			}

	}
	
public List<Time> getAvailableTime(String date) throws Exception{
		
		List<Time> time = new ArrayList<>();
		Connection conn= null;
		PreparedStatement stm= null;
		ResultSet rs=null;
		
		try
		{ 
		conn= datasource.getConnection();
		 stm= conn.prepareStatement("select time_id, fixed_value from sedatabase.time as t  where not exists (select app_time from sedatabase.appoinment as a where date =? and t.fixed_value =a.app_time)");
			stm.setString(1,date);
			rs = stm.executeQuery();
			while(rs.next())
			{
				
				int time_id=rs.getInt(1);
				String fixed_value= rs.getString(2);
				
				
				time.add(new Time(time_id, fixed_value));
			}
			
			
			return time;
	
	}
		finally {
			
			close(conn,stm,rs);
	
			}

	}


public List<Doctor> getDoctor() throws Exception{
	
	List<Doctor> doc = new ArrayList<>();
	Connection conn= null;
	PreparedStatement stm= null;
	ResultSet rs=null;

	
	try
	{ 
	conn= datasource.getConnection();
	 stm= conn.prepareStatement(" select dr_id,firstname, lastname from sedatabase.doctordata");
		 rs = stm.executeQuery();
		while(rs.next())
		{
			
			int dr_id=rs.getInt(1);
			String firstname= rs.getString(2);
			String lastname= rs.getString(3);
			
			doc.add(new Doctor(dr_id, firstname, lastname));
		}
		
		
		return doc;

}
	finally {
		
		close(conn,stm,rs);

		}

}



public int saveAppointment(Appointment appointment) throws Exception {
	Connection conn= null;
	PreparedStatement pstmt= null;
	int pat_id= appointment.getPat_id();
	int doc_id= appointment.getDr_id();
	String date=appointment.getDate();
	String time=appointment.getAppTime();
	
	try {
		conn= datasource.getConnection();
		String sql= "insert into sedatabase.appoinment values(?,?,?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, 0);
		pstmt.setInt(2, pat_id);
		pstmt.setInt(3, doc_id);
		pstmt.setString(4, date);
		pstmt.setString(5, time);
		pstmt.setString(6, appointment.getReason());
		
		
		int i =pstmt.executeUpdate();
		
		if(i>=1)
		{
			
				String message= "You have appointment on " +date+ " at " +time;
				Message msg = new Message(pat_id,doc_id,message);
				int a=	saveAppointmentMessage(msg);
				
					return a;
				
			
			
		}
		
		return 0;
	
	}
	finally {
		
	close(conn,pstmt,null);
		
	}
	
}

	public int saveAppointmentMessage(Message msg) throws Exception {
		
		Connection conn= null;
		PreparedStatement stm= null;
		
		try {
			conn= datasource.getConnection();
			String sql= "insert into sedatabase.message values(?,?,?,?)";
			stm=conn.prepareStatement(sql);
			stm.setInt(1, 0);
			stm.setInt(2, msg.getPat_id());
			stm.setInt(3, msg.getDr_id());
			stm.setString(4,msg.getMessage());
			
			int a=stm.executeUpdate();
			return a;
		}
		finally {
			
		close(conn,stm,null);
			
		}	
	
	}




	public int savePatient(Patient pat) throws Exception {
		Connection conn= null;
		PreparedStatement stm= null;
		
		try
		{ 
		conn= datasource.getConnection();

		stm= conn.prepareStatement("insert into sedatabase.registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		stm.setInt(1, 0);
		stm.setString(2, pat.getFirstName());
		stm.setString(3, pat.getLastName());
		stm.setString(4, pat.getDateofbirth()); 
		stm.setString(5, pat.getEmail());
		stm.setString(6, pat.getPassword());
		stm.setString(7, pat.getSsn());
		stm.setString(8, pat.getAddress());
		stm.setString(9,pat.getCity());
		stm.setString(10, pat.getState());
		stm.setString(11, pat.getZip());
		stm.setString(12, pat.getInsuranceCompany());
		stm.setString(13,pat.getInsuranceId());
		stm.setString(14, pat.getStatus());
		
		int check =stm.executeUpdate();
			
			
		return check;
		}
		finally {
		
				close(conn,stm,null);
		
				}
		
	}




	public int updatePatient(Patient pat) throws Exception {
		Connection conn= null;
		PreparedStatement stm= null;
		
		try
		{ 
		conn= datasource.getConnection();

		stm= conn.prepareStatement("update sedatabase.registration set firstname=?, lastname=?, bob=?, email_id=?, ssn=?, address=?, city=?, state=?, zip=? where pat_id=?");
		
		stm.setString(1, pat.getFirstName());
		stm.setString(2, pat.getLastName());
		stm.setString(3, pat.getDateofbirth()); 
		stm.setString(4, pat.getEmail());
		stm.setString(5, pat.getSsn());
		stm.setString(6, pat.getAddress());
		stm.setString(7,pat.getCity());
		stm.setString(8, pat.getState());
		stm.setString(9, pat.getZip());
		stm.setInt(10, pat.getId());
		int check =stm.executeUpdate();
			
			
		return check;
		}
		finally {
		
				close(conn,stm,null);
		
				}
		
	}
	
	
	public int updateInsurance(String insuranceCompany,String insuranceid,int id) throws Exception {
		Connection conn= null;
		PreparedStatement stm= null;
		
		try
		{ 
		conn= datasource.getConnection();

		stm= conn.prepareStatement("update sedatabase.registration set insurancecompany=?, insuranceid=? where pat_id=?");
		
		stm.setString(1, insuranceCompany);
		stm.setString(2, insuranceid);
		stm.setInt(3, id);
		int check =stm.executeUpdate();
			
			
		return check;
		}
		finally {
		
				close(conn,stm,null);
		
				}
		
	}
	
	
	
	public int updatePassword(String pass,int id) throws Exception {
		Connection conn= null;
		PreparedStatement stm= null;
		
		try
		{ 
		conn= datasource.getConnection();

		stm= conn.prepareStatement("update sedatabase.registration set password=?  where pat_id=?");
		
		stm.setString(1, pass);
		stm.setInt(2, id);
		int check =stm.executeUpdate();
			
			
		return check;
		}
		finally {
		
				close(conn,stm,null);
		
				}
		
	}
	
	private void close(Connection conn, Statement stm, ResultSet rs) throws Exception {
		if(conn != null) {
			conn.close();
		}
		
		if(stm != null) {
			stm.close();
		}
		
		if(rs != null) {
			
			rs.close();
		}
	}

	
	
	
}