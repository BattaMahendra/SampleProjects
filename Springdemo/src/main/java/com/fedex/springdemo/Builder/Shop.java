package com.fedex.springdemo.Builder;

public class Shop {
	
	public static void main(String args[]) {
//		Phone p=new Phone(null, null, null, 0, null);
		
		Phone p=new PhoneBuilder().setOs("Android").setBattery(2000).getPhone();
		
		System.out.println(p);
	}

}
