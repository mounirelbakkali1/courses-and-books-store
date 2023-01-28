package com.pluralsight.services;

import com.pluralsight.dto.UserDTO;
import com.pluralsight.dto.UserDTOMapper;
import com.pluralsight.models.User;
import com.pluralsight.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    UserDTOMapper dtoMapper;

    public List<UserDTO> findAllUsers(){
        return repository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getUsername(), user.getEmail(),user.getRole()))
                .collect(Collectors.toList());
    }
    public List<UserDTO> findAllUsersUsingDTOMapper(){
        return repository.findAll()
                .stream()
                .map(user -> dtoMapper.apply(user))
                .collect(Collectors.toList());
    }
}
