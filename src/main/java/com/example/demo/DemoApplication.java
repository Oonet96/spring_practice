package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
//spring mysql 연동 testrepository
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args)
			.getBean(DemoApplication.class).execute();
	}
	
	
	// private Greet m_greet;

	// @Autowired
	// public void greet(Greet greet){
	// 	m_greet = greet;
	// }

	// public void execute(){
	// 	m_greet.greeting();
	// }

	public void execute(){
		System.out.println("server start!!!");
	}

}

