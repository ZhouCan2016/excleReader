package cn.com.csti.test;

import java.rmi.RemoteException;

import cn.com.ctsi.orderwebservice.api.webservice.OrderInfo;
import cn.com.ctsi.orderwebservice.api.webservice.OrderInfoResponse;
import cn.com.ctsi.orderwebservice.api.webservice.OrderInfoWebService;
import cn.com.ctsi.orderwebservice.api.webservice.OrderInfoWebServiceStub;

public class orderTest {

	public static void main(String[] args) throws RemoteException {
		
		OrderInfoWebService service = new OrderInfoWebServiceStub();

		OrderInfo info = new OrderInfo();

		info.setXml("<interfacemsg>\r\n" + "<query>\r\n" + "<user>qianshuang</user>\r\n"
				+ "<token>7QqJ9zIMyV7o2hd30qetuA==</token>\r\n" + "</query>\r\n" + "</interfacemsg>");

		OrderInfoResponse orderInfo = service.orderInfo(info);

		System.out.println(orderInfo.get_return());
	}
}
