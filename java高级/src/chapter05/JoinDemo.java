package chapter05;

class JoinThread extends Thread {
	public JoinThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.getName() + " : " + i);
		}
	}
}

public class JoinDemo {

	public static void main(String[] args) {

		//创建子线程t1
		JoinThread t1 = new JoinThread("被Join的子线程");
		// 启动t1子线程
		t1.start();

		try {
			// 等待t1子线程执行完毕
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 输出主线程名
		System.out.println(Thread.currentThread().getName());

		// t1子线程已经死亡,isAlive()为false
		System.out.println("子线程死亡状态[isAlive: " + t1.isAlive() + "]");
		// 试图再次启动t1子线程，此时t1子线程已经死亡，再次启动将抛出IllegalThreadStateException
		t1.start();
	}

}
