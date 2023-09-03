package com.instructor.app.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instructor.app.controller.InstructorController;
import com.instructor.app.dao.InstructorDAO;
//import com.instructor.app.dao.InstructorDAO;
import com.instructor.app.entity.Course;
import com.instructor.app.entity.Instructor;
import com.instructor.app.entity.InstructorDtl;
import com.instructor.app.entity.Review;
import com.instructor.app.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

//	@Autowired 
//	private InstructorRepository instructorRepository;
	
	@Autowired
	private InstructorDAO instructorDAO;
	private final Logger logger = Logger.getLogger(InstructorServiceImpl.class.getName());
	@Override
	@Transactional
	public List<Instructor> getInstructors() {
		// TODO Auto-generated method stub
		return instructorDAO.getInstructors();
	}
 
	@Override
	@Transactional
	public void addInstructor(Instructor instructor,InstructorDtl instructorDetails,Course course,Review review) {
		logger.info("Inside Instructor Service : "+instructor+" "+instructorDetails+" "+course+" "+review);
		instructorDAO.addInstructor(instructor,instructorDetails,course,review);
		
	}
//
//	@Override
//	@Transactional
//	public void delete(int id) {
//		instructorDAO.delete(id);		
//	}
//
//	@Override
//	@Transactional
//	public List<Instructor> searchInstructor(String search_id_name) {
//		return instructorDAO.searchInstructor(search_id_name);
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	@Transactional
//	public Instructor getInstructor(int id) {
//		return instructorDAO.getInstructor(id);
//		
//	}
}
