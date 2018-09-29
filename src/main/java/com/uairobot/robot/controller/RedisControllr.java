package com.uairobot.robot.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.uairobot.robot.bean.CacheAsk;
import com.uairobot.robot.redis.SpringRedisUtil;

/**
 * @author litong
 * @date 2018年9月29日_下午1:46:19
 * @version 1.0
 */
@Controller
@RequestMapping("redis")
public class RedisControllr {

	@Autowired
	private SpringRedisUtil springRedisUtil;

	/**
	 * 返回set类型的数据
	 */
	@RequestMapping("getSetValue")
	@ResponseBody
	public Set<CacheAsk> getSetValue(String key) {
		Set<CacheAsk> setBean = null;
		try {
			setBean = springRedisUtil.getSetBean(key, CacheAsk.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return setBean;
	}

	/**
	 * 删除 set类型的数据
	 */
	@RequestMapping("removeSetValue")
	public String removeSetValue(String key) {
		springRedisUtil.delete(key);
		return "excuted";
	}
}
