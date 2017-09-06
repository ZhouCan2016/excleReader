package com.team3.web.form;

import com.common.web.form.BaseForm;
import com.team3.entity.BasDict;

public class DictForm extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BasDict item = null;
	private String checked;

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public DictForm() {
		item = new BasDict();
	}

	public BasDict getItem() {
		return item;
	}

	public void setItem(BasDict item) {
		this.item = item;
	}

}
