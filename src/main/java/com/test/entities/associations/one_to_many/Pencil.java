package com.test.entities.associations.one_to_many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pencil {
	
	@Id
	int pencilId;
	
	@Column
	String name;

	public int getPencilId() {
		return pencilId;
	}

	public void setPencilId(int pencilId) {
		this.pencilId = pencilId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
