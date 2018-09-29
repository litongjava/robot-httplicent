package com.uairobot.util.ibot9;

import java.rmi.RemoteException;

import cn.eastrobot.www.ws.RobotServiceEx.RobotResponse;

public class Example {
	public static void main(String[] args) throws RemoteException {
		RobotResponse answer = IbotWSClient.getAnswer("���");
		System.out.println(answer.getContent());
	}
}
