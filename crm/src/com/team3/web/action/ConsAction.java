package com.team3.web.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.common.web.action.BaseAction;
import com.team3.biz.CstCustomerBiz;
import com.team3.entity.CstCustomer;
import com.team3.web.form.ConsForm;
import com.team3.web.form.ContrForm;

public class ConsAction extends BaseAction {
	private CstCustomerBiz customerBiz;

	public void setCustomerBiz(CstCustomerBiz customerBiz) {
		this.customerBiz = customerBiz;
	}
	
	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ConsForm myForm=(ConsForm) form;
		List list=this.customerBiz.getListByType(myForm.getType());
		if(myForm.getType()==null){
			myForm.setConsName("等级");
		}else if(myForm.getType().equals("dj")){
			myForm.setConsName("等级");
		}else if(myForm.getType().equals("xy")){
			myForm.setConsName("信用度");
		}else if(myForm.getType().equals("my")){
			myForm.setConsName("满意度");
		}
		request.setAttribute("allList", list);
		return mapping.findForward("list");
	}
}
