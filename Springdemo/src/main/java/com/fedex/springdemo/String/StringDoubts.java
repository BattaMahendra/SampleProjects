package com.fedex.springdemo.String;

public class StringDoubts {
	
	public static void main(String[] args) {
		
		final 
		String s ="Mahendra";
		s.concat(" Batta");
		System.out.println(s);
		
		final StringBuilder sb = new StringBuilder("Sravanth");
		sb.replace(0, 8, "mahendra");
		System.out.println(sb);
		 
		String s1 = "Sravanth";
		
		String s2 =new String("Sravanth");
		
		System.out.println(s1==s2);
		
		System.out.println(s1.equals(s2));
		
		StringBuilder sb1 = new StringBuilder("Sravanth");
		StringBuilder sb2 = new StringBuilder("Sravanth");
		System.out.println(sb1.toString().equals(sb2.toString()));
	}

}
