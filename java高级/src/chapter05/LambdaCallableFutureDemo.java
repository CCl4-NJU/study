package chapter05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class LambdaCallableFutureDemo {

	public static void main(String[] args) {

		//1.ʹ��Lambda���ʽ����Callable<Integer>����
		// 2.ʹ��FutureTask���װCallable����
		FutureTask<Integer> task = new FutureTask<Integer>(
				(Callable<Integer>) () -> {
					int i = 0;
					for (; i < 100; i++) {
						System.out.println(Thread.currentThread().getName()
								+ " : " + i);
					}
					// call()���������з���ֵ
					return i;
				});

		// 3.�����߳�,ʹ��FutureTask����task��ΪThread�����targer,������start()���������߳�
		new Thread(task, "���߳�").start();

		// 4.����FutrueTask����task��get()������ȡ���߳�ִ�н�����ķ���ֵ
		try {
			System.out.println("���̷߳���ֵ��" + task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		// ���߳�����
		for (int i = 1000; i < 1100; i++) {
			// ʹ��Thread.currentThread().getName()��ȡ���߳�����
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}

	}

}
