package com.dhanushika.sms.studentservice.service;

import java.util.List;

import com.dhanushika.sms.studentservice.modal.Student;

public interface StudentService {
	Student save(Student student);
	List<Student> fetchall();
	Student fetch(Integer id);
}
