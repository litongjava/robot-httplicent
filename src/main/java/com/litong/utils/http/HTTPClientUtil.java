package com.litong.utils.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSON;

/**
 * Created by litong on 2018/6/29 0029. 重新封装HTTPClientUtil
 */

public class HTTPClientUtil {

	/**
	 * 执行get和post请求
	 */
	private static CloseableHttpClient client = HttpClients.createDefault();
	/**
	 * 保存url和请求
	 */
	private static Map<String, HttpGet> httpGets = new HashMap<>();
	private static Map<String, HttpPost> httpPosts = new HashMap<>();

	/**
	 * 发送get请求
	 * 
	 * @param url
	 * @return
	 */
	public static String get(String url) throws IOException {
		String retval = null;
		/*
		 * 先从map中获取,没有后new
		 */
		HttpGet httpGet = httpGets.get(url);
		if (httpGet == null) {
			httpGet = new HttpGet(url);
			httpGets.put(url, httpGet);
		}

		HttpGet get = new HttpGet(url);

		retval = excuteGet(get);
		return retval;
	}

	/**
	 * 执行get方法,返回字符串
	 * 
	 * @param get
	 * @return
	 */
	private static String excuteGet(HttpGet get) throws IOException {
		String retval = null;
		HttpResponse response = client.execute(get);
		retval = getString(response);
		return retval;
	}

	/**
	 * 执行post请,返回字符串
	 * 
	 * @param httpPost
	 * @return
	 */
	private static String excutePost(HttpPost httpPost) throws IOException {
		String retval = null;
		HttpResponse response = client.execute(httpPost);
		retval = getString(response);
		return retval;
	}

	/**
	 * 返回响应包中的正文内容
	 * 
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private static String getString(HttpResponse response) throws IOException {
		String retval;
		InputStream stream = response.getEntity().getContent();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
		String line = null;
		StringBuffer strBuf = new StringBuffer();
		while ((line = bufferedReader.readLine()) != null) {
			strBuf.append(line);
		}
		retval = strBuf.toString();
		return retval;
	}

	/**
	 * 发送psot请求,请求格式不是json格式
	 * 
	 * @param url
	 * @param map
	 */
	public static String post(String url, Map<String, String> map) throws IOException {

		// 先从map中获取,没有后new
		HttpPost httpPost = getHttpPost(url, map);
		// 执行post请求
		String retval = excutePost(httpPost);
		return retval;
	}

	/**
	 * 将map转换成HttpEntity
	 * 
	 * @param map
	 * @param httpPost
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static HttpEntity mapToEntity(Map<String, String> map) throws UnsupportedEncodingException {
		List<NameValuePair> pararms = new ArrayList<>();
		// 遍历map,封装成params
		for (Map.Entry<String, String> e : map.entrySet()) {
			pararms.add(new BasicNameValuePair(e.getKey(), e.getValue()));
		}
		// 将params进行url编码
		HttpEntity httpEntity = new UrlEncodedFormEntity(pararms, "UTF-8");
		return httpEntity;
	}

	/**
	 * 返回http post
	 * 
	 * @param url
	 * @return
	 */
	public static HttpPost getHttpPost(String url) {
		HttpPost httpPost = httpPosts.get(url);
		if (httpPost == null) {
			httpPost = new HttpPost(url);
			httpPosts.put(url, httpPost);
		}
		return httpPost;
	}

	/**
	 * 将map转换成entity,httppost中添加entity,返回httppost
	 * 
	 * @param url
	 * @param map
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static HttpPost getHttpPost(String url, Map<String, String> map) throws UnsupportedEncodingException {
		// 获取httpPost
		HttpPost httpPost = getHttpPost(url);
		// 获取http entity
		HttpEntity entity = mapToEntity(map);
		// 添加entiry
		httpPost.setEntity(entity);
		return httpPost;
	}

	/**
	 * 发送post请求,数据格式json格式
	 * 
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static String postJSON(String url, Map<String, String> data, String charset) throws IOException {
		// 转成json格式
		String jsonString = JSON.toJSONString(data);
		String response = postJSON(url, jsonString, charset);
		return response;
	}

	/**
	 * data类型是json格式
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static String postJSON(String url, String data, String charSet) throws IOException {
		HttpPost httpPost = getHttpPost(url);
		// 1.设置httppost头部
		httpPost.setHeader("Content-Type", "application/json");
		// 2.这请求体 entity
		StringEntity entity = new StringEntity(data, charSet);
		httpPost.setEntity(entity);
		// 3.执行请求
		String response = excutePost(httpPost);
		return response;
	}
}