package com.team3.web.form;

import com.common.web.form.BaseForm;
import com.team3.entity.BasDict;
import com.team3.entity.Product;

public class ProductForm extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Product item = null;

	public ProductForm() {
		item = new Product();
	}

	public Product getItem() {
		return item;
	}

	public void setItem(Product item) {
		this.item = item;
	}

}
