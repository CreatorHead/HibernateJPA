package advance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	private int accountId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="account_type")
	private AccountType accountType;

	public int getAccountId() {
		return accountId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
