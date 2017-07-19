package dao;

import java.math.BigInteger;

public class GrantCondition {
	private int id;
	private Loan loan;
	private String name;
	private int minDuration;
	private int maxDuration;
	private BigInteger minAmount;
	private BigInteger maxAmount;

	public GrantCondition() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinDuration() {
		return minDuration;
	}

	public void setMinDuration(int minDuration) {
		this.minDuration = minDuration;
	}

	public int getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	public BigInteger getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(BigInteger minAmount) {
		this.minAmount = minAmount;
	}

	public BigInteger getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigInteger maxAmount) {
		this.maxAmount = maxAmount;
	}
}
