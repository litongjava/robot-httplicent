package com.uairobot.robot.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.eastrobot.www.ws.RobotServiceEx.RobotRequest;
import cn.eastrobot.www.ws.RobotServiceEx.RobotResponse;

/**
 * @author litong
 * @date 2018年9月21日_上午9:06:43
 * @version 1.0 请求robot的服务类
 */
public interface AskService {
	/**
	 * 根据答案获取内容
	 * 
	 * @param Question
	 * @return
	 */
	public RobotResponse getAnswer(RobotRequest robotRequest);
}
