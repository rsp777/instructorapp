package com.instructor.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instructor.app.entity.InstructorDtl;

//@Repository
public interface InstructorDtlRepository extends CrudRepository<InstructorDtl, Long> {

}
