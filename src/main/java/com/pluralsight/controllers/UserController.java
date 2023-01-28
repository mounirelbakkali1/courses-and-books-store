package com.pluralsight.controllers;


import com.pluralsight.dto.UserDTO;
import com.pluralsight.models.User;
import com.pluralsight.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService service;

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return service.findAllUsers();
    }

    @GetMapping("/mapper")
    public List<UserDTO> getUsers(){
        return service.findAllUsersUsingDTOMapper();
    }
}
