package logic;

import dao.*;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Insert {
	public static String insertNewRealCustomer(BigInteger idCode, String firstName, String lastName, String fatherName, Date birthDate) throws SQLException, ClassNotFoundException {
		Real real = new Real();
		real.setIdCode(idCode);
		real.setFirstName(firstName);
		real.setLastName(lastName);
		real.setFatherName(fatherName);
		real.setBirthDate(birthDate);

		return RealCRUD.insert(real);
	}

	public static String insertNewLegalCustomer(BigInteger eCode, String name, Date registrationDate) throws SQLException, ClassNotFoundException {
		Legal legal = new Legal();
		legal.seteCode(eCode);
		legal.setName(name);
		legal.setRegistrationDate(registrationDate);

		return LegalCRUD.insert(legal);
	}

	public static void insertNewLoan(String loanName, int interestRate, String[] names, String[] minDurations, String[] maxDurations, String[] minAmounts, String[] maxAmounts) throws SQLException, ClassNotFoundException {
		System.out.println("CCC: " + loanName);
		Loan loan = new Loan();
		loan.setName(loanName);
		loan.setInterestRate(interestRate);
		Set<GrantCondition> grantConditions = new HashSet<GrantCondition>();
		for (int i=0; i<names.length; i++) {
			GrantCondition grantCondition = new GrantCondition();
			grantCondition.setName(names[i]);
			grantCondition.setMinDuration(Integer.parseInt(minDurations[i]));
			grantCondition.setMaxDuration(Integer.parseInt(maxDurations[i]));
			grantCondition.setMinAmount(new BigInteger(minAmounts[i]));
			grantCondition.setMaxAmount(new BigInteger(maxAmounts[i]));
			grantCondition.setLoan(loan);

			grantConditions.add(grantCondition);
		}
		loan.setGrantConditions(grantConditions);

		LoanCRUD.insert(loan);
	}

	public static void createNewLoanFile(String customerId, int loanId, int duration, BigInteger amount) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {
		System.out.println(duration + " + " + amount);

		LoanFile loanFile = new LoanFile();
		Loan loan = LoanCRUD.findLoanById(loanId);
		loanFile.setLoan(loan);
		Real real = RealCRUD.findById(customerId);
		loanFile.setRealCustomer(real);
		loanFile.setLoanDuration(duration);
		loanFile.setLoanAmount(amount);
		loanFile.setId(real.getId());

//		RealCRUD.addLoanFile(loanFile);
		LoanFileCRUD.insert(loanFile);
	}
}
