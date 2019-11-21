package chapter07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;

public class ClassDemo {

	public static void main(String[] args) {
		System.out.println("----String的Class类对象----");
		try {
			// 1.使用Class.forName("全限定类名")方法获取String类对象
			Class strClass = Class.forName("java.lang.String");
			System.out.println(strClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("----Float的Class类对象----");
		// 2.使用类的class属性获取Float类对应的Class对象
		Class fClass = Float.class;
		System.out.println(fClass);

		System.out.println("----Date类的Class类对象----");
		// 3.使用实例对象的getClass()方法获取Date类对应的Class对象
		Date nowTime = new Date();
		Class dateClass = nowTime.getClass();
		System.out.println(dateClass);

		System.out.println("----Date类的父类----");
		System.out.println(dateClass.getSuperclass());

		System.out.println("----Date类的所有构造方法----");
		// 获取所有构造方法
		Constructor[] ctors = dateClass.getDeclaredConstructors();
		for (Constructor c : ctors) {
			System.out.println(c);
		}

		System.out.println("----Date类的所有public方法----");
		// 获取所有public方法
		Method[] mtds = dateClass.getMethods();
		for (Method m : mtds) {
			System.out.println(m);
		}

		// 构造一个实例对象，构造类中必须提供相应的缺省构造方法实现
		try {
			Object obj = dateClass.newInstance();
			System.out.println(obj);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
