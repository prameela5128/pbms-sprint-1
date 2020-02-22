
package com.capg.Banking_management.dao;

import java.util.Date;
import java.awt.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;


import com.capg.Banking_management.model.Transaction;
import com.capg.Banking_management.model.TransactionModel;



public class TransactionUsingChequeDAOImpl implements TransactionUsingChequeDAO{
	static Random random=new Random();
	public static Map<String,TransactionModel> transactionModel=new HashMap<String,TransactionModel>();
	public TransactionUsingChequeDAOImpl(){
		addSomeAccountDetails();
	}
	public void addSomeAccountDetails(){
		TransactionModel t1=new TransactionModel("123456789012","Rebeca",3000,
				Arrays.asList(new Transaction(LocalDate.now())));
		TransactionModel t2=new TransactionModel("123456789013","Prameela",4000,
				Arrays.asList(new Transaction(LocalDate.now())));
		transactionModel.put(t1.getAccountNumber(),t1);
		transactionModel.put(t2.getAccountNumber(),t2);
		
	}

//	public boolean addAccountDetails(TransactionModel accountDetails) {
//		if(transactionModel.containsKey(accountDetails)) {
//			return false;
//		}
//		transactionModel.put(accountDetails.getAccountNumber(), accountDetails);
//		return true;
//	
//	}
//	public boolean getAccountDetailsByID(String accountNumber) {
//		if(!transactionModel.containsKey(accountNumber)) {
//			System.out.println("No Account Found");
//			return false;
//		}
//		TransactionModel bal=transactionModel.get(accountNumber);
//	 
//		
//		 return true;
//	}
     
	public double getBalanceByID(String accountNumber) {
		if(!transactionModel.containsKey(accountNumber)) {
			System.out.println("No Account Found");
			return 0;
		}
		TransactionModel bal=transactionModel.get(accountNumber);
		 return bal.getBalance();
		 

	}
	 
	public boolean addAmount(String accountNumber,int amount) {
		if(!transactionModel.containsKey(accountNumber)) {
			return false;
		}
		TransactionModel acc=transactionModel.get(accountNumber);
		acc.setBalance(acc.getBalance()+amount);
		return true;
		
		
	}
	public boolean deductAmount(String accountNumber,int amount) {
		if(!transactionModel.containsKey(accountNumber)) {
			return false;
		}
		TransactionModel acc=transactionModel.get(accountNumber);
		acc.setBalance(acc.getBalance()-amount);
		return true;
		
		
	}
	 
		
	public boolean creditUsingCheque(String accountNumber, String payeeAccountNumber, String chequeNumber,
			String chequeBankName, String chequeIFSC, LocalDate chequeIssueDate, int amount) {
			if(amount<100 ||amount>200000){
				return false;
			}
			addAmount(accountNumber,amount);
			 System.out.println("TRANSACTION ID: "+ random.nextInt(100000000)+" Deposited "+amount+".RS to accountNumber "+accountNumber+" using cheque "+chequeNumber+" Successfully total amount = "+ getBalanceByID(accountNumber)+"\n"+" BankName - "+chequeBankName);
	  			 
				return true;
			
		
  	}

	public boolean debitUsingCheque(String accountNumber, String chequeNumber,String chequeIFSC, LocalDate chequeIssueDate, int amount) {//		try{
			if(getBalanceByID(accountNumber)<amount){
				 return false;
			}
			 	 		 
			deductAmount(accountNumber,amount);
			 System.out.println("Your Amount is debited with "+"TRANSACTION ID:"+ random.nextInt(100000000)+" using "+amount+" .rs from "+accountNumber+" and chequeNo "+chequeNumber+" to Account Number = "+accountNumber+" total balance "+getBalanceByID(accountNumber));
				
				//System.out.println("withdrawn "+amount+" .rs from "+accountNumber+" using chequeNo "+chequeNumber+" Successfully total amount = "+getBalanceByID(accountNumber));
			
		 

		return true;


 	}
 	 
	 
 	  
	 
	 
  
	 
	
}

 


 
