package chapter05;

//1. ThreadTask类（线程任务类）实现Runnable接口
class ThreadTask implements Runnable {
	// 重写run方法，任务方法
	public void run() {
		// 获取当前线程的名字
		for (int i = 0; i < 100; i++) {
			// 实现Runnable接口时，只能使用Thread.currentThread()获取当前线程
			// 再调用getName()方法返回当前线程的名字
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
}

public class RunnableDemo {

	public static void main(String[] args) {
		// 2.创建一个Thread类的实例,其参数是ThreadTask类的对象
		Thread t = new Thread(new ThreadTask());
		// 3.调用start()方法启动线程
		t.start();

		// 主线程任务
		for (int i = 1000; i < 1100; i++) {
			// 使用Thread.currentThread().getName()获取主线程名字
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}

	}

}
