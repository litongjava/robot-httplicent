package com.uairobot.robot.exmple;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.litong.utils.http.HTTPClientUtil;

import cn.eastrobot.www.ws.RobotServiceEx.RobotRequest;
import cn.eastrobot.www.ws.RobotServiceEx.UserAttribute;

/**
 * @author litong
 * @date 2018年9月27日_下午7:17:18
 * @version 1.0
 */
public class AskExample {
	/**
	 * 模拟客户端请求
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 问题
		String question = "A1房型";
		// userid
		String userID = "bjhg-weixin";
		// 维度
		String platform = "weixin";
		// 设置robotRequest中的值
		RobotRequest robotRequest = new RobotRequest();
		robotRequest.setQuestion(question);
		robotRequest.setUserId(userID);
		// 创建维度对象
		UserAttribute pfAttr = new UserAttribute("platform", platform);
		UserAttribute[] attributes = new UserAttribute[] { pfAttr };
		robotRequest.setAttributes(attributes);
		// 转成成json string
		String jsonString = JSON.toJSONString(robotRequest);
		System.out.println(jsonString);
		// 请求地址
		String url = "http://localhost:8080/ask";

		String response = null;
		try {
			response = HTTPClientUtil.postJSON(url, jsonString,"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输入返回字符串
		System.out.println(response);

	}
}
