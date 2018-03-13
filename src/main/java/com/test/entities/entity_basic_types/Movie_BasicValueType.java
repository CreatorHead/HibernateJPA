package com.test.entities.entity_basic_types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="movies_info")
public class Movie_BasicValueType {
	
	@Id
	@Column(name="movie_id")
	private int id;
	
	@Column(name="movie_name", nullable=false, updatable=false)
	private String name;
	
	@Column(name="summery")
	private String summery;
	
	@Column(name="ratings")
	private float ratings;
	
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
	public String getSummery() {
		return summery;
	}
	public void setSummery(String summery) {
		this.summery = summery;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
}	
