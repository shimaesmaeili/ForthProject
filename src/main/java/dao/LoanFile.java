package dao;

import java.math.BigInteger;

public class LoanFile {
	private String id;
	private Real realCustomer;
	private Loan loan;
	private int loanDuration;
	private BigInteger loanAmount;

	public LoanFile() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Real getRealCustomer() {
		return realCustomer;
	}

	public void setRealCustomer(Real realCustomer) {
		this.realCustomer = realCustomer;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public int getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}

	public BigInteger getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigInteger loanAmount) {
		this.loanAmount = loanAmount;
	}
}
