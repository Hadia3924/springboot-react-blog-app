package com.hadia.blogApp;

import com.hadia.blogApp.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
		System.out.println("Hello");
	}
//	public static void main(String[] args) {
//		Employee user = new Employee();
//		user.setName("Hadia");
//		user.setAge(22);
//		System.out.println(user.getName() + " - " + user.getAge());
//	}

}
