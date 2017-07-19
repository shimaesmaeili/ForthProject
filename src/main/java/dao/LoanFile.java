package dao;

import java.math.BigInteger;

public class LoanFile {
	int id;
	Real realCustomer;
	Loan loan;
	int loanDuration;
	BigInteger loanAmount;

	public LoanFile() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
