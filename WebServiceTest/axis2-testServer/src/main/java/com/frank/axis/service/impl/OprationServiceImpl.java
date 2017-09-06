package com.frank.axis.service.impl;

import org.springframework.stereotype.Service;

import com.frank.axis.pojo.Interfacemsg;
import com.frank.axis.pojo.Result;
import com.frank.axis.service.OprationService;
import com.frank.axis.utils.xmlUtil;
@Service("oprationService")
public class OprationServiceImpl implements OprationService{

	public String search(String message) {
		Interfacemsg bean = xmlUtil.toBean(message, Interfacemsg.class);
		return "search" +"------"+ bean.getQuery().getUser()+"-----" +bean.getQuery().getToken();
	}

	public String noSearch(String message) {
		Interfacemsg bean = new Interfacemsg();
		Result result = new Result();
		result.setPlatformName("云管平台");
		result.setMessageNumber("18");
		bean.setResult(result);
		return "noSearch" + "-----" + xmlUtil.toXml(bean);
	}

}
