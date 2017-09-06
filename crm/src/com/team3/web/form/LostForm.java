package com.team3.web.form;

import com.common.web.form.BaseForm;
import com.team3.entity.CstLost;

public class LostForm extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CstLost item = null;

	public LostForm() {
		item = new CstLost();
	}

	public CstLost getItem() {
		return item;
	}

	public void setItem(CstLost item) {
		this.item = item;
	}
}
