package Impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.RegistrationDto;
import entity.Role;
import entity.User;
import repository.UserRepository;
import service.service;

@Service
public class serviceimpl implements service
{

    @Autowired
    private UserRepository userRepository;
    
    public serviceimpl(UserRepository userRepository) 
    {
        this.userRepository = userRepository;
    }

    @Override
    public User save(RegistrationDto registrationDto) 
    {
        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(), registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
    
}
