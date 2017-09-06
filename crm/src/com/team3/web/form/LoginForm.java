package com.team3.web.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.common.web.form.BaseForm;
import com.team3.entity.SysUser;

public class LoginForm extends BaseForm {
//	@Override
//	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
//		System.out.println("validate方法运行");
//		ActionErrors errors=new ActionErrors();
//		if(this.item.getUsrName()==null){
//			errors.add("uname",new ActionError("error.validate.uname"));
//		}
//		if(this.item.getUsrPassword()==null){
//			errors.add("upass",new ActionError("error.validate.upass"));
//		}
//		return errors;
//	}
	private static final long serialVersionUID = -1667466188886997322L;
	private SysUser item = null;
	
	public LoginForm(){
		item = new SysUser();
	}
	public SysUser getItem() {
		return item;
	}
	public void setItem(SysUser item) {
		this.item = item;
	}
}
