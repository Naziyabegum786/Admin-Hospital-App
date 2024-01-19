package org.jsp.Controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.AdminHospitalDemo.dao.AdminDao;
import org.jsp.AdminHospitalDemo.dao.HospitalDao;
import org.jsp.AdminHospitalDemo.dto.Admin;
import org.jsp.AdminHospitalDemo.dto.Hospital;

public class AdminHospitalController {
static AdminDao adminDao=new AdminDao();
static HospitalDao hospitalDao=new HospitalDao();
static Scanner s=new Scanner(System.in);


	public static void main(String[] args) {
	System.out.println("1.Save Admin");
	System.out.println("2. Update Admin");
	System.out.println("3. Find Admin By Id");
	System.out.println("4. Verify Admin By phone and Password");
    System.out.println("5. Verify Admin By Email and password");
	System.out.println("6.Add Hospital");
	System.out.println("7.Update Hospital");
	System.out.println("8. Find Hospital By Admin Id");
	System.out.println("9. Find Hospital By Admin phone and password");
	System.out.println("10. Find Hospital By Admin email and password");
	switch (s.nextInt()) {
	case 1:{
		save();
		break;
	}
	case 2:{
		update();
		break;
	}
	case 3:{
		saveHospital();
		break;
	}
	case 4:{
		updateHospital();
		break;
	}
	case 5:{
		findHospitalsByAdminId();
		break;
	}
	
	case 6:{
		findHospitalByAdminPhonePassword();
		break;
	}
	case 7:{
		findHospitalsByAdminEmailPassword();
		break;
}
	}
	}
	public static void save() {
		System.out.println("Enter the name,phone,email and password to register");
		Admin admin = new Admin();
		admin.setName(s.next());
		admin.setPhone(s.nextLong());
		admin.setEmail(s.next());
		admin.setPassword(s.next());
		admin = adminDao.SaveAdmin(admin);
		System.out.println("Admin registered with Id:" + admin.getId());

	}
	public static void update() {
		System.out.println("Enter the Admin Id to update");
		int id=s.nextInt();
		System.out.println("Enter The Name, Phone, Email and password to register ");
		Admin admin=new Admin();
		admin.setId(id);
		admin.setName(s.next());
		admin.setPhone(s.nextLong());
		admin.setEmail(s.next());
		admin.setPassword(s.next());
		admin=adminDao.updateAdmin(admin);
		if(admin!=null)
			System.out.println("Admin with Id:"+admin.getId()+"is updated");
		else
			System.out.println("Cannot Update Admin as the Entered Id is Invalid");
	}
	
	

public static void saveHospital() {
	System.out.println("Enter the Admin Id to add Hospital");
	int admin_id=s.nextInt();
	
	System.out.println("Enter the name, founder,gst number and year of establishment");
	Hospital h=new Hospital();
	h.setName(s.next());
	h.setFounder(s.next());
	h.setGst(s.next());
	h.setYear_of_esth(s.nextInt());
	h=hospitalDao.SaveHospital(h, admin_id);
	
	if(h!=null) 
		System.out.println("Hospital saved with Id:"+h.getId());
	
	else 
		System.err.println("Cannot find as Admin Id is invalid");
	
}

public static void updateHospital() {
	System.out.println("Enter the Hospital Id to update");
	int id = s.nextInt();
	System.out.println("Enter the name,founder,gst number and year of establsihment to add Hospital");
	Hospital h = new Hospital();
	h.setId(id);
	h.setName(s.next());
	h.setFounder(s.next());
	h.setGst(s.next());
	h.setYear_of_esth(s.nextInt());
	h = hospitalDao.updateHospital(h);
	if (h != null)
		System.out.println("Hospital  with Id:" + h.getId() + " updated");
	else
		System.err.println("Cannot update hospital as  Id is Invalid");
}


       public static void findHospitalByAdminPhonePassword() {
		System.out.println("Enter the Admin phone and password to find Hospital");
		long phone=s.nextLong();
		String password = s.next();
		List<Hospital> hospitals = hospitalDao.FindHospitalByAdminPhonePassword(phone, password);
		if(hospitals.size()>0) {
			for(Hospital h: hospitals) {
				System.out.println("Hospitals Id:"+h.getId());
				System.out.println("Hospitals Name:"+h.getName());
				System.out.println("Founder:"+h.getFounder());
				System.out.println("GST Number:"+h.getGst());
				System.out.println("Year of Establishement:"+h.getYear_of_esth());
				System.out.println("-------------------------------------------");
			}
			}
			else{
				System.out.println("Invalid phone number and password ");
			}
		}
       
     
       public static void findHospitalsByAdminEmailPassword() {
   		System.out.println("Enter the Admin Email Id and password to find Hospitals");
   		String email = s.next();
   		String password = s.next();
   		List<Hospital> hospitals = hospitalDao.FindHospitalByAdminEmailPassword(email, password);
   		if (hospitals.size() > 0) {
   			for (Hospital h : hospitals) {
   				System.out.println("Hospital Id:" + h.getId());
   				System.out.println("Hospital Name:" + h.getName());
   				System.out.println("Founder:" + h.getFounder());
   				System.out.println("GST Number:" + h.getGst());
   				System.out.println("Year of establishment:" + h.getYear_of_esth());
   				System.out.println("_------------------------------");
   			}
   		} else {
   			System.err.println("Invalid Email Id or Password");
   		}
   	}
       public static void findHospitalsByAdminId() {
   		System.out.println("Enter the Admin Id to find Hospitals");
   		int admin_id = s.nextInt();
   		List<Hospital> hospitals = hospitalDao.FindhospitalByAdminId(admin_id);
   		if (hospitals.size() > 0) {
   			for (Hospital h : hospitals) {
   				System.out.println("Hospital Id:" + h.getId());
   				System.out.println("Hospital Name:" + h.getName());
   				System.out.println("Founder:" + h.getFounder());
   				System.out.println("GST Number:" + h.getGst());
   				System.out.println("Year of establishment:" + h.getYear_of_esth());
   				System.out.println("_------------------------------");
   			}
   		} else {
   			System.err.println("Invalid Admin Id");
   		}
   	}   
       
	}



