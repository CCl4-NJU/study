package chapter05;


public class MainThreadDemo {
	// main()����
	public static void main(String args[]) {
		// ����Thread���currentThread()������ȡ��ǰ�߳�
		Thread t = Thread.currentThread();
		// �����߳���
		t.setName("MyMainThread");
		// ����߳���Ϣ
		System.out.println("���߳���: " + t);
		// ��ȡ�߳�Id
		System.out.println("�߳�ID��" + t.getId());
		// ��ȡ�߳���
		System.out.println("�߳�����" + t.getName());
	}
}
