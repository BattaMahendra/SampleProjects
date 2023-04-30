package com.MovieCatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class MovieCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate getMyRestTemplate() {
		return new RestTemplate();
	}
	
		@Bean
	    public ServletRegistrationBean getServlet(){
		 
	        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
	        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
	        registrationBean.setLoadOnStartup(1);
	        registrationBean.addUrlMappings("/hystrix.stream");
	        registrationBean.setName("HystrixMetricsStreamServlet");
	        return registrationBean;
	    }


}
