package com.capg.Banking_management.service;

import java.time.LocalDate;
import java.util.Date;

import com.capg.Banking_management.model.ChequeDetails;
import com.capg.Banking_management.model.TransactionModel;

public interface TransactionService {
	public boolean creditUsingCheque( String accountNumber,String payeeAccountNumber,  String chequeNumber,
			String chequeBankName, String chequeIFSC, LocalDate chequeIssueDate, int amount);
	public boolean debitUsingCheque(String accountNumber,  String chequeNumber, String chequeIFSC, LocalDate chequeIssueDate, int amount);
	//public boolean addAccountDetails(TransactionModel accountDetails );
	
	 
	public double getBalanceByID(String accountNumber);
	  
	 public boolean addAmount(String accountNumber,int amount) ;
	 public boolean deductAmount(String accountNumber,int amount) ;
	 
	 public void addSomeAccountDetails();
	 
			
}
