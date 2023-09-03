package com.instructor.app.service;

import java.util.List;

import com.instructor.app.entity.Course;
import com.instructor.app.entity.Instructor;
import com.instructor.app.entity.InstructorDtl;
import com.instructor.app.entity.Review;

public interface InstructorService {
 
	public List<Instructor> getInstructors();

	public void addInstructor(Instructor instructor, InstructorDtl instructorDetails,Course course, Review review);
//
//	public void deleteAll();
//
//	public List<Instructor> searchInstructor(String search_id_name);
//
//	public void delete(int id);
//
//	public Instructor getInstructor(int id);
	
}
