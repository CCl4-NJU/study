package chapter05;
//û��ͬ���ķ�ʽ
public class NoSynBank extends Thread {
	// �����˻�
	private BankAccount account;
	// ����������Ϊ��Ǯ������ΪȡǮ
	private double money;

	public NoSynBank(String name, BankAccount account, double money) {
		super(name);
		this.account = account;
		this.money = money;
	}

	// �߳�����
	public void run() {
		// ��ȡĿ�˻��Ľ��
		double d = this.account.getBalance();
		// ��������Ľ��money<0,�����ȡǮ����,ͬʱ�ж��˻�����Ƿ����ȡǮ���
		if (money < 0 && d < -money) {
			System.out.println(this.getName() + "����ʧ�ܣ����㣡");
			// ����
			return;
		} else {
			// ���˻������в���
			d += money;
			System.out.println(this.getName() + "�����ɹ���Ŀǰ�˻����Ϊ��" + d);
			try {
				// ����1����
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// �޸��˻����
			this.account.setBalance(d);

		}
	}

	public static void main(String[] args) {
		// ����һ�������˻�ʵ��
		BankAccount myAccount = new BankAccount("60001002", 5000);
		// ��������̣߳����˻����д�ȡǮ����
		NoSynBank t1 = new NoSynBank("T001", myAccount, -3000);
		NoSynBank t2 = new NoSynBank("T002", myAccount, -3000);
		NoSynBank t3 = new NoSynBank("T003", myAccount, 1000);
		NoSynBank t4 = new NoSynBank("T004", myAccount, -2000);
		NoSynBank t5 = new NoSynBank("T005", myAccount, 2000);

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
