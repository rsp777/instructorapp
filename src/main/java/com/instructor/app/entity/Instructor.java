package com.instructor.app.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_dtl_id")
	private InstructorDtl instructorDtl;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "instructor",
			   cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Course> courses;

//	@OneToMany(fetch = FetchType.LAZY,
//			mappedBy = "instructor",
//			   cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
//	private List<Course> courses;
	public Instructor() {}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDtl getInstructorDetail() {
		return instructorDtl;
	}

	public void setInstructorDetail(InstructorDtl instructorDtl) {
		this.instructorDtl = instructorDtl;
	}

	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	//add convenience methods for bi-directional relationship
	
	public void add(Course tempCourse) {
		if(courses == null) {
			courses = new ArrayList<Course>();
	}
	courses.add(tempCourse);
	tempCourse.setInstructor(this);
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDtl=" + instructorDtl + ", courses=" + courses + "]";
	}

	
	
//	@Override
//	public String toString() {
//		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
//				+ ", instructorDtl=" + instructorDtl + ", Courses="+ courses.toString().replace("[", "").replace("]", "")+"]";
//	}
}



