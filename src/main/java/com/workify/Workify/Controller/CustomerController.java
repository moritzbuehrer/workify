package com.workify.Workify.Controller;

import com.workify.Workify.FormObjects.CustomerForm;
import com.workify.Workify.FormObjects.TimeForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CustomerController {

    @RequestMapping(value = { "/customer/new" }, method = RequestMethod.GET)
    public String insterCustomer(Model model) {

        model.addAttribute("customerform", new CustomerForm());

        return "customerPages/insertCustomer";
    }

    @RequestMapping(value = "/insertTime", method = RequestMethod.POST)
    public String insertCustomer(@ModelAttribute("customerform") TimeForm timeForm, BindingResult bindingResult){

        //Errorhandling
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.toString());
            return "";
        }



        return "redirect:/customers";
    }

    @RequestMapping(value = { "/customers" }, method = RequestMethod.GET)
    public String customers(Model model) {

        model.addAttribute("customerform", new CustomerForm());

        return "customerPages/insertCustomer";
    }
}
