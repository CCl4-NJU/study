package chapter05;

//�����ʻ�
public class BankAccount {
	// �����˺�
	private String bankNo;
	// �������
	private double balance;

	// ���췽��
	public BankAccount(String bankNo, double balance) {
		this.bankNo = bankNo;
		this.balance = balance;
	}

	// getter/setter����
	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
