package service;

import java.util.List;
import entity.User;

public interface service 
{
      List<User> getAllUsers();
      User saveUser(User user);
}
