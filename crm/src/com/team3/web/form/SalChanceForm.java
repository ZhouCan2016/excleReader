package com.team3.web.form;

import com.common.web.form.BaseForm;
import com.team3.entity.SalChance;

public class SalChanceForm extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SalChance item = null;

	public SalChanceForm() {
		item = new SalChance();
	}

	public SalChance getItem() {
		return item;
	}

	public void setItem(SalChance item) {
		this.item = item;
	}
}
