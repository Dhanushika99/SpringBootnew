package com.dhanushika.sms.studentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanushika.sms.repository.StudentRepository;
import com.dhanushika.sms.studentservice.modal.Student;
import com.dhanushika.sms.studentservice.modal.Telephone;

@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student save(Student student) {
		for(Telephone telephone:student.getTelephone()) {
			telephone.setStdnt(student);
		}
		return studentRepository.save(student);
	}

	@Override
	public List<Student>  fetchall() {
		return studentRepository.findAll();
	}

	@Override
	public Student fetch(Integer id) throws Exception{
		Optional<Student> student=studentRepository.findById(id); 
		if(student.isPresent()) {
			
			return student.get();
		}
		else {
			return null;
		}
	}

}
