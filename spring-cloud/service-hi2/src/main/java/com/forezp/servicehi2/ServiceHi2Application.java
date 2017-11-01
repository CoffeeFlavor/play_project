package com.forezp.servicehi2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class ServiceHi2Application {

	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(ServiceHi2Application.class, args);
	}

	@RequestMapping("/hi")
	public String home(@RequestParam String name){
		return "hi "+name+",i am from port:"+port;
	}
}
