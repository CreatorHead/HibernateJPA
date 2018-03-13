package com.test.entities.entity_basic_types;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Student_CollectionBasicValueType {
	@Id
	@Column(name="student_id")
	private int id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_email")
	private String email;
	
	@Embedded
	private Address_Embeddable address;

	@ElementCollection
	@CollectionTable(name="phones_numbers",joinColumns=@JoinColumn(name="student_id"))
	@Column(name="phone_num")
	private List<Long> phones;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address_Embeddable getAddress() {
		return address;
	}

	public void setAddress(Address_Embeddable address) {
		this.address = address;
	}

	public List<Long> getPhones() {
		return phones;
	}

	public void setPhones(List<Long> phones) {
		this.phones = phones;
	}
}
