package com.attendancehub.attendancehub.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.attendancehub.attendancehub.User;
import com.attendancehub.attendancehub.web.dto.RegistrationDto;

public interface service extends UserDetailsService
{
    User save(RegistrationDto registrationDto);
}
