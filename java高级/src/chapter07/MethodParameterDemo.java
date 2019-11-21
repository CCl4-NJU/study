package com.qst.chapter07;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

class MyClass {
	public void setName(String name) {
	}

	public void display(String str, List<String> list) {
	}
}

public class MethodParameterDemo {
	public static void main(String[] args) throws Exception {
		// 获取MyClass的类对象
		Class<MyClass> clazz = MyClass.class;
		// 获取MyClass类的所有public方法
		Method[] mtds = clazz.getMethods();
		for (Method m : mtds) {
			// 输出方法名
			System.out.println("方法名：" + m.getName());
			// 输出该方法参数个数
			System.out.println("参数个数：" + m.getParameterCount());
			// 获取该方法所有参数
			Parameter[] parameters = m.getParameters();
			int index = 1;
			// 遍历所有参数，并输出参数信息
			for (Parameter p : parameters) {
				if (p.isNamePresent()) {
					System.out.println("---第" + index++ + "个参数信息---");
					System.out.println("参数名：" + p.getName());
					System.out.println("形参类型：" + p.getType());
					System.out.println("泛型类型：" + p.getParameterizedType());
				}
			}
			System.out
					.println("----------------------------------------------");

		}
	}
}
