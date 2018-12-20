package com.workify.Workify;

import com.workify.Workify.Entity.Customer;
import com.workify.Workify.Entity.Project;
import com.workify.Workify.Repository.CustomerRepository;
import com.workify.Workify.Repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkifyApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner runner(ProjectRepository ProjRepo, CustomerRepository CustRepo){
		return args -> {

			Customer customer = new Customer("Moritz", "Buhrer", "SAP", "asd", "asd", "asd");
			CustRepo.save(customer);

			Project project = new Project();
			project.setCustomer(customer);

			ProjRepo.save(project);


		};
	}
	*/

}
