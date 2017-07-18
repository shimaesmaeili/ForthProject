package dao;

import java.math.BigInteger;
import java.sql.Date;

public class Real extends Customer {
	private BigInteger idCode;
	private String firstName;
	private String lastName;
	private String fatherName;
	private Date birthDate;

	public Real() {
	}

	public BigInteger getIdCode() {
		return idCode;
	}

	public void setIdCode(BigInteger idCode) {
		this.idCode = idCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
