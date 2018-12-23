package com.workify.Workify.Controller;

import com.workify.Workify.Entity.Project;
import com.workify.Workify.Entity.TimePiece;
import com.workify.Workify.FormObjects.TimeForm;
import com.workify.Workify.Repository.CustomerRepository;
import com.workify.Workify.Repository.ProjectRepository;
import com.workify.Workify.Repository.TimePieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TimeController {

    @Autowired
    ProjectRepository projRepo;

    @Autowired
    TimePieceRepository timeRepo;

    @Autowired
    CustomerRepository custRepo;


    @RequestMapping(value = { "/time/new" }, method = RequestMethod.GET)
    public String startPage(Model model) {

        model.addAttribute("projects", projRepo.findAll());
        model.addAttribute("timeform", new TimeForm());

        return "timePages/insertTime";
    }


    @RequestMapping(value = "/insertTime", method = RequestMethod.POST)
    public String insertTime(@ModelAttribute("timeform") TimeForm timeForm, BindingResult bindingResult){

        //Errorhandling
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.toString());
            return "insertTime";
        }

        //Handle Dates
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");

        Date timeFrom = null;
        Date timeTo = null;
        Date date = null;
        double difference = 0;
        try {

            timeFrom = timeFormat.parse(timeForm.getFromTime());
            timeTo = timeFormat.parse(timeForm.getToTime());
            difference = timeTo.getTime() - timeFrom.getTime();

            date = format1.parse(timeForm.getDate());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        double differenceHours = difference/3600000.0;

        //Get Project
        Optional<Project> optProject = projRepo.findById( Long.parseLong(timeForm.getProjectId()) );
        Project pro = optProject.get();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        System.out.println(username);

        TimePiece timePiece = new TimePiece(timeForm.getComment(), date, differenceHours, pro, "User1");

        //Insert to Database
        timeRepo.save(timePiece);

        return "redirect:/times";
    }

    @RequestMapping(value = {"/times"}, method = RequestMethod.GET)
    public String timeView(Model model){

        List<TimePiece> timePieces = timeRepo.findAll();

        model.addAttribute("tableEntries", timePieces);

        return "timePages/viewTimes";
    }

    @RequestMapping(value = { "/time/delete/{id}" }, method = RequestMethod.GET)
    public String deleteProjects(@PathVariable("id") int id){

        timeRepo.deleteById((long) id);

        return "redirect:/times";
    }
}
