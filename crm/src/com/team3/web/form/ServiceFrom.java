package com.team3.web.form;

import com.common.web.form.BaseForm;
import com.team3.entity.CstService;

public class ServiceFrom extends BaseForm {

	private CstService item=null;
	
	public ServiceFrom(){
		item=new CstService();
	}

	public CstService getItem() {
		return item;
	}

	public void setItem(CstService item) {
		this.item = item;
	}
}
