package com.workify.Workify.Controller;

import com.workify.Workify.Entity.Customer;
import com.workify.Workify.FormObjects.CustomerForm;
import com.workify.Workify.FormObjects.TimeForm;
import com.workify.Workify.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class CustomerController {

    @Autowired
    CustomerRepository custRepo;

    @RequestMapping(value = { "/customer/new" }, method = RequestMethod.GET)
    public String insterCustomer(Model model) {

        model.addAttribute("customerform", new CustomerForm());

        return "customerPages/insertCustomer";
    }

    @RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)
    public String insertCustomer(@ModelAttribute("customerform") CustomerForm customerForm, BindingResult bindingResult){

        //Errorhandling
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.toString());
            return "";
        }

        Customer customer = new Customer(customerForm.getFirstName(),
                customerForm.getLastName(), customerForm.getCompanyName(),
                customerForm.getStreet(), customerForm.getPostcode(), customerForm.getCity());

        custRepo.save(customer);

        return "redirect:/customers";
    }

    @RequestMapping(value = { "/customers" }, method = RequestMethod.GET)
    public String customers(Model model) {

        List<Customer> customers = custRepo.findAll();
        model.addAttribute("customers", customers);

        return "customerPages/viewCustomers";
    }

    @RequestMapping(value = { "/customer/delete/{id}" }, method = RequestMethod.GET)
    public String deleteProjects(@PathVariable("id") int id){

        custRepo.deleteById((long) id);

        return "redirect:/customers";
    }

}
