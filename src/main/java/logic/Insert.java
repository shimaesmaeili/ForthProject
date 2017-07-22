package logic;

import dao.*;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Insert {
	private static Logger log = Logger.getLogger(Insert.class);

	public static String insertNewRealCustomer(BigInteger idCode, String firstName, String lastName, String fatherName, Date birthDate) {
		if (Verify.getRealId(idCode) == null) {
			Real real = new Real();
			real.setIdCode(idCode);
			real.setFirstName(firstName);
			real.setLastName(lastName);
			real.setFatherName(fatherName);
			real.setBirthDate(birthDate);

			log.info("New real customer has been defined successfully.");
			return RealCRUD.insert(real);
		} else {
			log.error("The real customer did not defined!");
			return null;
		}
	}

	public static String insertNewLegalCustomer(BigInteger eCode, String name, Date registrationDate) {
		if (Verify.getLegalId(eCode) == null) {
			Legal legal = new Legal();
			legal.seteCode(eCode);
			legal.setName(name);
			legal.setRegistrationDate(registrationDate);

			log.info("New legal customer has been defined successfully.");
			return LegalCRUD.insert(legal);
		} else {
			log.error("The legal customer did not defined!");
			return null;
		}
	}

	public static void insertNewLoan(String loanName, int interestRate, String[] names, String[] minDurations, String[] maxDurations, String[] minAmounts, String[] maxAmounts) {
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

		log.info("New loan has been defined successfully.");
	}

	public static boolean createNewLoanFile(String customerId, int loanId, int duration, BigInteger amount) {
		if (Verify.hasValidCondition(loanId, duration, amount)) {
			LoanFile loanFile = new LoanFile();
			Loan loan = LoanCRUD.findLoanById(loanId);
			loanFile.setLoan(loan);
			Real real = RealCRUD.findById(customerId);
			loanFile.setRealCustomer(real);
			loanFile.setLoanDuration(duration);
			loanFile.setLoanAmount(amount);
			loanFile.setId(real.getId());
			LoanFileCRUD.insert(loanFile);

			log.info("New loan file has been defined for customer with id " + customerId);
			return true;
		} else {
			log.error("Loan file for customer with id " + customerId + " did not defined!");
			return false;
		}
	}
}
