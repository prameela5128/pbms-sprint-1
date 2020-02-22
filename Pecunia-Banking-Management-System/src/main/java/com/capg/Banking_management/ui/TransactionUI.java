package com.capg.Banking_management.ui;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.capg.Banking_management.dao.TransactionUsingChequeDAO;
import com.capg.Banking_management.dao.TransactionUsingChequeDAOImpl;
import com.capg.Banking_management.model.ChequeDetails;
import com.capg.Banking_management.service.TransactionService;
import com.capg.Banking_management.service.TransactionServiceImpl;

import exception.AccountException;
import exception.AmountLessException;
public class TransactionUI {
	static TransactionService ts=new TransactionServiceImpl();
	static ChequeDetails cd=new ChequeDetails();
	static TransactionUsingChequeDAO transactionService=new TransactionUsingChequeDAOImpl();
	static Random random=new Random();
	static Scanner in=new Scanner(System.in);
	public static void main(String []args) {
		 
		for(;;){
			int choice;
			System.out.println("Enter your choice");
			System.out.println("1-Credit Using Cheque");
			System.out.println("2-Debit Using Cheque");
			System.out.println("3-Exit");
			choice=in.nextInt();
			switch(choice){
			case 1:
				try {
				creditUsingChequeInfo();}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:try {
				debitUsingChequeInfo();}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			
			}
		}
	}
	 
 	private static void creditUsingChequeInfo() throws AccountException, AmountLessException  {
		 System.out.println("Enter payeeAccountNumber ");
		 String payeeAccountNumber =in.next();
		 cd.setPayeeAccountNumber(payeeAccountNumber);
		 System.out.println("Enter account number");
		 String accountNumber=in.next();
		 cd.setAccountNumber(accountNumber);
		 System.out.println("Enter cheque number");
		 String chequeNumber=in.next();
		 cd.setChequeNumber(chequeNumber);
		 System.out.println("Enter  cheque IFSC code");
		 String chequeIFSC=in.next();
		 cd.setChequeIFSC(chequeIFSC);
		 System.out.println("Enter amount to be credited");
		 int amount=in.nextInt();
		 cd.setAmount(amount);
		 System.out.println("Enter Bank name");
		 String chequeBankName=in.next();
		 cd.setChequeBankName(chequeBankName);
		 System.out.println("Enter Date");
		 String date=in.next();
		 DateTimeFormatter  format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 LocalDate chequeIssueDate=LocalDate.parse(date,format);
		 cd.setChequeIssueDate(chequeIssueDate);
		 boolean isValid=((TransactionServiceImpl) ts).isValid(cd);
		 
		 if(isValid){
		 
		 if(transactionService.creditUsingCheque(accountNumber,payeeAccountNumber, chequeNumber, chequeBankName, chequeIFSC, chequeIssueDate, amount)==true){
			 //System.out.println("TRANSACTION ID: "+ random.nextInt(100000000)+" Deposited "+amount+".RS to accountNumber "+accountNumber+" using cheque "+chequeNumber+" Successfully total amount = "+ amount+"\n"+" BankName - "+chequeBankName);
			 System.out.println("done....");
			  
		 	}
		 else{
			 
				throw new AmountLessException("please enter the amount in the valid range");
		 }
		 }
		
		 else{
			  
				throw new AccountException("Please enter valid input details");
		 }
		 
}
 	
 	
 	private static void debitUsingChequeInfo() throws AmountLessException, AccountException   {
 	  	 System.out.println("Enter account number");
		 String accountNumber=in.next();
		 cd.setAccountNumber(accountNumber);
		 System.out.println("Enter cheque number");
		 String chequeNumber=in.next();
		 cd.setChequeNumber(chequeNumber);
		 System.out.println("Enter  cheque IFSC code");
		 String chequeIFSC=in.next();
		 cd.setChequeIFSC(chequeIFSC);
		 System.out.println("Enter amount to be debited");
		 int amount=in.nextInt();
		 cd.setAmount(amount);
		 System.out.println("Enter Date");
		 String date=in.next();
		 DateTimeFormatter  format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 LocalDate chequeIssueDate=LocalDate.parse(date,format);
		 cd.setChequeIssueDate(chequeIssueDate);
		 boolean isValidd=((TransactionServiceImpl) ts).isValidd(cd);
		  
		  if(isValidd){
		
 		if(transactionService.debitUsingCheque(accountNumber, chequeNumber,chequeIFSC,chequeIssueDate,amount)==true){
			 			// System.out.println("Your Amount is debited with "+"TRANSACTION ID:"+ random.nextInt(100000000)+" using "+amount+" .rs from "+accountNumber+" and chequeNo "+chequeNumber+" to Account Number = "+accountNumber);
			 			System.out.println("done....");
 		}
		else{
		
				throw new AmountLessException("Insufficient balance");
			} 
		  
		}
		  else{
			  
				throw new AccountException("Please enter valid input details");
		 }
		 	
 	
 	}
}

 
 