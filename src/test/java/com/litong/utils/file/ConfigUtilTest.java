package com.litong.utils.file;

import org.junit.Test;

/**
 * @author litong
 * @date 2018年9月21日_下午6:34:45 
 * @version 1.0 
 */
public class ConfigUtilTest {
	/**
	 * 在spring环境还没有启动的情况下,获取config.properties的值
	 */
	@Test
	public void getValue() {
		String value = ConfigUtil.getValue("robot.addr");
		System.out.println(value);
	}
}
