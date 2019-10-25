package chapter05;

//ʹ��ͬ�����ķ�ʽ
public class SynLockBank extends Thread {
	// �����˻�
	private BankAccountSynLock account;
	// ����������Ϊ��Ǯ������ΪȡǮ
	private double money;

	public SynLockBank(String name, BankAccountSynLock account, double money) {
		super(name);
		this.account = account;
		this.money = money;
	}

	// �߳�����
	public void run() {
		// ����account�����access()����
		this.account.access(money);
	}

	public static void main(String[] args) {
		// ����һ�������˻�ʵ��
		BankAccountSynLock myAccount = new BankAccountSynLock("60001002", 5000);
		// ��������̣߳����˻����д�ȡǮ����
		SynLockBank t1 = new SynLockBank("T001", myAccount, -3000);
		SynLockBank t2 = new SynLockBank("T002", myAccount, -3000);
		SynLockBank t3 = new SynLockBank("T003", myAccount, 1000);
		SynLockBank t4 = new SynLockBank("T004", myAccount, -2000);
		SynLockBank t5 = new SynLockBank("T005", myAccount, 2000);

		// �����߳�
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		// �ȴ��������߳����
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// ����˻���Ϣ
		System.out.println("�˺ţ�" + myAccount.getBankNo() + ", ��"
				+ myAccount.getBalance());
	}

}
