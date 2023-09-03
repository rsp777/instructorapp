package com.instructor.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instructor.app.entity.Course;
import com.instructor.app.entity.Instructor;
import com.instructor.app.entity.InstructorDtl;
import com.instructor.app.entity.Review;

//@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {

}
