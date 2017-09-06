package com.team3.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.common.web.action.BaseAction;
import com.team3.biz.DictBiz;
import com.team3.biz.ProductBiz;
import com.team3.entity.BasDict;
import com.team3.web.form.DictForm;
import com.team3.web.form.ProductForm;



public class ProductAction extends BaseAction {
	private ProductBiz productBiz = null;

	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ProductForm myForm = (ProductForm)form;
		this.productBiz.getList(myForm.getItem(), myForm.getPageResult());
		return mapping.findForward("productList");
	}

	public void setProductBiz(ProductBiz productBiz) {
		this.productBiz = productBiz;
	}
	
}
