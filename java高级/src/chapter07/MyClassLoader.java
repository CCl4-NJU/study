package chapter07;

import java.io.File;
import java.io.FileInputStream;

class Animal {
	public void say() {
		System.out.println("这是一个Animal类");
	}
}
public class MyClassLoader extends ClassLoader {
	/**
	 * 重写findClass()方法
	 */
	public Class<?> findClass(String className) {
		byte[] data = loadClassData(className);
		// 调用ClassLoader的defineClass方法将二进制数据转换成Class对象
		return this.defineClass(className, data, 0, data.length);
	}

	public byte[] loadClassData(String className) {
		try {
			// 获取获取当前项目路径
			String path = this.getClass().getResource("/").getPath();
			path = path.substring(1);
			className = className.replace(".", "/");
			//class文件绝对路径
			File classfile = new File(path+className + ".class");
			long len = classfile.length();
			byte[] raw = new byte[(int) len];
			FileInputStream fin = new FileInputStream(classfile);
			// 一次读取class文件的全部二进制数据
			int r = fin.read(raw);
			if (r != len) {
				System.out.println("无法读取全部文件!");
				return null;
			} else {
				return raw;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		// 新建一个类加载器
		MyClassLoader mcl = new MyClassLoader();

		// 加载类，得到Class对象
		Class<?> clazz = mcl.loadClass("com.qst.chapter07.Animal");

		// 获取类的实例
		Animal animal = (Animal) clazz.newInstance();
		animal.say();
	}
}
