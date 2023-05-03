package com.javatpoint.restTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.bouncycastle.asn1.x509.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.javatpoint.model.BaseLocation;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Component
public class ShipmentRestTemplate {
	
	@Autowired
	private RestTemplate restTemplate;
	int count=1;
//	@CircuitBreaker(name="giveDemoObject",fallbackMethod ="serviceAFallback" )
	@Retry(name = "giveDemoObject",fallbackMethod ="serviceAFallback" )
	public List<BaseLocation> getShipmentBLByRestTemplate() {
		
		try{
			System.out.println(" Hey , we are in Shipment RT class and get BL method"+new Date());
//			System.out.println("the retry is being tried "+count++ +" times at time  of "+new Date());
		
//		calling shipment end point for base location details
		BaseLocation[] BaseLocationArray=restTemplate
				.getForObject("http://localhost:8123/BL/all", BaseLocation[].class);
//		BaseLocation BaseLocationArray=restTemplate
//				.getForObject("http://localhost:8123/BL/id/1", BaseLocation.class);
//		
		return  Arrays.asList(BaseLocationArray);   
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	public List<BaseLocation> serviceAFallback(Exception e) {
        return Collections.singletonList(new BaseLocation(0, "no value", "no value"));
    }	
	
}
