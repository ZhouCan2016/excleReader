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
import com.team3.biz.CstLostBiz;
import com.team3.web.form.LostForm;

public class LostRptAction extends BaseAction {
	private CstLostBiz lostBiz;

	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		LostForm myForm=(LostForm) form;
		this.lostBiz.getList(myForm.getItem(), myForm.getPageResult());
		return mapping.findForward("list");
	}

	public void setLostBiz(CstLostBiz lostBiz) {
		this.lostBiz = lostBiz;
	}
}
