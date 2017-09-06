package com.team3.web.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.common.web.action.BaseAction;
import com.team3.biz.UserBiz;
import com.team3.entity.SysRole;
import com.team3.entity.SysUser;
import com.team3.web.form.LoginForm;


public class LoginAction extends BaseAction {
	private UserBiz userBiz = null;
	public void setUserBiz(UserBiz userBiz){
		this.userBiz = userBiz; 
	}
	public ActionForward forward(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		LoginForm myForm = (LoginForm)form;
		HttpSession session= request.getSession();
		if(session.getAttribute("Login")==null){
			return mapping.findForward("login");
		}
		return mapping.findForward("index");
	}
	public ActionForward doLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		LoginForm myForm = (LoginForm)form;
		HttpSession session= request.getSession();
		SysUser user=userBiz.loginValidate(myForm.getItem().getUsrName(),myForm.getItem().getUsrPassword());
		if(user!=null){
			session.setAttribute("Login",user);
			Set set=user.getSysRole().getSysRights();
			session.setAttribute("set", set);
			response.sendRedirect("login.do?o=forward");
		}else{
			ActionErrors errors=new ActionErrors();
			errors.add("error2",new ActionError("error.validate.unUser"));		
				super.saveErrors(request, errors);
				return mapping.findForward("login");			
		}		
		return null;		
	}
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		LoginForm myForm = (LoginForm)form;
		request.getSession().removeAttribute("Login");
		myForm.setItem(new SysUser());
		return mapping.findForward("l");
		
	}
	public ActionForward toDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		long id=Long.parseLong(request.getParameter("id"));
		LoginForm myForm = (LoginForm)form;
		SysUser user=userBiz.get(id);
		return mapping.findForward("detail");
	}
}
