package com.gontu.studentadmissioncontroller;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentInfoRESTAPIController {

	@RequestMapping(value = "/students", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Student> getStudentsList() {

		Student s1 = new Student();
		s1.setStudentName("RAM");

		Student s2 = new Student();
		s2.setStudentName("LIPS");

		Student s3 = new Student();
		s3.setStudentName("SIS");

		ArrayList<Student> al = new ArrayList<Student>();

		al.add(s1);
		al.add(s2);
		al.add(s3);

		return al;
	}
	
	//..Retrieving a student record...
	@RequestMapping(value="/students/{name}",method=RequestMethod.GET)
	public Student getStudent(@PathVariable("name")String studentName){
		
		//Fetch the student record using "studentName" from DB
		
		Student student=new Student();
		student.setStudentName(studentName);
		student.setStudentHobby("WWE");
		
		return student;
		
	}
	
	//..Updating a student record
	
	@RequestMapping(value="/students/{name}",method=RequestMethod.PUT)
	public boolean updateStudent(@PathVariable("name")String studentName,@RequestBody Student student){
		
		//Find matching record from DB using "studentName"
		System.out.println("Student Name : "+studentName);
		
		//update student record sent by client
		System.out.println("Student Name : "+student.getStudentName()+"Student Hobby :"+student.getStudentHobby());
				
		//if upade done return true otherwise false
		return true;
	}

}
