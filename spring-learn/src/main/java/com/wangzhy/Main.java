package com.wangzhy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangzhy
 * @date 2024年05月16日
 */
public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		A bean = context.getBean(A.class);
		System.out.println(bean);
	}
}