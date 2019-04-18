package com.dhanushika.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.dhanushika.sms.studentservice.modal.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	
}
