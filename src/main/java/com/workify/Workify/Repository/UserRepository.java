package com.workify.Workify.Repository;

import com.workify.Workify.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);

}
