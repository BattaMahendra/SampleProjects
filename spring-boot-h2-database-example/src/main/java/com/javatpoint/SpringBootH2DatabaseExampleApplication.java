package com.javatpoint;
import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableHystrix
public class SpringBootH2DatabaseExampleApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(SpringBootH2DatabaseExampleApplication.class, args);
}

@Bean
public RestTemplate restTemplate(RestTemplateBuilder builder) {
 return builder
//		 .setConnectTimeout(Duration.ofSeconds(3))
//		 .setReadTimeout(Duration.ofSeconds(3))
		 .build();
}
}
