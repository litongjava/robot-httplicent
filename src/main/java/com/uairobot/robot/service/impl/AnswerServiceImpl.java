package com.uairobot.robot.service.impl;

import java.rmi.RemoteException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.litong.utils.file.ConfigUtil;
import com.uairobot.robot.bean.CacheAsk;
import com.uairobot.robot.redis.SpringRedisUtil;
import com.uairobot.robot.service.AskService;
import com.uairobot.util.ibot9.IbotWSClient;

import cn.eastrobot.www.ws.RobotServiceEx.RobotCommand;
import cn.eastrobot.www.ws.RobotServiceEx.RobotRequest;
import cn.eastrobot.www.ws.RobotServiceEx.RobotResponse;
import cn.eastrobot.www.ws.RobotServiceEx.UserAttribute;

/**
 * @author litong
 * @date 2018年9月21日_上午9:07:23
 * @version 1.0 启动robot服务类的实现
 */
@Service
public class AnswerServiceImpl implements AskService {
	// redis中key
	private String key = ConfigUtil.getValue("redis.key1");
	// 操作redis
	@Autowired
	private SpringRedisUtil springRedisUtil;

	/**
	 * 获取答案
	 */
	@Override
	public RobotResponse getAnswer(RobotRequest robotRequest) {
		String retval = null;
		// ====查询redis start====
		String robotRequestPlatform = null;
		UserAttribute[] userAttrs = robotRequest.getAttributes();
		for (UserAttribute ut : userAttrs) {
			if (ut.getName().equals("platform")) {
				robotRequestPlatform = ut.getValue();
			}
		}
		Set<CacheAsk> set = null;
		try {
			set = springRedisUtil.getSetBean(key, CacheAsk.class);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		for (CacheAsk c : set) {
			RobotRequest r = c.getRobotRequest();
			String userid = r.getUserId();
			String question = r.getQuestion();
			String platform = null;
			UserAttribute[] attributes = r.getAttributes();
			for (UserAttribute a : attributes) {
				String name = a.getName();
				if (name.equals("platform")) {
					platform = a.getName();
				}
			}

			if (robotRequest.getUserId().equals(userid) && robotRequest.getQuestion().equals(question)
					&& platform.equals(robotRequestPlatform)) {
				// 取出缓存,返回
				return c.getRobotResponse();
			}
		}
		// ====查询redis end====

		RobotResponse robotResponse = null;
		try {
			// 发送的小I知识库,请求答案
			robotResponse = IbotWSClient.deliver(robotRequest);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		// ====如果是查询天气信息不进行缓存 start====
		// 索引从0开始
		System.out.println(JSON.toJSONString(robotResponse));
		RobotCommand[] commands = robotResponse.getCommands();

		if (commands.length > 0 && commands[0].getName().equals("weacher")) {
			return robotResponse;
		}
		// ====如果是查询天气信息不进行缓存 end====
		// 写入redis
		CacheAsk cacheAsk = new CacheAsk(robotRequest, robotResponse);
		try {
			springRedisUtil.saveSetBean(key, cacheAsk);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return robotResponse;
	}
}
