package com.instructor.app.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.instructor.app.entity.Course;
import com.instructor.app.entity.Instructor;
import com.instructor.app.entity.InstructorDtl;
import com.instructor.app.entity.Review;
import com.instructor.app.repository.CourseRepository;
import com.instructor.app.repository.InstructorRepository;
import com.instructor.app.repository.ReviewRepository;
//import com.instructor.app.service.InstructorService;
import com.instructor.app.service.InstructorService;

@RestController
@RequestMapping("/api")
@EnableJpaRepositories
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	private final Logger logger = Logger.getLogger(InstructorController.class.getName());
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/list")
	public List<Instructor> getInstructors() {
		List<Instructor> instructors = instructorService.getInstructors();
		logger.info("Instructor : " + instructors);

		return instructors;
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addInstructor(@RequestBody Map<String, Object> payload) {
		
		String jsonString="";
		logger.info("" + payload);
		logger.info("" + payload.get("instructor"));
//		if (payload.containsKey("body")) {
//			 jsonString = (String) payload.get("body");
//			 logger.info("with body : "+jsonString);
//		}
//		else {
//			 jsonString = payload.toString();
//			 logger.info("without body : "+jsonString);
//		}
		jsonString = (String) payload.get("body");
		Map<String, Object> jsonMap;
		
		try {
			jsonMap = new ObjectMapper().readValue(jsonString, new TypeReference<Map<String, Object>>() {
			});
			Instructor instructor = new ObjectMapper().convertValue(jsonMap.get("instructor"), Instructor.class);
			logger.info("Instructor : " + instructor);
			String youtubeChannel = new ObjectMapper().convertValue(jsonMap.get("youtubeChannel"), String.class);
			logger.info("YouTube Channel : " + youtubeChannel);
			String hobby = new ObjectMapper().convertValue(jsonMap.get("hobby"), String.class);
			logger.info("Hobby : " + hobby);
			Course courses = new ObjectMapper().convertValue(jsonMap.get("courses"), Course.class);
			logger.info("Course : " + courses);
			Review review = new ObjectMapper().convertValue(jsonMap.get("review"), Review.class);
			logger.info("Review : " + review);

			InstructorDtl instructorDetails = new InstructorDtl(youtubeChannel, hobby);
			instructor.setInstructorDetail(instructorDetails);
			instructorService.addInstructor(instructor, instructorDetails, courses, review);
			return ResponseEntity.ok("Instructor added successfully");
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

		return ResponseEntity.ok("Instructor added successfully");
	}
	
	


}
