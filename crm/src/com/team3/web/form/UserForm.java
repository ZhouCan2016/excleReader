package com.team3.web.form;

import com.common.web.form.BaseForm;
import com.team3.entity.SysUser;

public class UserForm extends BaseForm {
	private static final long serialVersionUID = -1667466188886997322L;
	private SysUser item = null;
	
	public UserForm(){
		item = new SysUser();
	}
	public SysUser getItem() {
		return item;
	}
	public void setItem(SysUser item) {
		this.item = item;
	}
}
