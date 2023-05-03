package com.javatpoint.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.javatpoint.model.Student;
import com.javatpoint.repository.StudentRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//defining the business logic
@Component
public class StudentDAO
{
	

// getting student by email
	
	public Student getStudentByEmailDAO(String email) {
		System.out.println("We are inside DAO method");
		return new Student();
	}
}
