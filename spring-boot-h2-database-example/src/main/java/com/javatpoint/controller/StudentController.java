package com.javatpoint.controller;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.javatpoint.model.BaseLocation;
import com.javatpoint.model.Student;
import com.javatpoint.service.StudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//creating RestController
@RestController
public class StudentController 
{
	
	   @Autowired
	   RestTemplate restTemplate;
//	   =new RestTemplate();
	   
		//autowired the StudentService class
		@Autowired
		private StudentService studentService;
		//creating a get mapping that retrieves all the students detail from the database 
		@GetMapping("/student")
		public List<Student> getAllStudent() 
		{
		return studentService.getAllStudent();
		}
		//creating a get mapping that retrieves the detail of a specific student
		@GetMapping("/student/{id}")
		public Student getStudent(@PathVariable("id") int id) 
		{
		return studentService.getStudentById(id);
		}
		//creating a delete mapping that deletes a specific student
		@DeleteMapping("/student/{id}")
		public void deleteStudent(@PathVariable("id") int id) 
		{
		studentService.delete(id);
		}
		//creating post mapping that post the student detail in the database
		@HystrixCommand(fallbackMethod = "fallbackSave")
		@PostMapping("/student")
			public int saveStudent(@RequestBody Student student) 
			{
				System.out.println("WE ARE INSIDE THE CONTROLLER METHOD");
			studentService.saveOrUpdate(student);
			return student.getId();
			}
//		 
		public int fallbackSave(Student student,Throwable e) {
	        e.printStackTrace();
	        System.out.println("Request fails. It takes long time to response"+student);
	        return 0;
	    }
		
		@GetMapping("/name/{name}")
		public List<Student> getAStudentByname(@PathVariable String name){
			return studentService.getStudentByName(name);
		}
		
		@GetMapping("/email/{email}")
		public Student getAStudentByEmail(@PathVariable String email){
			return studentService.getStudentByEmail(email);
		}
		
		@GetMapping("/BL")
		public CompletableFuture<List<BaseLocation>> getAllBLList() throws RestClientException{
			
//			BaseLocation[] BaseLocationArray=restTemplate
//					.getForObject("http://localhost:8123/BL/all", BaseLocation[].class);
			return studentService.getAllBLFromShipmentRT();
			//return  Arrays.asList(BaseLocationArray);
		}
}
