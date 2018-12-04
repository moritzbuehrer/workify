package com.workify.Workify.Controller;

import com.workify.Workify.Entity.Customer;
import com.workify.Workify.Entity.Project;
import com.workify.Workify.Entity.TimePiece;
import com.workify.Workify.Repository.CustomerRepository;
import com.workify.Workify.Repository.ProjectRepository;
import com.workify.Workify.Repository.TimePieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@Controller
public class MainController {

    @Autowired
    ProjectRepository projRepo;

    @Autowired
    TimePieceRepository timeRepo;

    @Autowired
    CustomerRepository custRepo;


    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String startPage() {

        //custRepo.save( new Customer("Moritz", "Bührer", "Bührer Inc.", "Kasierstuhlstr", "79279","Freiburg"));

        return "index";
    }


    @RequestMapping(value = {"/timestamp"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void timestamp(){

        Project project = new Project();

        projRepo.save( project );

        TimePiece tp = new TimePiece("First Timepiece", new Date(), 5L, project);

        timeRepo.save(tp);

    }
}
