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
import com.team3.biz.UserBiz;
import com.team3.entity.CstCustomer;
import com.team3.entity.CstService;
import com.team3.entity.SysUser;
import com.team3.web.form.ConsForm;
import com.team3.web.form.ServiceFrom;

public class ScrviceAction extends BaseAction {
	private CstServiceBiz serviceBiz;
	private UserBiz userBiz;
	private CstCustomerBiz customerBiz;
	public void setCustomerBiz(CstCustomerBiz customerBiz) {
		this.customerBiz = customerBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public void setServiceBiz(CstServiceBiz serviceBiz) {
		this.serviceBiz = serviceBiz;
	}
	public ActionForward toAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		List alldue=userBiz.getListByType();
		myForm.getItem().setAllDue(alldue);
		myForm.getItem().setSvrCreateDate(new Date());
		myForm.getItem().setSvrDealDate(new Date());
		myForm.getItem().setSvrDueDate(new Date());
		return mapping.findForward("toadd");
	}
	public ActionForward doAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		CstService ser=myForm.getItem();
		ser.setSvrStatus("新创建");
		if(ser.getSvrType().equals("-1")){
			response.sendRedirect("service.do?o=toAdd");
		}
		CstCustomer cus=this.customerBiz.getCstCustomerByName(ser.getSvrCustName());
		if(cus==null){
			response.sendRedirect("service.do?o=toAdd");
		}
		ser.setCstCustomer(cus);
		ser.setSvrCreateDate(new Date());
		this.serviceBiz.add(ser);
		return mapping.findForward("toDispatch");
	}
	public ActionForward toDispatch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		List alldue=userBiz.getListByType();
		myForm.getItem().setAllDue(alldue);
		myForm.getItem().setSvrStatus("新创建");
		this.serviceBiz.getList(myForm.getItem(), myForm.getPageResult());
		return mapping.findForward("toDispatch");
	}
	public ActionForward doDispatch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		String id=request.getParameter("id");
		CstService ser=this.serviceBiz.get(Long.parseLong(id));
		SysUser user=this.userBiz.get(myForm.getItem().getSvrDueId());
		ser.setSvrDueId(user.getUsrId());
		ser.setSvrDueTo(user.getUsrName());
		ser.setSvrDueDate(new Date());
		ser.setSvrStatus("已分配");
		this.serviceBiz.update(ser);
		response.sendRedirect("service.do?o=toDispatch");
		return null;
	}
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		
		return null;
	}
	public ActionForward toDealList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		List alldue=userBiz.getListByType();
		myForm.getItem().setAllDue(alldue);
		myForm.getItem().setSvrStatus("已分配");
		this.serviceBiz.getList(myForm.getItem(), myForm.getPageResult());
		return mapping.findForward("todealList");
	}
	public ActionForward toDealDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		String id=request.getParameter("id");
		CstService ser=this.serviceBiz.get(Long.parseLong(id));
		myForm.setItem(ser);
		myForm.getItem().setSvrDealDate(new Date());
		return mapping.findForward("dealdetail");
	}
	public ActionForward doDeal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		String id=request.getParameter("id");
		CstService ser=this.serviceBiz.get(Long.parseLong(id));
		ser.setSvrDealId(myForm.getItem().getSvrDealId());
		ser.setSvrDealBy(myForm.getItem().getSvrDealBy());
		ser.setSvrDealDate(new Date());
		ser.setSvrDeal(myForm.getItem().getSvrDeal());
		ser.setSvrStatus("已处理");
		this.serviceBiz.update(ser);
		response.sendRedirect("service.do?o=toDealList");
		return null;
	}
	public ActionForward toFeedbackList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		myForm.getItem().setSvrStatus("已处理");
		this.serviceBiz.getList(myForm.getItem(), myForm.getPageResult());
		return mapping.findForward("toFeedbackList");
	}
	public ActionForward toFeedback(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		String id=request.getParameter("id");
		CstService ser=this.serviceBiz.get(Long.parseLong(id));
		myForm.setItem(ser);
		return mapping.findForward("feedbackdetail");
	}
	public ActionForward doFeedback(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		String id=request.getParameter("id");
		CstService ser=this.serviceBiz.get(Long.parseLong(id));
		ser.setSvrResult(myForm.getItem().getSvrResult());
		ser.setSvrSatisfy(myForm.getItem().getSvrSatisfy());
		int status=myForm.getItem().getSvrSatisfy();
		if(status>=3){
			ser.setSvrStatus("已归档");
		}else{
			ser.setSvrStatus("已处理");
		}
		this.serviceBiz.update(ser);
		response.sendRedirect("service.do?o=toFeedbackList");
		return null;
	}
	public ActionForward toArchList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		myForm.getItem().setSvrStatus("已归档");
		this.serviceBiz.getList(myForm.getItem(), myForm.getPageResult());
		return mapping.findForward("toArchList");
	}
	public ActionForward toDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ServiceFrom myForm=(ServiceFrom) form;
		String id=request.getParameter("id");
		CstService ser=this.serviceBiz.get(Long.parseLong(id));
		myForm.setItem(ser);
		return mapping.findForward("detail");
	}
}
