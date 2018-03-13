package com.test.entities.entity_basic_types;

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

@Entity
public class Office_CollectionValueType {
	
	@Id
	@Column(name="office_id")
	private int id;
	
	@Embedded
	@ElementCollection
	@CollectionTable(name="office_address_info", joinColumns=@JoinColumn(name="office_id"))
	@AttributeOverrides({@AttributeOverride(name="state",column=@Column(name="office_state")),
						@AttributeOverride(name="pin", column=@Column(name="office_pin")),
						@AttributeOverride(name="city", column=@Column(name="office_city"))})
	private List<Address_Embeddable> addresses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Address_Embeddable> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address_Embeddable> addresses) {
		this.addresses = addresses;
	}
}
