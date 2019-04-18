package com.dhanushika.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhanushika.sms.ExceptionHandler.SMSException;
import com.dhanushika.sms.studentservice.modal.Student;
import com.dhanushika.sms.studentservice.service.StudentService;

@RestController
@RequestMapping(value = "/sms")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@RequestMapping(value = "/student",method = RequestMethod.POST)
	 Student save(@RequestBody Student student) {
	
	 	return studentservice.save(student);
	}
	
	@RequestMapping(value = "/student",method = RequestMethod.GET)
	public List<Student> fetchAll(){
		
		return studentservice.fetchall();
	}
	
	@RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
	public ResponseEntity<Student> fetch(@PathVariable Integer id){
		if (id<=0) {
			return ResponseEntity.badRequest().build();
			
		}
		else {
			Student student= studentservice.fetch(id)	;
			if(student == null) {
				//you can log here also
				throw new SMSException("cannot find student", "ER-003");
			}
			else {
				return ResponseEntity.ok(student);
			}
		}
	}
	
	/*
	 * @RequestMapping(value="/hello") public String greeting(@RequestParam String
	 * name) { return "Hello from spring boot "+name; }
	 * 
	 * @RequestMapping(value = "/student2") public Student newStudent() { Student
	 * student = new Student(); student.setName("dhanu"); student.setId(1);
	 * student.setCity("Galle"); return student; }
	 * 
	 * @RequestMapping(value = "/student",method = RequestMethod.POST) public
	 * Student save(@RequestBody Student student) {
	 * System.out.println(student.getName()+"  "+ student.getId());
	 * 
	 * return student; }
	 * 
	 * @RequestMapping(value = "/studentfetch",method = RequestMethod.GET) public
	 * ResponseEntity<Student> fetch() {
	 * 
	 * 
	 * return ResponseEntity.noContent().build(); }
	 */
}
