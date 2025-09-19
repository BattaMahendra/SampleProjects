package com.fedex.springdemo;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference {

	///demo prohgram to calculate avearge of  number using method r
	public static void main(String[] args) {
		
		BiFunction<String, String, String> biFunction = new A_Class() :: staticMethod;
		
		System.out.println(biFunction.apply("Basics", "Strong"));
		
		ArrayList<String> str = new ArrayList<String>();
	       str.add("Geeks");
	       str.add("for");
	       str.add("Geeks");
	       
	    Function<String,Integer> fun=String::length;
	    System.out.println(fun.apply("Basics"));
	    
	}
	
}


