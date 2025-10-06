package com.fedex.springdemo;

import java.util.ArrayList;
import java.util.function.Predicate;

public class HigherOrderFunction {

	public static void main(String[] args) {
		Predicate<Employee> pred1 = e -> e.getAge() >=30;
		Predicate<Employee> pred2 = e -> e.getSalary() > 10000;
		// using a default method of Predicate
		//Predicate pred3 = pred1.and(pred2);
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(30,30000,"FEMALE","SWAG"));
		list.add(new Employee(29,30000,"MALE","SKS"));
		list.add(new Employee(26,30000,"FEMALE","SHRUTI"));
		list.stream().filter(pred1).filter(pred2).forEach(
                e -> System.out.println(e.getName()));
	}

}
