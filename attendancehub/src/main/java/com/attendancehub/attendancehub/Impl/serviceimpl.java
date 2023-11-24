package com.attendancehub.attendancehub.Impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.attendancehub.attendancehub.Role;
import com.attendancehub.attendancehub.User;
import com.attendancehub.attendancehub.repository.UserRepository;
import com.attendancehub.attendancehub.service.service;
import com.attendancehub.attendancehub.web.dto.RegistrationDto;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


    
}
