package com.uairobot.robot.redis;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author litong
 * @date 2018年9月20日_下午3:42:18
 * @version 1.0
 */
@Component
public class SpringRedisUtil {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	public static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * 保存字符串
	 * 
	 * @param key
	 * @param value
	 */
	public void saveString(String key, String value) {

		stringRedisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 获取字符串
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		String retval = stringRedisTemplate.opsForValue().get(key);
		return retval;
	}

	/**
	 * 保存对象
	 * 
	 * @param key
	 * @param object
	 * @throws JsonProcessingException
	 */
	public void saveBean(String key, Object object) throws JsonProcessingException {
		saveString(key, mapper.writeValueAsString(object));
	}

	/**
	 * 获取对象
	 * 
	 * @param key
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public <T> T getBean(String key, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		String string = getString(key);
		T t = mapper.readValue(string, clazz);
		return t;
	}

	// =====操作 set start====
	public void saveSet(String key, String value) {
		stringRedisTemplate.opsForSet().add(key, value);
	}

	public void saveSetBean(String key, Object value) throws JsonProcessingException {
		stringRedisTemplate.opsForSet().add(key, mapper.writeValueAsString(value));
	}

	public Set<String> getSet(String key) {
		Set<String> members = stringRedisTemplate.opsForSet().members(key);
		return members;
	}

	public <T> Set<T> getSetBean(String key, Class<T> clazz) throws JsonProcessingException {
		Set<T> retval = new HashSet<T>();
		Set<String> set = getSet(key);
		for (String string : set) {
			T readValue = null;
			try {
				readValue = mapper.readValue(string, clazz);
				retval.add(readValue);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retval;
	}

	// =====操作 set end====
	/**
	 * 删除key
	 * 
	 * @param key
	 */
	public void delete(String key) {
		stringRedisTemplate.delete(key);
	}

	/**
	 * 批量删除key
	 * 
	 * @param keys
	 */
	public void delete(Collection<String> keys) {
		stringRedisTemplate.delete(keys);
	}

}