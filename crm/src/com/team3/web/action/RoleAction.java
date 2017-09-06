package com.team3.web.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.common.web.action.BaseAction;
import com.team3.biz.RoleBiz;
import com.team3.entity.SysRight;
import com.team3.entity.SysRole;
import com.team3.web.form.RoleForm;


public class RoleAction extends BaseAction {
	private RoleBiz roleBiz = null;

	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		RoleForm myForm = (RoleForm)form;
		this.roleBiz.getList(myForm.getItem(), myForm.getPageResult());
		return mapping.findForward("list");
	}
	public ActionForward toAssignRight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		RoleForm myForm = (RoleForm)form;
		String id=request.getParameter("id");
		SysRole role=this.roleBiz.getRoleWithRights(Long.parseLong(id));
		List allRights=this.roleBiz.getRights();		
		Iterator it=allRights.iterator();
		while(it.hasNext()){
			SysRight right=(SysRight) it.next();
			Set set= role.getSysRights();
			Iterator setIt=set.iterator();
			while(setIt.hasNext()){
				SysRight roleRight=(SysRight) setIt.next();
				if(roleRight.equals(right)){
					right.setIsSelected("checked=\"on\" ");
				}
			}
		}
		myForm.setItem(role);
		request.setAttribute("ALL_Rights", allRights);
		return mapping.findForward("allRights");
		
	}
	public ActionForward doAssignRight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		RoleForm myForm = (RoleForm)form;
		String roleId=request.getParameter("roleId");
		String[] rights=request.getParameterValues("selectedRights");
		this.roleBiz.assignRights(Long.parseLong(roleId), rights);
		response.sendRedirect("role.do?o=toAssignRights&id="+roleId);
		return null;
		
	}
	public void setRoleBiz(RoleBiz roleBiz) {
		this.roleBiz = roleBiz;
	}

}
