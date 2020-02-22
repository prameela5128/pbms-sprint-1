package testPecunia;

import static org.junit.Assert.*;

 
 
import java.util.Map;

import org.junit.Test;

import com.capg.Banking_management.dao.TransactionUsingChequeDAO;
import com.capg.Banking_management.dao.TransactionUsingChequeDAOImpl;
import com.capg.Banking_management.model.ChequeDetails;
import com.capg.Banking_management.model.TransactionModel;
import com.capg.Banking_management.service.TransactionService;
import com.capg.Banking_management.service.TransactionServiceImpl;

public class TestDAO {
	ChequeDetails c=new ChequeDetails();
	TransactionService ts=new TransactionServiceImpl();
	TransactionUsingChequeDAO dao=new TransactionUsingChequeDAOImpl();
	Map<String,TransactionModel> transactionModel=TransactionUsingChequeDAOImpl.transactionModel;
	@Test
	public void test() {
		assertEquals(true, ts.addAmount("123456789012", 2000));
		 
	}
	@Test
	public void testAddAmount() {
		assertEquals(true, ts.addAmount("123456789012", 200));
		 
	}
	@Test
	public void testDeductAmount() {
		assertEquals(true, ts.deductAmount("123456789012" , 200));
		 
	}
	@Test
	public void testCreditUsingCheque() {
		assertEquals(true, ts.creditUsingCheque("123456789012","100000000001", "123456", "pecunia", "SBIN012345",  c.getChequeIssueDate(), 200));
		 
	}
	@Test
	public void testDebitUsingCheque() {
		assertEquals(true, ts.debitUsingCheque("123456789012", "123456" , "SBIN012345",  c.getChequeIssueDate(), 200));
		 
	}
	 
}
