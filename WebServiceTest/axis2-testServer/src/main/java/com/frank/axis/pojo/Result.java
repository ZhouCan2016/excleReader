package com.frank.axis.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("result")
public class Result {

	private String platformName;
	private String messageNumber;
	private String errorMsg;
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getMessageNumber() {
		return messageNumber;
	}
	public void setMessageNumber(String messageNumber) {
		this.messageNumber = messageNumber;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
