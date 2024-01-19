package org.jsp.AdminHospitalDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.AdminHospitalDemo.dto.Admin;
import org.jsp.AdminHospitalDemo.dto.Hospital;

@SuppressWarnings("all")
public class HospitalDao {
	
EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();


		public Hospital SaveHospital(Hospital hospital,int admin_id) {
			Admin admin = manager.find(Admin.class, admin_id);
			if(admin!=null) {
				admin.getHospitals().add(hospital);
				hospital.setAdmin(admin);
			
		    EntityTransaction transaction=manager.getTransaction();
			manager.persist(hospital);
			transaction.begin();
			transaction.commit();
			return hospital;
		}
			return null;
		}
		
		public Hospital updateHospital(Hospital hospital ) {
			Hospital dbHospital = manager.find(Hospital.class, hospital.getId());
			if(dbHospital!=null) {
				EntityTransaction transaction = manager.getTransaction();
				dbHospital.setName(hospital.getName());
				dbHospital.setFounder(hospital.getFounder());
				dbHospital.setGst(hospital.getGst());
				dbHospital.setYear_of_esth(hospital.getYear_of_esth());
			    transaction.begin();
			    transaction.commit();
			    return dbHospital;
			}
			return null;
			}
		
		public List<Hospital> FindhospitalByAdminId(int id) {
			Query q = manager.createQuery("select a.hospitals from Admin a where a.id=?1");
			//select h from Hospital h where h.admin.id?1
			
			q.setParameter(1, id);
			
			return q.getResultList();
		}
		
		
		public List<Hospital> FindHospitalByAdminPhonePassword(long phone, String password) {
			Query q=manager.createQuery("select a.hospitals a from Admin a where a.phone=?1 and a.password=?");
			//select h from Hospital h where h.admin.phone=?1 and h.admin.password=?1
			
			q.setParameter(1, phone);
			q.setParameter(2, password);
			return q.getResultList();
		}
		
		public List<Hospital> FindHospitalByAdminEmailPassword(String email, String password) {
			Query q=manager.createQuery("select a.hospitals a from Admin a where a.Email=?1 and a.password=?");
			//select h from Hospital h where h.admin.phone=?1 and h.admin.password=?1
			
			q.setParameter(1, email );
			q.setParameter(2, password);
			return q.getResultList();
		}

		
		
		
		
}
