package com.fedex.springdemo.Builder.Functional;

public class Phone {
	
	private String os;
	private Integer ram;
	private String processor;
	private double screensize;
	private Integer battery;
	public Phone(PhoneBuilder builder) {
		super();
		this.os = builder.os;
		this.ram = builder.ram;
		this.processor = builder.processor;
		this.screensize = builder.screensize;
		this.battery = builder.battery;
	}
	@Override
	public String toString() {
		return "Phone [os=" + os + ", ram=" + ram + ", processor=" + processor + ", screensize=" + screensize
				+ ", battery=" + battery + "]";
	}
	

}
