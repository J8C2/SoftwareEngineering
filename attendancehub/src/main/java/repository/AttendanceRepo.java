package repository;

import org.springframework.data.jpa.repository.JpaRepository;


import entity.User;


public interface AttendanceRepo extends JpaRepository<User, Integer>
{
    
}
