package cn.eastrobot.www.ws.RobotServiceEx;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * @author litong
 * @date 2018年9月27日_下午4:46:38
 * @version 1.0
 */
public class RobotRequestTest {

	@Test
	public void test() {
		RobotRequest robotRequest = new RobotRequest();
		robotRequest.setQuestion("你好");
		robotRequest.setUserId("litong");
		UserAttribute pf = new UserAttribute("platform", "weixin");
		UserAttribute[] attributes = new UserAttribute[] { pf };
		robotRequest.setAttributes(attributes);
		String jsonString = JSON.toJSONString(robotRequest);
		System.out.println(jsonString);
	}
}
