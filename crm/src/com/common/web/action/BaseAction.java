package com.common.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

public class BaseAction extends DispatchAction {
	protected ActionMessages errors = new ActionMessages();
	protected void clearErrors(){
		errors.clear();
	}
	protected void SaveErrors(HttpServletRequest request){
		if (!errors.isEmpty()){
			super.saveErrors(request, errors);
		}
	}
	
	protected void AddError(String resKey){
		this.errors.add("iConghai.ERROR_KEY",new ActionMessage(resKey));		
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		clearErrors();
		String errorCode = request.getParameter("error_code");
		if (null!=errorCode){
			AddError(errorCode);
		}
		ActionForward af = super.execute(mapping, form, request, response);
		SaveErrors(request);
		return af;
	}
}
