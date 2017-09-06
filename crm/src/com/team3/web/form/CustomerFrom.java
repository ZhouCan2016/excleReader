package com.team3.web.form;

import java.util.List;

import com.common.web.form.BaseForm;
import com.team3.entity.BasDict;
import com.team3.entity.CstCustomer;

public class CustomerFrom extends BaseForm {

	private CstCustomer item = null;

	private List allRegion = null;

	private List allManager = null;

	private List allLevel = null;

	public List getAllLevel() {
		return allLevel;
	}

	public void setAllLevel(List allLevel) {
		this.allLevel = allLevel;
	}

	public List getAllManager() {
		return allManager;
	}

	public void setAllManager(List allManager) {
		this.allManager = allManager;
	}

	public List getAllRegion() {
		return allRegion;
	}

	public void setAllRegion(List allRegion) {
		this.allRegion = allRegion;
	}

	public CustomerFrom() {
		item = new CstCustomer();
	}

	public CstCustomer getItem() {
		return item;
	}

	public void setItem(CstCustomer item) {
		this.item = item;
	}

}
