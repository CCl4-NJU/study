package chapter05;

//产品
class Product {
	int n;
	// 为true时表示有值可取，为false时表示需要放入新值
	boolean valueSet = false;

	// 生产方法
	synchronized void put(int n) {
		// 如果没有值，等待线程取值
		if (valueSet) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.n = n;
		// 将valueSet设置为true，表示值已放入
		valueSet = true;
		System.out.println(Thread.currentThread().getName() + "-生产:" + n);
		// 通知等待线程，进行取值操作
		notify();
	}

	// 消费方法
	synchronized void get() {
		// 如果没有值，等待新值放入
		if (!valueSet) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + "-消费:" + n);
		// 将valueSet设置为false，表示值已取
		valueSet = false;
		// 通知等待线程，放入新值
		notify();
	}
}

// 生产者
class Producer implements Runnable {
	Product product;

	Producer(Product product) {
		this.product = product;
		new Thread(this, "Producer").start();
	}

	public void run() {
		int k = 0;
		// 生产10次
		for (int i = 0; i < 10; i++) {
			product.put(k++);
		}
	}
}

// 消费者
class Consumer implements Runnable {
	Product product;

	Consumer(Product product) {
		this.product = product;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		// 消费10次
		for (int i = 0; i < 10; i++) {
			product.get();
		}
	}
}

public class WaitNotifyDemo {
	public static void main(String args[]) {
		// 实例化一个产品对象，生产者和消费者共享该实例
		Product product = new Product();
		// 指定生产线程
		Producer producer = new Producer(product);
		// 指定消费线程
		Consumer consumer = new Consumer(product);
	}
}
