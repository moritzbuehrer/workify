package com.workify.Workify.FormObjects;

import lombok.Data;

@Data
public class CustomerForm {

    private String id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String street;
    private String postcode;
    private String city;

}
