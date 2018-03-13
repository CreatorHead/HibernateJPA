package advance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dog extends Animal {
	
	@Id
	private int dogId;
	
	@Column
	private String ownerName;

	public int getDogId() {
		return dogId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
