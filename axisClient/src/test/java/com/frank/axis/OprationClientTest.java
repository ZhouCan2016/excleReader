package com.frank.axis;

import java.rmi.RemoteException;

import cn.com.ctsi.orderwebservice.api.webservice.OrderInfo;
import cn.com.ctsi.orderwebservice.api.webservice.OrderInfoResponse;
import cn.com.ctsi.orderwebservice.api.webservice.OrderInfoWebService;
import cn.com.ctsi.orderwebservice.api.webservice.OrderInfoWebServiceStub;

public class OprationClientTest {

	public static void main(String[] args) throws RemoteException {

		OrderInfoWebService service = new OrderInfoWebServiceStub();

		OrderInfo info = new OrderInfo();

		info.setXml("<interfacemsg>\r\n" + "<query>\r\n" + "<user>sysadmin</user>\r\n"
				+ "<token>o7NWEI80Q4PWvP2FPmJFLA==</token>\r\n" + "</query>\r\n" + "</interfacemsg>");

		OrderInfoResponse orderInfo = service.orderInfo(info);

		System.out.println(orderInfo.get_return());
	}
}
