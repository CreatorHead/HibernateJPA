package advance.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
	@AttributeOverride(name="empId",column=@Column(name="empId")),
	@AttributeOverride(name="name",column=@Column(name="name"))
})
public class ContractEmployee extends Employee {
	
	@Column
	private double payPerHour;
	
	@Column
	private String contractDuration;

	public double getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(double payPerHour) {
		this.payPerHour = payPerHour;
	}

	public String getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(String contractDuration) {
		this.contractDuration = contractDuration;
	}
	
	
}
