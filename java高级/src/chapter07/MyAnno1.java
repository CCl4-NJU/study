package com.qst.chapter07;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno1 {
	String comment();

	int order() default 1;
}
