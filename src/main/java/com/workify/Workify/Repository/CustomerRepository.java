package com.workify.Workify.Repository;

import com.workify.Workify.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAll ();

    List<Customer> findByLastName(String lastName);

}
