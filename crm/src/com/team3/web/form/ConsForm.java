package com.team3.web.form;

import com.common.web.form.BaseForm;

public class ConsForm extends BaseForm {
	private String type=null;
	private String consName=null;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConsName() {
		return consName;
	}

	public void setConsName(String consName) {
		this.consName = consName;
	}
}