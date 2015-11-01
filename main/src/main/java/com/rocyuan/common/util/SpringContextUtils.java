package com.rocyuan.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @author Administrator
 * @blog www.rocyuan.com
 * @email admin@rocyuan.com
 * @date 2015-8-14 1:58:27
 */
public class SpringContextUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		SpringContextUtils.applicationContext = arg0;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @param name
	 * @return Object
	 * @throws BeansException
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}
	
	public static <T>T getBean(String beanName,Class<T> classT)throws BeansException{
		return applicationContext.getBean(beanName, classT);
	}
}
