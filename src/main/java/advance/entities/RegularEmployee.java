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
public class RegularEmployee extends Employee {
	
	@Column
	private double salary;
	
	@Column
	private double bonus;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
