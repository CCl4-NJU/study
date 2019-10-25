package chapter05;

public class IllegalThreadDemo {

	public static void main(String[] args) {
		// �����߳�
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(i);
				}
			}
		});
		// ��������߳̽�����IllegalThreadStateException�쳣
		t.start();
		t.start();
	}

}
