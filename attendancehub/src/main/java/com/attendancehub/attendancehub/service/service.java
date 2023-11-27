package com.attendancehub.attendancehub.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.attendancehub.attendancehub.RegistrationDto;
import com.attendancehub.attendancehub.User;

public interface service extends UserDetailsService
{
    User save(RegistrationDto registrationDto);
}
