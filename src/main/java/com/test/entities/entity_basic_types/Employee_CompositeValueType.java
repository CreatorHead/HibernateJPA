package com.test.entities.entity_basic_types;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee_CompositeValueType {
	@Id
	@Column(name="emp_id")
	private int id;
	
	@Column(name="emp_name")
	private String name;
	
	@Column(name="emp_email")
	private String email;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="state",column=@Column(name="emp_state")),
			@AttributeOverride(name="pin", column=@Column(name="emp_pin")),
			@AttributeOverride(name="city",column=@Column(name="emp_city"))
		}
	)
	private Address_Embeddable address;

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

}
