package com.workify.Workify.Controller;

import com.workify.Workify.Entity.Customer;
import com.workify.Workify.Repository.CustomerRepository;
import com.workify.Workify.Entity.Project;
import com.workify.Workify.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projRepo;

    @Autowired
    CustomerRepository custRepo;

    @RequestMapping(value = { "/setup" }, method = RequestMethod.GET)
    public void setup() {

        //Test Data
        Customer cust1 = new Customer("Moritz", "Bührer", "Bührer Inc.", "Kasierstuhlstr", "79279","Freiburg");
        custRepo.save( cust1 );

        projRepo.save( new Project("First Project", "Desc first Proj", cust1));
        projRepo.save( new Project("Second Project", "Desc second Proj", cust1));
        projRepo.save( new Project("Third Project", "Desc third Proj", cust1));

    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String startPage() {

        return "index";
    }


}
