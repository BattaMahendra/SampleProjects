package com.javatpoint.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.dao.StudentDAO;
import com.javatpoint.model.BaseLocation;
import com.javatpoint.model.Student;
import com.javatpoint.repository.StudentRepository;
import com.javatpoint.restTemplate.ShipmentRestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
//defining the business logic
@Service
public class StudentService 
{
	int count=1;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	ShipmentRestTemplate shipmentRestTemplate;
	
	//getting all student records
	public List<Student> getAllStudent() 
	{
		List<Student> students = new ArrayList<Student>();
		studentRepository.findAll().forEach(student -> students.add(student));
		return students;
	}
	//getting a specific record
	public Student getStudentById(int id) 
	{
		System.out.println(" INSIDE THE SAVE METHOD OF SERVICE CLASS");
	return studentRepository.findById(id).get();
	}
//	getting List of students by name
	
	public List<Student> getStudentByName(String name){
		System.out.println(" INSIDE THE SAVE METHOD OF SERVICE CLASS");
		return studentRepository.findByName(name);
	}
// getting student by email
	@HystrixCommand(fallbackMethod = "fallbackStudentByEmail")
	public Student getStudentByEmail(String email) {
		System.out.println("INSIDE THE GET BY EMAIL METHOD OF SERVICE CLASS");
		 Student student=studentDAO.getStudentByEmailDAO(email);
		 return student;
	}
	
//	fallback method
	public Student fallbackStudentByEmail(String email,Throwable e) {
        e.printStackTrace();
        System.out.println("Request fails in get by Email method of service class. It takes long time to response"+email);
        return new Student();
    }
	
//	@HystrixCommand(fallbackMethod = "fallbackSave")
	public void saveOrUpdate(Student student) 
	{
		System.out.println(" INSIDE THE SAVE METHOD OF SERVICE CLASS");
		studentRepository.save(student);
//		throw new RuntimeException(); 
	}
	
	public void fallbackSave(Student student,Throwable e) {
        e.printStackTrace();
        System.out.println("Request fails in save method of service class. It takes long time to response"+student);
    }
	
	
	//deleting a specific record
	public void delete(int id) 
	{
		studentRepository.deleteById(id);
	}
	

//	@Retry(name = "giveDemoObject",fallbackMethod ="serviceFallback")
	public CompletableFuture<List<BaseLocation>> getAllBLFromShipmentRT(){
		count=count>3?1:count;
		System.out.println(" we are inside servce -- > getAllBLFromShipmentRT() method");
		System.out.println("the retry is being tried "+count++ +" times at time  of "+new Date());
		try{
			return shipmentRestTemplate.getShipmentBLByRestTemplate();
		   }catch(Exception e) {
			
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
//	public List<BaseLocation> serviceFallback(Exception e){
//		System.out.println("we are in the service fallback");
//		 return Collections.singletonList(new BaseLocation(0, "no value", "no value"));
//	}
}