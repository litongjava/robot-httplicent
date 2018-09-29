package com.uairobot.robot.bean;

import cn.eastrobot.www.ws.RobotServiceEx.RobotRequest;
import cn.eastrobot.www.ws.RobotServiceEx.RobotResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author litong
 * @date 2018年9月27日_下午3:45:28
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheAsk {
	private RobotRequest robotRequest;
	private RobotResponse robotResponse;
}
