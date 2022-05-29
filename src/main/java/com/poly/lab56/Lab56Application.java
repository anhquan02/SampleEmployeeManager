package com.poly.lab56;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import com.poly.lab56.domain.Employee;
import com.poly.lab56.domain.Major;
import com.poly.lab56.services.EmployeeService;
import com.poly.lab56.services.MajorService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class Lab56Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab56Application.class, args);
	}

	@Bean
	CommandLineRunner runner(MajorService majorService, EmployeeService employeeService) {
		return args -> {
			
			Date date = new Date();
			majorService.saveMajor(new Major(null, "Business Analyst"));
			majorService.saveMajor(new Major(null, "Designer"));
			majorService.saveMajor(new Major(null, "Tester"));
			majorService.saveMajor(new Major(null, "Developer"));

			employeeService
					.saveEmployee(new Employee(null, "Le Anh Quan", "quan.leanh.02@gmail.com", "Ha noi","0772373651",date, null));
			employeeService.saveMajorToEmp("quan.leanh.02@gmail.com", "Developer");
			employeeService
					.saveEmployee(new Employee(null, "Le Anh Quan", "quan.leanh.202@gmail.com", "Ha noi","0772373652",date, null));
			employeeService.saveMajorToEmp("quan.leanh.202@gmail.com", "Business Analyst");
			employeeService.saveEmployee(
					new Employee(null, "Le Anh Quan", "quan.leanh.2002@gmail.com", "Ha noi","0772373653",date, null));
			employeeService.saveMajorToEmp("quan.leanh.2002@gmail.com", "Designer");
		};
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource(){
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GEt","POST","PUT","DELETE"));
		configuration.setAllowedHeaders(Collections.singletonList("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
		
	}

}
