package com.test.entities.entity_basic_types;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Person_CollectionValueType {
	@Id
	@Column(name="person_id")
	private int id;

	@Column(name="person_name")
	private String name;

	@Column(name="person_email")
	private String email;

	@Transient
	boolean abc;
	
	@ElementCollection
	@CollectionTable(name="address_list", joinColumns=@JoinColumn(name="person_id"))
	@AttributeOverrides({@AttributeOverride(name="state",column=@Column(name="person_state")),
		@AttributeOverride(name="city",column=@Column(name="person_city")),
		@AttributeOverride(name="pin",column=@Column(name="person_pin"))
	})
	private List<Address_Embeddable> addresses;

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

	public List<Address_Embeddable> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address_Embeddable> addresses) {
		this.addresses = addresses;
	}

	
}
