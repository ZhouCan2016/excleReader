package com.team3.web.action;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.common.web.action.BaseAction;
import com.team3.biz.RoleBiz;
import com.team3.biz.UserBiz;
import com.team3.entity.SysRole;
import com.team3.entity.SysUser;
import com.team3.web.form.UserForm;

public class UserAction extends BaseAction {
	private UserBiz userBiz = null;

	private RoleBiz roleBiz = null;

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm myForm = (UserForm) form;
		this.userBiz.getList(myForm.getItem(), myForm.getPageResult());
		return mapping.findForward("list");
	}

	public ActionForward toAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm myForm = (UserForm) form;
		myForm.getItem().setAllRole(this.userBiz.getAllRole());
		return mapping.findForward("toAdd");

	}

	public ActionForward doAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm usrForm = (UserForm) form;
		SysUser item = usrForm.getItem();

		String roleId = request.getParameter("roleId");
		if (!roleId.equals("-1")) {
			SysRole role = roleBiz.get(Long.parseLong(roleId));
			item.setSysRole(role);
			item.setUsrFlag(1);
			userBiz.add(item);
			usrForm.setItem(new SysUser());
			response.sendRedirect("user.do?o=toList");
		} else {
			response.sendRedirect("user.do?o=toAdd");
		}
		return null;

	}

	public ActionForward toEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm myForm = (UserForm) form;
		String id = request.getParameter("id");
		SysUser item = this.userBiz.get(Long.parseLong(id));
		myForm.setItem(item);
		myForm.getItem().setAllRole(this.userBiz.getAllRole());
		return mapping.findForward("toEdit");

	}

	public ActionForward doEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm myForm = (UserForm) form;
		SysUser item = this.userBiz.get(myForm.getItem().getUsrId());
		item.setUsrName(myForm.getItem().getUsrName());
		item.setUsrPassword(myForm.getItem().getUsrPassword());
		String roleId = request.getParameter("roleId");
		if (!roleId.equals("-1")) {
			SysRole role = roleBiz.get(Long.parseLong(roleId));
			item.setSysRole(role);
		}
		this.userBiz.update(item);
		response.sendRedirect("user.do?o=toList");
		return null;

	}

	public ActionForward Del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
		UserForm usrForm = (UserForm) form;
		this.userBiz.del(id);
		response.sendRedirect("user.do?o=toList");
		return null;
	}

	public void setRoleBiz(RoleBiz roleBiz) {
		this.roleBiz = roleBiz;
	}
}
