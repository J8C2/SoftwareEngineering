package com.attendancehub.attendancehub.service;


import com.attendancehub.attendancehub.User;
import com.attendancehub.attendancehub.web.dto.RegistrationDto;

public interface service
{
    User save(RegistrationDto registrationDto);
}
