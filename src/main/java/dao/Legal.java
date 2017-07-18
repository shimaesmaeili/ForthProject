package dao;

import java.math.BigInteger;
import java.sql.Date;

public class Legal extends Customer {
	private BigInteger eCode;
	private String name;
	private Date registrationDate;

	public Legal() {
	}

	public BigInteger geteCode() {
		return eCode;
	}

	public void seteCode(BigInteger eCode) {
		this.eCode = eCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
}
