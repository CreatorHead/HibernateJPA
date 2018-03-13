package advance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="student_info")
@NamedQueries({
	@NamedQuery(name="getAllStudents",query="SELECT s FROM Student s")
})
public class Student {
	
	@Id
	private String regno;
	
	@Column
	private String firstname;
	
	@Column
	private String middlename;
	
	@Column
	private String lastname;
	
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Student [regno=" + regno + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname="
				+ lastname + "]";
	}
}
