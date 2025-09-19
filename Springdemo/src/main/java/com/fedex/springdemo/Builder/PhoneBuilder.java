package com.fedex.springdemo.Builder;

public class PhoneBuilder {
	
	private String os;
	private Integer ram;
	private String processor;
	private double screensize;
	private Integer battery;
	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}
	public PhoneBuilder setRam(Integer ram) {
		this.ram = ram;
		return this;
	}
	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}
	public PhoneBuilder setScreensize(double screensize) {
		this.screensize = screensize;
		return this;
	}
	public PhoneBuilder setBattery(Integer battery) {
		this.battery = battery;
		return this;
	}
	public Phone getPhone() {
		return new Phone(os, ram, processor, screensize, battery);
	}

}
