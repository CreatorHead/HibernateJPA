package com.test.entities.entity_basic_types;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

@Entity(name="user_info")
public class User_CollectionMapValueType {
	
	@Id
	@Column(name="user_id")
	private int id;
	
	@ElementCollection
	@CollectionTable(name="mapped_person_info",joinColumns=@JoinColumn(name="user_id"))
	@MapKeyColumn(name="user_name_key")
	@Column(name="user_name_value")
	private Map<Integer,String> info;

	public Map<Integer, String> getInfo() {
		return info;
	}

	public void setInfo(Map<Integer, String> info) {
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}	
