package com.qst.chapter07;

import java.lang.reflect.Method;

//使用自定义的@ MyAnno1注解修饰类
@MyAnno1(comment = "类注解")
class MyClass1 {
	@MyAnno1(comment = "不带参数的方法", order = 2)
	public void myMethod() {
	}
}

public class MyAnno1Demo {
	public static void main(String[] args) throws Exception {
		// 获取MyClass1类注解
		MyAnno1 anno1 = MyClass1.class.getAnnotation(MyAnno1.class);
		// 输出类注解信息
		System.out.println("MyClass1类的注解信息为：" + anno1.comment() + "，序号"
				+ anno1.order());

		// 获取MyClass1类的myMethod()方法
		Method mth = MyClass1.class.getMethod("myMethod");
		// 获取myMethod()方法的注解
		MyAnno1 anno2 = mth.getAnnotation(MyAnno1.class);
		// 输出方法注解的信息
		System.out.println("myMethod()方法的注解信息为：" + anno2.comment() + "，序号"
				+ anno2.order());
	}
}
