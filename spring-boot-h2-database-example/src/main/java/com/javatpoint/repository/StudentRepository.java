package com.javatpoint.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
//	JPA Query
	public List<Student> findByName(String name);
	
//	native sql query
	
	@Query(
			value = "select * from student where email= ?1",
			nativeQuery = true
			
			)
	public Student findByStudentEmailAddressUsingNativeSQL_Query(String emailAddress);
	

		
	
	
}
