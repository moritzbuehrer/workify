package com.workify.Workify.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {

    @RequestMapping(value = { "/project" }, method = RequestMethod.GET)
    public String project(){

        return "project";
    }

    @RequestMapping(value = { "/project({id})" }, method = RequestMethod.GET)
    public String readProject(@PathVariable("id") int id){

        return "";
    }

    @RequestMapping(value = { "/projects" }, method = RequestMethod.GET)
    public String readAllProjects(){

        return "";
    }

    @RequestMapping(value = { "/createProject" }, method = RequestMethod.GET)
    public String createProjects(){

        return "";
    }

    @RequestMapping(value = { "/deleteProject({id})" }, method = RequestMethod.GET)
    public String deleteProjects(@PathVariable("id") int id){

        return "";
    }

    @RequestMapping(value = { "/updateProject({id})" }, method = RequestMethod.GET)
    public String updateProjects(@PathVariable("id") int id){

        return "";
    }

}
