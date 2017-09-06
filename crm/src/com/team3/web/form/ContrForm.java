package com.team3.web.form;

import com.common.web.form.BaseForm;
import com.team3.entity.CstCustomer;

public class ContrForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private String name=null;
	private String year=null;

	public ContrForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
