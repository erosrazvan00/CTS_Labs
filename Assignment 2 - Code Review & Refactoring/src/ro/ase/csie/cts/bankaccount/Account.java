package ro.ase.csie.cts.bankaccount;  //I created a more specific package name according to the "theme" of the code

import ro.ase.csie.cts.bankaccount.exceptions.InvalidActiveDaysException;
import ro.ase.csie.cts.bankaccount.exceptions.InvalidLoanValueException;
import ro.ase.csie.cts.bankaccount.exceptions.InvalidRateException;

public class Account implements GetRateInterface {
	private double loanValue;
	private double rateValue;
	private int	activeDays;
	
	public static final int totalNrDays = 365;
	public static final double brokerFee = 0.0125f;
	
	private AccountTypes accountType; //enum with types: standard, budget, premium, superPremium
	
	
	public Account(double loanValue, double rateValue, int activeDays, AccountTypes accountType) 
			throws InvalidActiveDaysException, InvalidRateException, InvalidLoanValueException {
		if(loanValue<=0)
			throw new InvalidLoanValueException("The value of loan must be grater than 0");
		if(rateValue<0 || rateValue>1)
			throw new InvalidRateException("The value of the rate is always betweem 0 & 1");
		if(activeDays<1 || activeDays>365)
			throw new InvalidActiveDaysException("Active days should be between 1 and 365");
		
		this.accountType=accountType;
		this.loanValue=loanValue;
		this.activeDays=activeDays;
		this.rateValue=rateValue;
	}


	@Override
	public String toString() {
		return "Account [loanValue=" + loanValue + ", rateValue=" + rateValue + ", activeDays=" + activeDays
				+ ", accountType=" + accountType + "]";
	}

	//must have method - the lead has requested it in all classes
	@Override
	public double getMonthlyRate() {
		return rateValue * loanValue;
	}


	public double getLoanValue() {
		return loanValue;
	}


	public void setLoanValue(double loanValue) throws InvalidLoanValueException {
		
		if(loanValue<=0) 
			throw new InvalidLoanValueException("The value of loan must be grater than 0");
		
		this.loanValue=loanValue;
	}
	
	public double calculateFee (Account[] accounts) {
		double totalFee=0;
		if(accounts != null) //if accounts are empty the function have no meaning
			for(int i=0; i<accounts.length;i++) {
				if(accounts[i].accountType == AccountTypes.premium
						|| accounts[i].accountType == AccountTypes.superPremium)
					totalFee += brokerFee * (accounts[i].loanValue *
							Math.pow(accounts[i].rateValue, accounts[i].activeDays/totalNrDays) - accounts[i].loanValue);					
			}
		
		return totalFee;
	}
	
}