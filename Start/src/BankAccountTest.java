class BankAccount{
	int balance=0;
	void deposit(int amount) {
		System.out.println("���� �ܾ�" + (balance+amount));
	}
	
	void withdraw(int amount) {
		if((balance-amount)>=0) 
			System.out.println("��� �� �ܾ��� "+(balance-amount));
			
			else 
				System.out.println("�ܾ��� �����մϴ�.");
		
	}
	
	int getBalance() {
		return balance;
	}
}


public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount b = new BankAccount();
		b.balance=160;
		
		b.deposit(30);
		b.withdraw(200);
		b.withdraw(60);
		
	}

}
