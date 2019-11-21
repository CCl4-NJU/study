package com.qst.chapter07;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface AnnolContents {// 该注解是容器
	// 定义value成员变量，该成员变量可接受多个@RepeatableAnnol注解
	RepeatableAnnol[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(AnnolContents.class)
public @interface RepeatableAnnol {// 该注解可以重复
	// 为该注解定义2个成员变量
	String name() default "青软实训";

	int age();
}
