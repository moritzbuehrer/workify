package com.workify.Workify.FormObjects;

import lombok.Data;

@Data
public class CustomerForm {

    private Long id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String street;
    private String postcode;
    private String city;

    public CustomerForm(){

    }

}
