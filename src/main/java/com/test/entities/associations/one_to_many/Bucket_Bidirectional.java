package com.test.entities.associations.one_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Bucket_Bidirectional {
	
	@Id
	int bucket_id;
	
	@Column
	String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="bucket")
	List<IceCube> iceCube;
}
