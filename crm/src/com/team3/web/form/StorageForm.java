package com.team3.web.form;

import com.common.web.form.BaseForm;
import com.team3.entity.Product;
import com.team3.entity.Storage;


public class StorageForm extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Storage item = null;

	public StorageForm() {
		item = new Storage();
		item.setProduct(new Product());
	}

	public Storage getItem() {
		return item;
	}

	public void setItem(Storage item) {
		this.item = item;
	}

}
