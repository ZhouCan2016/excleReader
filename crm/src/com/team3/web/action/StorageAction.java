package com.team3.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.common.web.action.BaseAction;
import com.team3.biz.StorageBiz;
import com.team3.web.form.StorageForm;



public class StorageAction extends BaseAction {
	private StorageBiz storageBiz = null;

	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		StorageForm myForm = (StorageForm)form;
		this.storageBiz.getList(myForm.getItem(), myForm.getPageResult());
		return mapping.findForward("list");
	}

	public void setStorageBiz(StorageBiz storageBiz) {
		this.storageBiz = storageBiz;
	}

}
