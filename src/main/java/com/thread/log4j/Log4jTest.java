package com.thread.log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Log4jTest {

	private static Log logger = LogFactory.getLog(Log4jTest.class);

	public static void main(String[] args) {
		for (int i = 10; i > -1; i--) {
			logger.info("开始执行第" + i + "线程");
			int a = 0;
			try {
				a = 100 / i;
				logger.info("100除以" + i + "的结果为" + a);
			} catch (Exception e) {
				logger.error("100除以" + i + "出现异常", e);
			}
		}
	}

}
