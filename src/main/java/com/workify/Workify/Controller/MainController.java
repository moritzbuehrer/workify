package com.workify.Workify.Controller;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import com.workify.Workify.Entity.Customer;
import com.workify.Workify.Entity.Project;
import com.workify.Workify.Entity.TimePiece;
import com.workify.Workify.FormObjects.TimeFrom;
import com.workify.Workify.Repository.CustomerRepository;
import com.workify.Workify.Repository.ProjectRepository;
import com.workify.Workify.Repository.TimePieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    ProjectRepository projRepo;

    @Autowired
    TimePieceRepository timeRepo;

    @Autowired
    CustomerRepository custRepo;


    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String startPage(Model model) {

        //Test Data
        Customer cust1 = new Customer("Moritz", "Bührer", "Bührer Inc.", "Kasierstuhlstr", "79279","Freiburg");
        custRepo.save( cust1 );

        projRepo.save( new Project("First Project", "Desc first Proj", cust1));
        projRepo.save( new Project("Second Project", "Desc second Proj", cust1));
        projRepo.save( new Project("Third Project", "Desc third Proj", cust1));

        //---------------------------------------------------------------------------------------------------


        model.addAttribute("projects", projRepo.findAll());
        model.addAttribute("timeform", new TimeFrom());

        return "index";
    }

    @RequestMapping(value = "/insertTime", method = RequestMethod.POST)
    public String insertTime(@ModelAttribute("timeform") TimeFrom timeForm, BindingResult bindingResult){

        //Errorhandling
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.toString());
            return "index";
        }

        //Calculate Timedifference
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = null;
        Date date2 = null;
        double difference = 0;
        try {
            date1 = format.parse(timeForm.getFromTime());
            date2 = format.parse(timeForm.getToTime());
            difference = date2.getTime() - date1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double differenceHours = difference/3600000.0;



        //Insert to Database

        return "index";
    }

    @RequestMapping(value = {"/timestamp"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void timestamp(){

        Project project = new Project();

        projRepo.save( project );

    }
}
