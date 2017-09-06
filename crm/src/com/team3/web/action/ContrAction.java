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
import com.team3.biz.ContrRptBiz;
import com.team3.biz.OrdersBiz;
import com.team3.entity.CstCustomer;
import com.team3.web.form.ContrForm;

public class ContrAction extends BaseAction {
	private ContrRptBiz contrBiz;
	private OrdersBiz orderBiz;
	public void setContrBiz(ContrRptBiz contrBiz) {
		this.contrBiz = contrBiz;
	}
	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ContrForm myForm=(ContrForm) form;
		List list=this.contrBiz.getList(myForm.getName());
		List ret=new ArrayList();
		Iterator it=list.iterator();
		while(it.hasNext()){
			CstCustomer cus=(CstCustomer) it.next();
			cus.setAllPrice(this.orderBiz.getPrice(cus.getCustName(), myForm.getYear()));
			ret.add(cus);
		}
		request.setAttribute("allList", ret);
		return mapping.findForward("list");
	}
	public void setOrderBiz(OrdersBiz orderBiz) {
		this.orderBiz = orderBiz;
	}
}
