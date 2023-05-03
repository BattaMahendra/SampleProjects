package com.SpringBootConfig.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class Controller {
	
	@Value("Hello , this is hardcoded in controller class using @value")
	private String greet1;
	
	@Value("${my.greeting: coming from default , due to failure in app.props}")
	private String greeting;
	
	@Value("${my.list.values}")
	private List<String> myNamesList;
	
	@Value("#{${db.myDetails}}")
	private Map<String, String> myList;
	
	//accessing db.properties through DbSettings class
	//DbSettings class is configures to access values of db
	@Autowired
	private DbSettings dbSettings;
	
	@GetMapping("/config")
	public String dbSettingsAccess() {
		return dbSettings.getConnector() + dbSettings.getApp()+ " "+dbSettings.getMyDetails();
	}
	
	
	@GetMapping("/x")
	public String greet() {
//		return greet1;
		return greeting +"\n"+ myNamesList+"\n"+myList+"\n\n"+dbSettings.myDetails;
	}

}
