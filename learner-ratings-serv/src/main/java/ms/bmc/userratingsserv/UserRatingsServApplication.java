package ms.bmc.userratingsserv;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
//@EnableHystrix
//@EnableHystrixDashboard
public class UserRatingsServApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRatingsServApplication.class, args);
	}
	
	@Bean
	public Random getaRandomValue() {
		Random random =new Random();
		return random;
	}

}
