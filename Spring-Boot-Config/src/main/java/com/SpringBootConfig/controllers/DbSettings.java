package com.SpringBootConfig.controllers;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//it makes this class a bean
@Configuration 

//it allows this class to access db props in application.properties
/*
 * It checks all the props with prefix db and assign values to its variables with same name and data type
 * you just need to have getters and setters for this and everything will be taken care of annotation
 */

/*
 * 
 * Advantages of using @configurationProperties over @value are
 * 
 * 1. You can group all values into a class and use them accordingly
 * 2. You can make that class a bean and you can use it anywhere in the program
 * so you get to write much less code by this method.
 * 
 */
@ConfigurationProperties("db") 
public class DbSettings {
	
	public String myDetails;
	public String connector;
	public String app;
	
	
	
	public String getConnector() {
		return connector;
	}
	public void setConnector(String connector) {
		this.connector = connector;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getMyDetails() {
		return myDetails;
	}
	public void setMyDetails(String myDetails) {
		this.myDetails = myDetails;
	}

}
