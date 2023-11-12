package service;

import dto.RegistrationDto;
import entity.User;

public interface service
{
    User save(RegistrationDto reigstrationDto);
}
