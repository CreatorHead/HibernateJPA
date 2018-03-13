package com.test.entities.associations.one_to_many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IceCube {
	@Id
	int iceCubeId;
	
	@Column
	String size;
	
	@ManyToOne
	@JoinColumn(name="bucket_id")
	Bucket_Bidirectional bucket;
}
