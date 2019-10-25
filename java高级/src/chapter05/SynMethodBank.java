package chapter05;

//ʹ��ͬ�������ķ�ʽ
public class SynMethodBank extends Thread {
	// �����˻�
	private BankAccountSynMethod account;
	// ����������Ϊ��Ǯ������ΪȡǮ
	private double money;

	public SynMethodBank(String name, BankAccountSynMethod account, double money) {
		super(name);
		this.account = account;
		this.money = money;
	}
	// �߳�����
	public void run() {
         //����account�����ͬ������
		this.account.access(money);
	}

	public static void main(String[] args) {
		// ����һ�������˻�ʵ��
		BankAccountSynMethod myAccount = new BankAccountSynMethod("60001002", 5000);
		// ��������̣߳����˻����д�ȡǮ����
		SynMethodBank t1 = new SynMethodBank("T001", myAccount, -3000);
		SynMethodBank t2 = new SynMethodBank("T002", myAccount, -3000);
		SynMethodBank t3 = new SynMethodBank("T003", myAccount, 1000);
		SynMethodBank t4 = new SynMethodBank("T004", myAccount, -2000);
		SynMethodBank t5 = new SynMethodBank("T005", myAccount, 2000);

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
