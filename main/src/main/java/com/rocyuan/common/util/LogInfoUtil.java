
package com.rocyuan.common.util;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author yuanzp@jpush.cn
 * @date 2015-6-3
 * @desc ��ӡ������־��Ϣ ���ο�
 */
public class LogInfoUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(LogInfoUtil.class);

	public static abstract class Printor<T> {
		private String title;

		public Printor(String title) {
			this.title = title;
		}

		public Printor() {
			Class<T> classT = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
			title = classT.getSimpleName();
		}

		private void printHead() {
			if (logger.isDebugEnabled() || logger.isInfoEnabled()) {
				logger.info(String
						.format("********************\t %s BEGIN \t********************",
								title));
			}
		}

		protected abstract void print(T t);

		private void printTail() {
			if (logger.isDebugEnabled() || logger.isInfoEnabled()) {
				logger.info(String
						.format("********************\t %s BEGIN \t********************",
								title));
			}
		}

		/**
		 * ��ӡ�� ��� �����޲�Get ������Ϣ 
		 * @param t
		 */
		private void printGet(T t) {
			if ( logger.isDebugEnabled() || logger.isInfoEnabled() ) {
				Class<T> classT = (Class<T>) ((ParameterizedType) getClass()
						.getGenericSuperclass()).getActualTypeArguments()[0];
				Method[] methods = classT.getDeclaredMethods();
				for ( Method m : methods ) {
					String methodName = m.getName() ;
					if ( methodName.startsWith("get") ) {
						Class<?>[] paramType = m.getParameterTypes();
						Class<?> returnType = m.getReturnType();
						if ( (paramType == null || paramType.length == 0) && returnType != void.class ) {
							try {
								logger.info(String.format("\t%s : %s", methodName , m.invoke(t)));
							} catch (Exception e) {
								
							} 
						}
					}
				}
			}			
		}

		public void printInfo(T t) {
			printHead();
			print(t);
			printTail();
		}

		public void printAll(T t) {
			printHead();
			print(t);
			printGet(t);
			printTail();
		}
	}

	public static void print(String title, HttpServletRequest request) {
		new Printor<HttpServletRequest>("request info") {
			@Override
			protected void print(HttpServletRequest request) {
				if (logger.isDebugEnabled() || logger.isInfoEnabled()) {
					String uri = request.getRequestURI();// �����������е���Դ����
					String url = request.getRequestURL().toString();// ��ÿͻ��˷������������url
					String ip = request.getRemoteAddr();// ���ط��������IP��ַ
					String params = request.getQueryString();// �����������еĲ�������
					String host = request.getRemoteHost();// ���ط�������Ŀͻ�����������
					int port = request.getRemotePort();// ���ط�������Ŀͻ����Ķ˿ںš�
					logger.info("\tURI :" + uri);
					logger.info("\turl :" + url);
					logger.info("\tip :" + ip);
					logger.info("\tparams :" + params);
					logger.info("\thost :" + host);
					logger.info("\tport :" + port);					
				}
			}
		}.printInfo(request);
	}		

	
	public static void printJVM () {
		Properties properties = System.getProperties();
		properties.list(System.out);
	}

	public static void main(String[] args) {
		printJVM();
	}

}
