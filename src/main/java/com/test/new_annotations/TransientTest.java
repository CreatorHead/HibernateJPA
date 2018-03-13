package com.test.new_annotations;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class TransientTest {
	
	@Id
	String fieldOne;
	
	@Column
	String fieldTwo;
	
	@Column
	String fieldThree;
	
	@Transient
	boolean state;

	public String getFieldOne() {
		return fieldOne;
	}

	public void setFieldOne(String fieldOne) {
		this.fieldOne = fieldOne;
	}

	public String getFieldTwo() {
		return fieldTwo;
	}

	public void setFieldTwo(String fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	public String getFieldThree() {
		return fieldThree;
	}

	public void setFieldThree(String fieldThree) {
		this.fieldThree = fieldThree;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
