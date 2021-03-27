/**
 * 
 */
package design.patterns;

/**
 * @author mayank
 * 
 * It is a structural design pattern. This pattern provides a simplified interface to client which hides
 * the complexity of the system from the client. The client will only see the layer it is interacting with.
 * The simplified Interface/Class contains a set of Interfaces or Classes.
 *
 */
class AccountNumberCheck{
	private int accntNum = 123456789;
	
	public int getAccntNum() { return accntNum; }
	
	public boolean accountActive(int accNumCheck) {
		if(accNumCheck == getAccntNum()) return true;
		else return false;
	}
}

class SecurityCodeCheck{
	private int secCode = 1234;
	
	public int getSecCode() { return secCode; }
	
	public boolean isCodeCorrect(int secCodeToCheck) {
		if(secCodeToCheck == getSecCode()) return true;
		else return false;
	}
}

class FundsCheck{
	private double cash = 1000.0;
	
	public double getCash() { return cash; }
	
	public void decreaseCash(double amount) {
		cash -= amount;
	}
	
	public void increaseCash(double amount) {
		cash += amount;
	}
	
	public boolean balanceCheck(double amountToWithdrawl) {
		if(amountToWithdrawl > getCash()) {
			System.out.println("Not Enough Money in account");
			return false;
		}else {
			decreaseCash(amountToWithdrawl);
			System.out.println("Amount withdrawn : "+amountToWithdrawl);
			return true;
		}
	}
	
	public void makeDeposit(double amount) {
		increaseCash(amount);
		System.out.println("Amount deposited in account : "+amount);
	}
}

class BankAccountFacade{
	private int accountNumber;
	private int securityCode;
	
	private AccountNumberCheck accountChecker;
	private SecurityCodeCheck codeChecker;
	private FundsCheck fundChecker;
	
	public BankAccountFacade(int accountNumber, int securityCode) {
		this.accountNumber = accountNumber;
		this.securityCode = securityCode;
		
		accountChecker = new AccountNumberCheck();
		codeChecker = new SecurityCodeCheck();
		fundChecker = new FundsCheck();
	}
	
	public int getAccountNumber() { return accountNumber; }
	public int getSecurityCode() { return securityCode; }
	
	public void withdrawCash(double cash) {
		if(accountChecker.accountActive(accountNumber) && 
				codeChecker.isCodeCorrect(securityCode) &&
				fundChecker.balanceCheck(cash)) {
			
			System.out.println("Transaction Completed!");
		}else {
			System.out.println("Transaction Failed!");
		}
	}
	
	public void makeDeposit(double cash) {
		if(accountChecker.accountActive(accountNumber) && 
				codeChecker.isCodeCorrect(securityCode)) {
			
			fundChecker.makeDeposit(cash);
			System.out.println("Transaction Completed!");
		}else {
			System.out.println("Transaction Failed!");
		}
	}
}

public class FacadePattern {
	public static void main(String[] args) {
		BankAccountFacade facade = new BankAccountFacade(123456789, 1234);
		
		facade.withdrawCash(300.0);
		facade.withdrawCash(800.0);
		facade.makeDeposit(900.0);
		facade.withdrawCash(200.0);
	}
}
