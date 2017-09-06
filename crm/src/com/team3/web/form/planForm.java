package com.team3.web.form;

import com.common.web.form.BaseForm;
import com.team3.entity.SalChance;
import com.team3.entity.SalPlan;

public class planForm extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SalChance item = null;
	private SalPlan itemPlan=null;

	public SalChance getItem() {
		return item;
	}

	public void setItem(SalChance item) {
		this.item = item;
	}

	public SalPlan getItemPlan() {
		return itemPlan;
	}

	public void setItemPlan(SalPlan itemPlan) {
		this.itemPlan = itemPlan;
	}

	public planForm() {
		item = new SalChance();
		itemPlan=new SalPlan();
	}
}
