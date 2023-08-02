package com.fedex.springdemo.Builder.Functional;

public class Shop {
	
	public static void main(String args[]) {
		PhoneBuilder builder=new PhoneBuilder();
		builder.with(consumer->{
			
			consumer.battery=1000;
			consumer.os="Android";
			
		});
		System.out.println(builder.getPhone());
		System.out.println(builder);
	}

}
