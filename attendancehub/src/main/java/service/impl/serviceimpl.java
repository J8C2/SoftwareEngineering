package service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.User;
import repository.AttendanceRepo;
import service.service;

@Service
public class serviceimpl implements service
{
    private AttendanceRepo userRepo;
    
    public serviceimpl(AttendanceRepo userRepo)
    {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() 
    {
       return userRepo.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
    
}
