package com.mittal.mahesh;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController") 
public class HomeController extends HttpServlet {
	
	@Resource(name="jdbc/appointment_Schedular")
	private DataSource dataSource;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	PatientDatabaseUtil patientDatabaseUtil;
	  
	public void init() throws ServletException {
		
		this.patientDatabaseUtil= new PatientDatabaseUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 
	 */
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");	
 		 try {
			 	
			 	if(command==null) {
			 		command= "home";
			 	}
			 	
			 	switch(command) {
			 	
			 	case "home": 
			 		homePage(request, response);
			 		break;
				case "cancel": 
			 		cancelAppointment(request, response);
			 		break;
			 		
			 	}
			 	
		 }catch(Exception e) {
			 e.printStackTrace(); 
			 }
		 }
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String date= req.getParameter("date");
		String command= req.getParameter("command");   
 		try {

 			if("logout".equals(command)) {
 				HttpSession session=req.getSession();  
 			    session.invalidate();
 		        RequestDispatcher rd=req.getRequestDispatcher("login.jsp?message=You are successfully logged out!");  
 		        rd.include(req,resp);
 			}
 			
 			else if("login".equals(command)) {
 				login(req, resp);
 			} 
 			else if("update".equals(command)) {
 				patientProfileUpdate(req,resp);
 			}
 			else if("pass".equals(command)) {
 				patientPasswordChange(req,resp);
 			}
 			else if("insurance".equals(command)) {
 				patientInsuranceUpdate(req,resp);
 			}
 			
 			else if("register".equals(command)) {
 				patientRegistration(req,resp);
 			}
 			
 			else if(("makeApt").equals(command)) {
 			saveAppointment(req,resp);
			
			}
		
			else if(date!=null && !date.equals("") ) {
			
			getdates(req,resp);
			
			}
		
			else {
				
			getDoc(req,resp);
			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void cancelAppointment(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String appid= request.getParameter("appid");
		int app_id=Integer.parseInt(appid);
		String patid=request.getParameter("pat_id");
		int pat_id= Integer.parseInt(patid);
		int check= patientDatabaseUtil.cancelUpcomingAppointments(app_id);
		
			if(check>=1)
			{ 
				Patient thepatient=patientDatabaseUtil.getPatient(pat_id);
				List<Appointment> theapp=patientDatabaseUtil.getPreviousAppointments(pat_id);
				List<Appointment> fapp=patientDatabaseUtil.getFutureAppointments(pat_id);
				List<Message> themsg = patientDatabaseUtil.getMessages(thepatient.getId());
				request.setAttribute("thePatient", thepatient);
				request.setAttribute("theapp", theapp);
				request.setAttribute("fapp", fapp);
				request.setAttribute("themsg", themsg); 
				RequestDispatcher rd=request.getRequestDispatcher("PatieProfile.jsp?message3=Appointment Cancelled!");  
		        rd.include(request,response);
				
				
			}
		
	}

	

	private void patientInsuranceUpdate(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String patid=req.getParameter("pat_id");
		int id = Integer.parseInt(patid);
		String group=req.getParameter("newinsgroup");
		String insid=req.getParameter("newinsid");
		
 		
		int check= patientDatabaseUtil.updateInsurance(group, insid, id);
		if(check>=1)
		{
			Patient thepatient=patientDatabaseUtil.getPatient(id);
			List<Appointment> theapp=patientDatabaseUtil.getPreviousAppointments(id);
			List<Appointment> fapp=patientDatabaseUtil.getFutureAppointments(id);
			List<Message> themsg = patientDatabaseUtil.getMessages(id);
			req.setAttribute("thePatient", thepatient);
			req.setAttribute("theapp", theapp);
			req.setAttribute("fapp", fapp);
			req.setAttribute("themsg", themsg); 
			RequestDispatcher rd=req.getRequestDispatcher("PatieProfile.jsp?message3=Insurance  updated succesfully");  
	        rd.include(req,resp);
		}
		
	}

	private void patientPasswordChange(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String patid=req.getParameter("pat_id");
		int id = Integer.parseInt(patid);
		String newpass=req.getParameter("newpassword");
		
		int check= patientDatabaseUtil.updatePassword(newpass, id);
		if(check>=1)
		{
			Patient thepatient=patientDatabaseUtil.getPatient(id);
			List<Appointment> theapp=patientDatabaseUtil.getPreviousAppointments(id);
			List<Appointment> fapp=patientDatabaseUtil.getFutureAppointments(id);
			List<Message> themsg = patientDatabaseUtil.getMessages(id);
			req.setAttribute("thePatient", thepatient);
			req.setAttribute("theapp", theapp);
			req.setAttribute("fapp", fapp);
			req.setAttribute("themsg", themsg); 
			RequestDispatcher rd=req.getRequestDispatcher("PatieProfile.jsp?message3=Password changed succesfully");  
	        rd.include(req,resp);
		}
		
	}

	private void patientProfileUpdate(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String patid=req.getParameter("pat_id");
		int id = Integer.parseInt(patid);
		String first=req.getParameter("first_name");
		String last=req.getParameter("last_name");
		String dob=req.getParameter("dob");
		String emailid=req.getParameter("email");
		String ssn=req.getParameter("ssn");
		String address=req.getParameter("address");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String zip=req.getParameter("zip");
		
		Patient pat= new Patient(id,first, last, dob, emailid, ssn, address, city, state, zip);
		
		int check= patientDatabaseUtil.updatePatient(pat);
		if(check>=1)
		{
			Patient thepatient=patientDatabaseUtil.getPatient(id);
			List<Appointment> theapp=patientDatabaseUtil.getPreviousAppointments(id);
			List<Appointment> fapp=patientDatabaseUtil.getFutureAppointments(id);
			List<Message> themsg = patientDatabaseUtil.getMessages(id);
			req.setAttribute("thePatient", thepatient);
			req.setAttribute("theapp", theapp);
			req.setAttribute("fapp", fapp);
			req.setAttribute("themsg", themsg); 
			RequestDispatcher rd=req.getRequestDispatcher("PatieProfile.jsp?message3=Profile details updated succesfully");  
	        rd.include(req,resp);
		}
		
	}

	private void patientRegistration(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String first=req.getParameter("fname");
		String last=req.getParameter("lname");
		String dob=req.getParameter("dob");
		String emailid=req.getParameter("emailid");
		String pass=req.getParameter("pass");
		String ssn=req.getParameter("ssn");
		String address=req.getParameter("address");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String zip=req.getParameter("zip");
		String ins=req.getParameter("insCoN");
		String groupid=req.getParameter("groupid");
		
		Patient pat= new Patient(first, last, dob, emailid, pass, ssn, address, city, state, zip, ins, groupid);
		
		int check = patientDatabaseUtil.savePatient(pat);
		if(check>=1)
		{
			
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp?message1=Welcome " + first +" ! you are succesfully registered" );  
			rd.include(req,resp);
		}
		
	}

	private void saveAppointment(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String patid=req.getParameter("patid");
		int pat_id=Integer.parseInt(patid);
		String doctorid=req.getParameter("doctor");
		int doc_id= Integer.parseInt(doctorid);
		String date=req.getParameter("date");
		String time=req.getParameter("time");
		String reason=req.getParameter("reason");
		
		Appointment appointment= new Appointment(pat_id, doc_id, date, time, reason);
		
		int check = patientDatabaseUtil.saveAppointment(appointment);
		if(check>=1)
		{	
			Patient thepatient=patientDatabaseUtil.getPatient(pat_id);
			List<Appointment> theapp=patientDatabaseUtil.getPreviousAppointments(pat_id);
			List<Appointment> fapp=patientDatabaseUtil.getFutureAppointments(pat_id);
			List<Message> themsg = patientDatabaseUtil.getMessages(thepatient.getId());
			req.setAttribute("thePatient", thepatient);
			req.setAttribute("theapp", theapp);
			req.setAttribute("fapp", fapp);
			req.setAttribute("themsg", themsg); 
		RequestDispatcher rd=req.getRequestDispatcher("PatieProfile.jsp?message3=Your Appoinment confirmation sent to your inbox!");  
	    rd.include(req,resp);
		}
		
	}
  
	private void getDoc(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/plain");
		List<Doctor> doc= patientDatabaseUtil.getDoctor();
		resp.getWriter().write("<select name='doctor' id='aptdoctor'>");
		resp.getWriter().write("<option disabled selected>Select Doctor</option>");
		for(Doctor temp:doc)
		{	
 			resp.getWriter().write("<option value="+temp.getDr_id()+">"+temp.getFirstname()+"</option>");
			
			
		}
		resp.getWriter().write("</select>");
		
	}

	private void getdates(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String date= req.getParameter("date");
		resp.setContentType("text/plain");
 		List<Time> time = patientDatabaseUtil.getAvailableTime(date);
		resp.getWriter().write("<select name='time' id='apttime'>");
		resp.getWriter().write("<option disabled selected>Select Appointment Type</option>");
		for(Time temp:time)
		{	
			
 			resp.getWriter().write("<option value="+temp.getFixed_value()+">"+temp.getFixed_value()+"</option>");
			
			
		}
		resp.getWriter().write("</select>");
	}
	

	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user=request.getParameter("emailid");
		String pass=request.getParameter("pass");
		Patient thepatient=patientDatabaseUtil.login(user,pass);
		HttpSession session=request.getSession();

		if(thepatient!=null) {
			
			List<Appointment> theapp=patientDatabaseUtil.getPreviousAppointments(thepatient.getId());
			List<Appointment> fapp=patientDatabaseUtil.getFutureAppointments(thepatient.getId());

			List<Message> themsg = patientDatabaseUtil.getMessages(thepatient.getId());

			session.setAttribute("pat_id",thepatient.getId());
			request.setAttribute("thePatient", thepatient);
			request.setAttribute("theapp", theapp);
			request.setAttribute("fapp", fapp);

			request.setAttribute("themsg", themsg);
			 
			RequestDispatcher dispatcher= request.getRequestDispatcher("/PatieProfile.jsp");
			dispatcher.forward(request, response);  
 		}
		else
		{ 
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp?message2=Please enter correct username or password!");  
			rd.forward(request, response);		

		}
		
		
		
	}

	private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		
		dispatcher.forward(request, response);		
		
	}
	
	
	
}
