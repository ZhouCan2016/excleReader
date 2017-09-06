package com.team3.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.common.web.action.BaseAction;
import com.team3.biz.SalChanceBiz;
import com.team3.biz.UserBiz;
import com.team3.entity.SalChance;
import com.team3.entity.SysUser;
import com.team3.web.form.SalChanceForm;

public class SalChanceBizAction extends BaseAction {
	private SalChanceBiz salChanceBiz = null;
	private UserBiz userBiz=null;
	public void setSalChanceBiz(SalChanceBiz salChanceBiz) {
		this.salChanceBiz = salChanceBiz;
	}

	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SalChanceForm salForm=(SalChanceForm) form;
		this.salChanceBiz.getList(salForm.getItem(),salForm.getPageResult());
		salForm.setItem(new SalChance());
		return mapping.findForward("list");

	}
	public ActionForward toAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SalChanceForm salForm=(SalChanceForm) form;
		salForm.setItem(new SalChance());
		salForm.getItem().setChcCreateDate(new Date());
		salForm.getItem().setAllDue(userBiz.getListByType());
		return mapping.findForward("toAdd");

	}
	public ActionForward doAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SalChanceForm salForm=(SalChanceForm) form;		
		salForm.getItem().setChcStatus("1");
		SysUser user=(SysUser)request.getSession().getAttribute("Login");
		long createid=((SysUser)request.getSession().getAttribute("Login")).getUsrId();
		salForm.getItem().setChcCreateId(createid);
		salChanceBiz.add(salForm.getItem());
		salForm.setItem(new SalChance());
		response.sendRedirect("chance.do?o=toList");
		return null;

	}
	public ActionForward toDue(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SalChanceForm salForm=(SalChanceForm) form;
		long id=Long.parseLong(request.getParameter("id"));
		SalChance salchance=this.salChanceBiz.get(id);
		salForm.setItem(salchance);
		salForm.getItem().setAllDue(userBiz.getListByType());
		salForm.getItem().setChcDueDate(new Date());
		return mapping.findForward("toDispatch");

	}
	public ActionForward doDue(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SalChanceForm salForm=(SalChanceForm) form;
		long creatid=salForm.getItem().getChcDueId();
		salForm.getItem().setChcCreateBy(this.userBiz.get(creatid).getUsrName());
		salForm.getItem().setChcStatus("2");
		salChanceBiz.update(salForm.getItem());
		response.sendRedirect("chance.do?o=toList");
		return null;

	}
	public ActionForward toEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SalChanceForm salForm=(SalChanceForm) form;
		long id=Long.parseLong(request.getParameter("id"));
		SalChance salchance=this.salChanceBiz.get(id);
		salForm.setItem(salchance);
		salForm.getItem().setAllDue(userBiz.getListByType());
		return mapping.findForward("toEdit");

	}
	public ActionForward doEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SalChanceForm salForm=(SalChanceForm) form;
		SalChance salChance=salForm.getItem();
		salChanceBiz.update(salChance);
		salForm.setItem(new SalChance());
		response.sendRedirect("chance.do?o=toList");
		return null;

	}
	public ActionForward Del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SalChanceForm salForm=(SalChanceForm) form;
		long id=Long.parseLong(request.getParameter("id"));
		this.salChanceBiz.del(id);
		salForm.setItem(new SalChance());
		response.sendRedirect("chance.do?o=toList");
		return null;

	}
	public ActionForward doDel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;

	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
}
