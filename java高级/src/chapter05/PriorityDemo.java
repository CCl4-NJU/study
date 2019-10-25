package chapter05;

class MyPriorityThread extends Thread {
	public MyPriorityThread(String name) {
		super(name);
	}

	public void run() {

		for (int i = 0; i < 100; i++) {
			System.out.println(this.getName() + ",�����ȼ��ǣ�" + this.getPriority()
					+ ",ѭ��������ֵΪ:" + i);
		}
	}
}

public class PriorityDemo {

	public static void main(String[] args) {
		//������̵߳����ȼ�
		System.out.println(Thread.currentThread().getPriority());
		//�������߳�,�����ò�ͬ���ȼ�
		MyPriorityThread t1=new MyPriorityThread("�߼�");
		t1.setPriority(Thread.MAX_PRIORITY);
		
		MyPriorityThread t2=new MyPriorityThread("��ͨ");
				
		MyPriorityThread t3=new MyPriorityThread("�ͼ�");
		t3.setPriority(Thread.MIN_PRIORITY);
		
		MyPriorityThread t4=new MyPriorityThread("ָ��ֵ");
		t4.setPriority(8);
		
		//�����������߳�
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
