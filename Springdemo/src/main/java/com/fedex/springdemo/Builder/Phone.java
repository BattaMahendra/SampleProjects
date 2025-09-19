package com.fedex.springdemo.Builder;

public class Phone {
	
	private String os;
	private Integer ram;
	private String processor;
	private double screensize;
	private Integer battery;
	public Phone(String os, Integer ram, String processor, double screensize, Integer battery) {
		super();
		this.os = os;
		this.ram = ram;
		this.processor = processor;
		this.screensize = screensize;
		this.battery = battery;
	}
	@Override
	public String toString() {
		return "Phone [os=" + os + ", ram=" + ram + ", processor=" + processor + ", screensize=" + screensize
				+ ", battery=" + battery + "]";
	}
	

}
