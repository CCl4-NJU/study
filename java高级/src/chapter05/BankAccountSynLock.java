package chapter05;

import java.util.concurrent.locks.ReentrantLock;

//�����ʻ�
//ͬ�����ķ�ʽ
public class BankAccountSynLock {
	// �����˺�
	private String bankNo;
	// �������
	private double balance;

	// ����������
	private final ReentrantLock lock = new ReentrantLock();

	// ���췽��
	public BankAccountSynLock(String bankNo, double balance) {
		this.bankNo = bankNo;
		this.balance = balance;
	}

	// ��ȡǮ����
	public void access(double money) {
		// ����
		lock.lock();
		try {
			// ��������Ľ��money<0,�����ȡǮ����,ͬʱ�ж��˻�����Ƿ����ȡǮ���
			if (money < 0 && balance < -money) {
				System.out.println(Thread.currentThread().getName()
						+ "����ʧ�ܣ����㣡");
				// ����
				return;
			} else {
				// ���˻������в���
				balance += money;
				System.out.println(Thread.currentThread().getName()
						+ "�����ɹ���Ŀǰ�˻����Ϊ��" + balance);
				try {
					// ����1����
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			// �ͷ���
			lock.unlock();
		}
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
