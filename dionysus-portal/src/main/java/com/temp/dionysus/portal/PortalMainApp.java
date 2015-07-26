package com.temp.dionysus.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
//@ComponentScan("com.temp.dionysus.customer.service")
public class PortalMainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(PortalConfig.class);
		SpringApplication.run(PortalMainApp.class, args);
	}
}
