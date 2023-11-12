package com.attendance.attendancehub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import repository.AttendanceRepo;

@SpringBootApplication
public class AttendancehubApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AttendancehubApplication.class, args);
	}

	@Autowired
	//private AttendanceRepo userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
