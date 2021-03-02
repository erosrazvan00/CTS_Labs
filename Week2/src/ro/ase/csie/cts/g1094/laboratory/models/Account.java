package ro.ase.csie.cts.g1094.laboratory.models;

import ro.ase.csie.cts.g1094.laboratory.exceptions.IllegalTransferException;
import ro.ase.csie.cts.g1094.laboratory.exceptions.InsuficientFundsException;

public abstract class Account {
	
	public abstract void deposit(Double amount);
	public abstract void withdraw(Double amount) throws InsuficientFundsException;
	public abstract Object getBalance();
	public abstract void transfer(Account destination, Double amount) throws InsuficientFundsException, IllegalTransferException;
}
