package advance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name="currency")
@IdClass(CurrencyId.class)
public class Currency {
	
	@Id
	@Column(length=100)//varchar
	private String name;
	
	@Id
	@Column(length=100)//varchar
	private String countryName;
	
	@Column()
	private String symbol;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
