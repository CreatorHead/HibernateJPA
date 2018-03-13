package com.test.entities.entity_basic_types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address_Embeddable {
	@Column(name="student_state_embeddable")
	private String state;
	
	@Column(name="student_city_embeddable")
	private String city;

	@Column(name="student_pin_embeddable")
	private int pin;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
}