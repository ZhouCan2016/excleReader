package com.team3.web.form;

import com.common.web.form.BaseForm;
import com.team3.entity.SysRole;


public class RoleForm extends BaseForm {
	private static final long serialVersionUID = -1667466188886997322L;
	private SysRole item = null;
	
	public RoleForm(){
		item = new SysRole();
	}
	public SysRole getItem() {
		return item;
	}
	public void setItem(SysRole item) {
		this.item = item;
	}
}
