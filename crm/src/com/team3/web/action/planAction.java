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
import com.team3.biz.planBiz;
import com.team3.entity.SalChance;
import com.team3.entity.SalPlan;
import com.team3.entity.SysUser;
import com.team3.web.form.SalChanceForm;
import com.team3.web.form.planForm;

public class planAction extends BaseAction {
	private planBiz planBiz = null;
	
	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		planForm salForm=(planForm) form;
		this.planBiz.getList(salForm.getItem(),salForm.getPageResult());
		salForm.setItem(new SalChance());
		return mapping.findForward("list");

	}

	public ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		planForm myForm=(planForm) form;
		String id=request.getParameter("id");
		SalChance sc=this.planBiz.get(Long.parseLong(id));
		myForm.setItem(sc);
		List list=this.planBiz.getListBySalChance(Long.parseLong(id));
		request.setAttribute("plansList", list);
		return mapping.findForward("detail");

	}
	public ActionForward toAddPlan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		planForm myForm=(planForm) form;
		String id=request.getParameter("id");
		SalChance sc=this.planBiz.get(Long.parseLong(id));
		myForm.setItem(sc);
		List list=this.planBiz.getListBySalChance(Long.parseLong(id));
		request.setAttribute("plansList", list);
		return mapping.findForward("addPlan");

	}
	public ActionForward toExecPlan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		planForm myForm=(planForm) form;
		String id=request.getParameter("id");
		SalChance sc=this.planBiz.get(Long.parseLong(id));
		myForm.setItem(sc);
		List list=this.planBiz.getListBySalChance(Long.parseLong(id));
		request.setAttribute("plansList", list);
		return mapping.findForward("execPlan");

	}
	public ActionForward doAddPlan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		planForm myForm=(planForm) form;
		SalPlan plan=myForm.getItemPlan();
		String id=request.getParameter("id");
		SalChance sc=this.planBiz.get(Long.parseLong(id));
		plan.setSalChance(sc);
		plan.setPlaDate(new Date());
		this.planBiz.add(plan);
		response.sendRedirect("plan.do?o=toAddPlan&id="+id);
		return null;

	}
	public ActionForward Del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String planId=request.getParameter("planId");
		String id=request.getParameter("id");
		this.planBiz.del(Long.parseLong(planId));
		response.sendRedirect("plan.do?o=toAddPlan&id="+id);
		return null;

	}
	public ActionForward doUpdateResult(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		planForm myForm=(planForm) form;
		String planId=request.getParameter("planId");
		String id=request.getParameter("id");
		String plaResult=request.getParameter("plaResult");
		SalPlan item=this.planBiz.getPlan(Long.parseLong(planId));
		item.setPlaResult(plaResult);
		this.planBiz.updatePlan(item);
		response.sendRedirect("plan.do?o=toExecPlan&id="+id);
		return null;
	}
	public ActionForward doUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		planForm myForm=(planForm) form;
		String planId=request.getParameter("planId");
		String id=request.getParameter("id");
		String plaTodo=request.getParameter("plaTodo");
		SalPlan item=this.planBiz.getPlan(Long.parseLong(planId));
		item.setPlaTodo(plaTodo);
		this.planBiz.updatePlan(item);
		response.sendRedirect("plan.do?o=toAddPlan&id="+id);
		return null;

	}
	public ActionForward success(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id=request.getParameter("id");
		SalChance sc=this.planBiz.get(Long.parseLong(id));
		sc.setChcStatus("3");
		this.planBiz.update(sc);
		response.sendRedirect("plan.do?o=toList");
		return null;

	}
	public ActionForward fail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id=request.getParameter("id");
		SalChance sc=this.planBiz.get(Long.parseLong(id));
		sc.setChcStatus("4");
		this.planBiz.update(sc);
		response.sendRedirect("plan.do?o=toList");
		return null;

	}
	public void setPlanBiz(planBiz planBiz) {
		this.planBiz = planBiz;
	}
}
