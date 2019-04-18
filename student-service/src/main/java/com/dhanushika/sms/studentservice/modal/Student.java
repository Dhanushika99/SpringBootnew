package com.dhanushika.sms.studentservice.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	// @JsonProperty("student_id")
	private Integer id;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	// @OneToMany(cascade = CascadeType.ALL)//if we don't put mapped by intermediate
	// table will create
	// mapped by stdnt variable of telephone table
	// @JoinColumn(name = "iid")
	@OneToMany(mappedBy = "stdnt", cascade = CascadeType.ALL)
	private List<Telephone> telephone;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "sid", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cid", referencedColumnName = "id"))
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Telephone> getTelephone() {
		return telephone;
	}

	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
