package dao;

import java.util.Set;

public class Loan {
	private int id;
	private String name;
	private int interestRate;
	private Set<GrantCondition> grantConditions;

	public Loan() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	public Set<GrantCondition> getGrantConditions() {
		return grantConditions;
	}

	public void setGrantConditions(Set<GrantCondition> grantConditions) {
		this.grantConditions = grantConditions;
	}
}
