package com.instructor.app.dao;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.*;
import org.hibernate.query.Query;


import com.instructor.app.entity.Course;
import com.instructor.app.entity.Instructor;
import com.instructor.app.entity.InstructorDtl;
import com.instructor.app.entity.Review;
import com.instructor.app.repository.InstructorRepository;

import jakarta.persistence.EntityManager;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Repository
public class InstructorDAOImpl implements InstructorDAO{

	private EntityManager entityManager;
	private final Logger logger = Logger.getLogger(InstructorDAOImpl.class.getName());
	

	public InstructorDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Instructor> getInstructors() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Instructor> query = currentSession.createQuery("from Instructor",Instructor.class);
		logger.info("Query : "+query);
		
		List<Instructor> listLnstructors = query.getResultList();
		for (Iterator<Instructor> iterator = listLnstructors.iterator(); iterator.hasNext();) {
			Instructor instructor = (Instructor) iterator.next();
			logger.info("Instructor Data : "+instructor);
		}
		return listLnstructors;
	}

	
	public void addInstructor(Instructor instructor, InstructorDtl instructorDetails,Course tempCourse,Review tempReview) {
	Session currentSession = entityManager.unwrap(Session.class);
	Query<Instructor> query = currentSession.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1",Instructor.class);
	query.executeUpdate();
	instructor.setInstructorDetail(instructorDetails);
	instructor.add(tempCourse);
	currentSession.saveOrUpdate(instructor);
	logger.info("Instuctor saved : "+instructor);
	int id = instructor.getId();
	instructor = getInstructor(id);
	tempCourse.add(tempReview);
	currentSession.saveOrUpdate(tempCourse); 
	logger.info("Course saved : "+tempCourse);
	logger.info("Record saved in the database");
	
}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Instructor> searchInstructor(String search_id_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Instructor getInstructor(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
//	@SuppressWarnings("unchecked")
//	
//	public Instructor getInstructor(int id) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<Instructor> theQuery = (Query<Instructor>) currentSession.createQuery("from Instructor where id=:theId");
//		theQuery.setParameter("theId",id);
//		Instructor theInstructor = theQuery.getSingleResult();
//		System.out.println(theInstructor);
//		return theInstructor;
//	}
//	@SuppressWarnings("unchecked")
//	
//	public void addInstructor(Instructor theInstructor, InstructorDetail instructorDetails,Course tempCourse,Review tempReview) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<Instructor> query0 = currentSession.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1");
//		query0.executeUpdate();
//		theInstructor.setInstructorDetail(instructorDetails);
//		theInstructor.add(tempCourse);
//		currentSession.saveOrUpdate(theInstructor);
//		int id = theInstructor.getId();
//		theInstructor = getInstructor(id);
//		tempCourse.add(tempReview);
//		System.out.println("Course without review : "+tempCourse);
//		currentSession.saveOrUpdate(tempCourse); 
//		System.out.println("After course : "+theInstructor);
//		System.out.println("Course with review : "+tempCourse);
//		System.out.println("record added to database");
//	}
// 
//	@SuppressWarnings({ "rawtypes", "unchecked" }) 
//	
//	public List<Instructor> searchInstructor(String search_name) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query theQuery = null;
//		if(search_name!=null&&search_name.trim().length()>0) {
//			theQuery=currentSession.createQuery("from Instructor where lower(firstName) like:theName"
//					+ " or lower(lastName) like:theName",Instructor.class);
//			theQuery.setParameter("theName","%"+search_name.toLowerCase()+"%");
//		}
//		else {
//			theQuery = currentSession.createQuery("from Instructor",Instructor.class);
//		}
//		List<Instructor> instructors = theQuery.getResultList();
//		for (Instructor instructor : instructors) {
//			System.out.println(instructor.toString());
//		}
//		return instructors;
//	}
//	@SuppressWarnings("unchecked")
//	
//	public void delete(int id) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<Instructor> query0 = currentSession.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0");
//		query0.executeUpdate();
//		System.out.println("the id is "+id);
//		Query<Instructor> query1 = currentSession.createQuery("delete from Instructor where id=:instructorId");
//		Query<InstructorDetail> query2 = currentSession.createQuery("delete from InstructorDetail where id=:instructorId");
//		Query<Course> query3 = currentSession.createQuery("delete from Course where id=:instructorId");
//		Query<Review> query4 = currentSession.createQuery("delete from Review where id=:instructorId");
//		query1.setParameter("instructorId", id);
//		query2.setParameter("instructorId", id);
//		query3.setParameter("instructorId", id);
//		query4.setParameter("instructorId", id);
//		
//		query1.executeUpdate();
//		query2.executeUpdate();
//		query3.executeUpdate();
//		query4.executeUpdate();
//	}
////	@Override
////	public void deleteAll() {
////		// TODO Auto-generated method stub
////		
////	}
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	
//	
//
//	
}
