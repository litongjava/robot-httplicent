package com.uairobot.util.ibot9;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.eastrobot.www.ws.RobotServiceEx.RobotRequest;
import cn.eastrobot.www.ws.RobotServiceEx.RobotResponse;
import cn.eastrobot.www.ws.RobotServiceEx.RobotServiceEx_PortType;
import cn.eastrobot.www.ws.RobotServiceEx.RobotServiceEx_Service;
import cn.eastrobot.www.ws.RobotServiceEx.RobotServiceEx_ServiceLocator;
import cn.eastrobot.www.ws.RobotServiceEx.UserAttribute;

/**
 * @author litong 小I机器人统一知识管理平台,web service客户端 去知识库查询问题,返回答案
 * 
 * @param question
 * @return
 */
public class IbotWSClient {
	private static Logger log = LoggerFactory.getLogger(IbotWSClient.class);
	private static RobotServiceEx_PortType client = null;
	static {
		RobotServiceEx_Service service = new RobotServiceEx_ServiceLocator();
		try {
			client = service.getDefaultRobotServiceExPort();
		} catch (ServiceException e) {
			log.error("初始化连接数据库失败");
			e.printStackTrace();
		}
	}

	/**
	 * 根据问题,用户ID,sessionID,和平台查询知识库
	 * 
	 * @param question
	 * @param userID
	 * @param sessionID
	 * @param platform
	 * @return
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public static RobotResponse getAnswer(String question, String userID, String sessionID, String platform)
			throws RemoteException {
		RobotRequest robotRequest = new RobotRequest();
		robotRequest.setQuestion(question);

		if (userID != null)
			robotRequest.setUserId(userID);

		if (sessionID != null)
			robotRequest.setSessionId(sessionID);

		if (platform != null) {
			UserAttribute pf = new UserAttribute("platform", platform);
			UserAttribute[] attributes = new UserAttribute[] { pf };
			robotRequest.setAttributes(attributes);
		}
		RobotResponse response = client.deliver(robotRequest);
		return response;
	}

	public static RobotResponse getAnswer(String question) throws RemoteException {
		RobotRequest robotRequest = new RobotRequest();
		robotRequest.setQuestion(question);
		RobotResponse response = client.deliver(robotRequest);
		return response;
	}

	/**
	 * @param question
	 * @param string
	 * @throws RemoteException
	 */
	public static RobotResponse getAnswer(String question, String userID) throws RemoteException {
		RobotResponse answer = getAnswer(question, userID, null);
		return answer;

	}

	/**
	 * 
	 * @param question
	 * @param userID
	 * @param sessionID
	 * @param attributes
	 * @return
	 * @throws RemoteException
	 */
	public static RobotResponse getAnswer(String question, String userID, String sessionID, UserAttribute[] attributes)
			throws RemoteException {
		RobotRequest robotRequest = new RobotRequest();
		robotRequest.setQuestion(question);

		if (userID != null)
			robotRequest.setUserId(userID);

		if (sessionID != null)
			robotRequest.setSessionId(sessionID);

		if (attributes != null) {
			robotRequest.setAttributes(attributes);
		}
		RobotResponse response=IbotWSClient.deliver(robotRequest);
		return response;
	}

	/**
	 * @param question
	 * @param userID
	 * @param platform
	 * @return
	 * @throws RemoteException
	 */
	public static RobotResponse getAnswer(String question, String userID, String platform) throws RemoteException {
		RobotResponse response = getAnswer(question, userID, null, platform);
		return response;
	}

	/**
	 * 
	 * @param robotRquest
	 * @return
	 * @throws RemoteException
	 */
	public static RobotResponse deliver(RobotRequest robotRequest) throws RemoteException {
		RobotResponse response = client.deliver(robotRequest);
		return response;
	}

	/**
	 * 指定roobt地址获取答案
	 * 
	 * @param robotAddr
	 * @param question
	 * @return
	 * @throws ServiceException
	 * @throws RemoteException
	 */
//	public static RobotResponse getAnswerWithRobotAddr(String robotAddr, String question)
//			throws ServiceException, RemoteException {
//		return getAnswerWithRobotAddr(robotAddr, question, null);
//
//	}

	/**
	 * 指定roobt地址获取答案,增加维度
	 * 
	 * @throws ServiceException
	 * @throws RemoteException
	 */
//	public static RobotResponse getAnswerWithRobotAddr(String robotAddr, String question, String platform)
//			throws ServiceException, RemoteException {
//		// 问题1.每一个问题都会new一个新的RobotServiceEx_ServiceLocator,开销比较大,但是地址随可能会变
//		RobotServiceEx_ServiceLocator locator = new RobotServiceEx_ServiceLocator(robotAddr);
//		RobotServiceEx_PortType client = locator.getDefaultRobotServiceExPort();
//		RobotRequest robotRequest = new RobotRequest();
//		robotRequest.setQuestion(question);
//		if (!(platform == null && "".equals(platform))) {
//			UserAttribute platfrom = new UserAttribute("platform", platform);
//			UserAttribute[] attributes = { platfrom };
//			robotRequest.setAttributes(attributes);
//		}
//		RobotResponse deliver = client.deliver(robotRequest);
//		return deliver;
//	}
}
