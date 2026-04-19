package sample;

interface BankService {
    void createAccount(String name);
    void credit(double amount);
    void debit(double amount);
    void transfer(double amount, String toAccount);
    void miniStatement();
    double rateOfInterest = 4.5;
}
class SBI implements BankService {
    public void createAccount(String name) {
    	System.out.println("SBI Account created for " + name); 
    	}
    public void credit(double amt) { 
    	System.out.println("SBI Credited: " + amt); 
    	}
    public void debit(double amt) { 
    	
    	System.out.println("SBI Debited: " + amt); 
  	}
    public void transfer(double amt, String to) {
    	System.out.println("SBI Transferred " + amt + " to " + to);
    	}
    public void miniStatement() {
    	System.out.println("SBI Mini Statement"); 
    	}
}
class Axis implements BankService {
    public void createAccount(String name) { 
    	System.out.println("Axis Account created for " + name); 
    	}
    public void credit(double amt) {
    	System.out.println("Axis Credited: " + amt);
    	}
    public void debit(double amt) {
    	System.out.println("Axis Debited: " + amt); 
    	}
    public void transfer(double amt, String to) { 
    	System.out.println("Axis Transferred " + amt + " to " + to); 
    	}
    public void miniStatement() {
    	System.out.println("Axis Mini Statement"); 
  	}
}
public class MainBank {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankService bank;
        bank = new SBI();  // Late binding
        bank.createAccount("Rahul");
        bank.credit(1000);
        bank = new Axis(); // Late binding
        bank.createAccount("Asha");
        bank.debit(500);
	}
}
