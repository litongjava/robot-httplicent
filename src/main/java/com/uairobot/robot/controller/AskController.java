package com.uairobot.robot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.litong.utils.file.ConfigUtil;
import com.uairobot.robot.service.AskService;

import cn.eastrobot.www.ws.RobotServiceEx.RobotRequest;
import cn.eastrobot.www.ws.RobotServiceEx.RobotResponse;

/**
 * @author litong
 * @date 2018年9月20日_下午9:20:24
 * @version 1.0
 */
@Controller
public class AskController {

	private static final Logger log = LoggerFactory.getLogger(AskController.class);

	@Autowired
	private AskService askService;

	@RequestMapping({ "", "/" })
	@ResponseBody
	public String hello() {
		String retval = ConfigUtil.getValue("project.id");
		log.info("retval:" + retval);
		return retval;
	}

	/**
	 * 回答用户提问
	 * @param robotRequest
	 * @return
	 */
	@RequestMapping("ask")
	@ResponseBody
	public RobotResponse get(@RequestBody RobotRequest robotRequest) {
		System.out.println(JSON.toJSONString(robotRequest));
		RobotResponse rebotResponse = askService.getAnswer(robotRequest);
		return rebotResponse;
	}
}
