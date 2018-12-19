package com.workify.Workify.Controller;

import com.workify.Workify.Entity.Customer;
import com.workify.Workify.Entity.Project;
import com.workify.Workify.FormObjects.ProjectForm;
import com.workify.Workify.FormObjects.TimeForm;
import com.workify.Workify.Repository.CustomerRepository;
import com.workify.Workify.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class ProjectController {

    @Autowired
    CustomerRepository custRepo;

    @Autowired
    ProjectRepository projRepo;

    @RequestMapping(value = { "/project/new" }, method = RequestMethod.GET)
    public String project(Model model){

        model.addAttribute("projectform", new ProjectForm());
        model.addAttribute("customers", custRepo.findAll());

        return "projectPages/insertProject";
    }

    @RequestMapping(value = { "/insertProject" }, method = RequestMethod.POST)
    public String createProject(@ModelAttribute("projectform") ProjectForm projectForm, BindingResult bindingResult){

        Optional<Customer> optCustomer = custRepo.findById( Long.parseLong(projectForm.getCustomerId()) );
        Customer customer = optCustomer.get();

        Project project = new Project(projectForm.getName(), projectForm.getDescription(), customer);
        projRepo.save(project);

        return "redirect:/project/new";
    }

    @RequestMapping(value = { "/projects" }, method = RequestMethod.GET)
    public String readAllProjects(){

        return "";
    }


    @RequestMapping(value = { "/deleteProject({id})" }, method = RequestMethod.GET)
    public String deleteProjects(@PathVariable("id") int id){

        return "";
    }

}
