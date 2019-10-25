package chapter05;

//�����ʻ�
//����ͬ������
public class BankAccountSynMethod {
	// �����˺�
	private String bankNo;
	// �������
	private double balance;

	// ���췽��
	public BankAccountSynMethod(String bankNo, double balance) {
		this.bankNo = bankNo;
		this.balance = balance;
	}

	// ͬ������,��ȡǮ����
	public synchronized void access(double money) {

		// ��������Ľ��money<0,�����ȡǮ����,ͬʱ�ж��˻�����Ƿ����ȡǮ���
		if (money < 0 && balance < -money) {
			System.out.println(Thread.currentThread().getName() + "����ʧ�ܣ����㣡");
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
