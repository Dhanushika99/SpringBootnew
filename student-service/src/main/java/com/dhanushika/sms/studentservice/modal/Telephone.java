package com.dhanushika.sms.studentservice.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Telephone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String type;
	private String number;
	//@ManyToOne
	//@JoinColumn(name = "iid",referencedColumnName = "id")  
	@ManyToOne
    @JoinColumn //this means telephone class is own the relationship
    @JsonIgnore
	private Student stdnt;
	
	public Student getStdnt() {
		return stdnt;
	}
	public void setStdnt(Student stdnt) {
		this.stdnt = stdnt;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
