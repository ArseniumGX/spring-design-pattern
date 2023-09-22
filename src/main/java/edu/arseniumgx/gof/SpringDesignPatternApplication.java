package edu.arseniumgx.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringDesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDesignPatternApplication.class, args);
	}

}
