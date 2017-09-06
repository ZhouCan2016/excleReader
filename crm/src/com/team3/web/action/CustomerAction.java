package com.team3.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.common.web.action.BaseAction;
import com.team3.biz.CstCustomerBiz;
import com.team3.biz.CstServiceBiz;
import com.team3.biz.DictBiz;
import com.team3.biz.UserBiz;
import com.team3.entity.BasDict;
import com.team3.entity.CstCustomer;
import com.team3.entity.CstService;
import com.team3.entity.SysUser;
import com.team3.web.form.ConsForm;
import com.team3.web.form.CustomerFrom;
import com.team3.web.form.ServiceFrom;

public class CustomerAction extends BaseAction {
	private CstCustomerBiz customerBiz;
	private DictBiz dictBiz;
	private UserBiz userbiz;

	public void setUserbiz(UserBiz userbiz) {
		this.userbiz = userbiz;
	}
	public void setDictBiz(DictBiz dictBiz) {
		this.dictBiz = dictBiz;
	}
	public void setCustomerBiz(CstCustomerBiz customerBiz) {
		this.customerBiz = customerBiz;
	}
	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		CustomerFrom myForm=(CustomerFrom) form;
		this.customerBiz.getList(myForm.getItem(), myForm.getPageResult());
		myForm.setAllRegion(this.dictBiz.getAllDictByType("地区"));
		return mapping.findForward("list");
	}
	public ActionForward toEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		CustomerFrom myForm=(CustomerFrom) form;
		String cusNo=request.getParameter("custNo");
		CstCustomer cust=this.customerBiz.get(cusNo);
		myForm.setItem(cust);
		myForm.setAllManager(this.userbiz.getListByType());
		myForm.setAllRegion(this.dictBiz.getAllDictByType("地区"));
		myForm.setAllLevel(this.dictBiz.getAllDictByType("客户等级"));
		return mapping.findForward("toEdit");
	}
	public ActionForward doEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		CustomerFrom myForm=(CustomerFrom) form;
		CstCustomer cust=myForm.getItem();
		BasDict dict=this.dictBiz.getDictByValue(cust.getCustLevelLabel());
		cust.setCustLevel(Integer.parseInt(dict.getDictValue()));
		cust.setCustStatus("1");
		SysUser user=this.userbiz.get(cust.getCustManagerId());
		cust.setCustManagerName(user.getUsrName());
		this.customerBiz.update(cust);
		response.sendRedirect("customer.do?o=toList");
		return null;
	}
	public ActionForward ddoList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		CustomerFrom myForm=(CustomerFrom) form;
		return mapping.findForward("list");
	}
	public ActionForward doList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		CustomerFrom myForm=(CustomerFrom) form;
		return mapping.findForward("list");
	}
}
