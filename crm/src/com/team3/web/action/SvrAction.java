package com.team3.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.common.web.action.BaseAction;
import com.team3.biz.CstServiceBiz;
import com.team3.web.form.SvrForm;

public class SvrAction extends BaseAction {
	private CstServiceBiz serviceBiz;
	public void setServiceBiz(CstServiceBiz serviceBiz) {
		this.serviceBiz = serviceBiz;
	}
	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		SvrForm myForm=(SvrForm) form;
		List list=this.serviceBiz.getListByYear(myForm.getYear());
		request.setAttribute("allList", list);
		return mapping.findForward("list");
	}
}
