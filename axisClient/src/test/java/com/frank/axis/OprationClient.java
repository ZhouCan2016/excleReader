package com.frank.axis;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class OprationClient {

	/**
	 * @param args
	 * @throws AxisFault
	 */
	 
	public static void main(String[] args) throws AxisFault {
		// 使用RPC方式调用WebService
				RPCServiceClient serviceClient = new RPCServiceClient();
				Options options = serviceClient.getOptions();
				// 指定调用WebService的URL
				EndpointReference targetEPR = new EndpointReference(
						"http://localhost:8099/orderWebService/api/v2/services/OrderInfoWebService");
				options.setTo(targetEPR);
				// 指定要调用的计算机器中的方法及WSDL文件的命名空间：impl.service.axis.hualom.com 服务类的包名称。
				QName orderInfoResult = new QName("http://webService.api.orderWebService.ctsi.com.cn", "orderInfo");
				// 设置发送到服务器的内容
				Object[] opAddEntryArgs = new Object[] { "<interfacemsg>\r\n" + 
						"<interfacemsg>\r\n" + 
						"<query>\r\n" + 
						"<user>sysadmin</user>\r\n" + 
						"<token>o7NWEI80Q4PWvP2FPmJFLA==</token>\r\n" + 
						"</query>\r\n" + 
						"</interfacemsg>" };
				// 指定返回值的类型
				Class[] classes = new Class[] { String.class };
				// 调用服务器开放的接口并且返回结果 如果没有返回值可以直接调用 serviceClient.invokeRobust(opName, opAddEntryArgs)
//				System.out.println(serviceClient.invokeBlocking(orderInfoResult, opAddEntryArgs, classes)[0]);
				
				Object[] result=serviceClient.invokeBlocking(orderInfoResult, opAddEntryArgs, classes); 
		        for (Object object : result) { 
		            System.out.println(object.toString()); 
		        }  
	}
}
