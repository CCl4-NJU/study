package chapter05;

//1.�̳�Thread��
public class ThreadDemo extends Thread {
	// ��дrun()�������̵߳����񷽷�����ִ����
	public void run() {

		for (int i = 0; i < 100; i++) {
			// �̳�Thread��ʱ��ֱ��ʹ��this���ɻ�ȡ��ǰ�̶߳���
			// ����getName()�������ص�ǰ�̵߳�����
			System.out.println(this.getName() + " : " + i);
		}
	}

	public static void main(String[] args) {
		// 2.�����̶߳���
		ThreadDemo td = new ThreadDemo();
		// 3.����start()���������߳�
		td.start();

		// ���߳�����
		for (int i = 1000; i < 1100; i++) {
			// ʹ��Thread.currentThread().getName()��ȡ���߳�����
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}

}
