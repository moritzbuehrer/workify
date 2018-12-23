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


	@Bean
	CommandLineRunner runner(ProjectRepository ProjRepo, CustomerRepository CustRepo){
		return args -> {

			//Mock Customer
			Customer customer = new Customer("Moritz", "Buhrer", "SAP", "Nancystr. 22", "76187", "Karlsruhe");
			CustRepo.save(customer);

			//Mock Project
			Project project = new Project("Projekt 1", "Beschreibung", customer);
			ProjRepo.save(project);

		};
	}


}
