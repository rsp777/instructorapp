package com.instructor.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instructor.app.entity.Review;

//@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
