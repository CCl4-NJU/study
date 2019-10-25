package chapter05;


public class MainThreadDemo {
	// main()方法
	public static void main(String args[]) {
		// 调用Thread类的currentThread()方法获取当前线程
		Thread t = Thread.currentThread();
		// 设置线程名
		t.setName("MyMainThread");
		// 输出线程信息
		System.out.println("主线程是: " + t);
		// 获取线程Id
		System.out.println("线程ID：" + t.getId());
		// 获取线程名
		System.out.println("线程名：" + t.getName());
	}
}
