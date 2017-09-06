package com.team3.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.common.web.action.BaseAction;
import com.team3.biz.DictBiz;
import com.team3.entity.BasDict;
import com.team3.web.form.DictForm;



public class DictAction extends BaseAction {
	private DictBiz dictBiz = null;

	public ActionForward toList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		DictForm myForm = (DictForm)form;
		this.dictBiz.getList(myForm.getItem(), myForm.getPageResult());
		return mapping.findForward("list");
	}

	public ActionForward toAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		DictForm myForm = (DictForm)form;
		myForm.getItem().setDictIsEditable(new Byte("1"));
		return mapping.findForward("toAdd");
	}
	public ActionForward doAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		DictForm myForm = (DictForm)form;
		if(myForm.getItem().getDictIsEditable()==null){
			myForm.getItem().setDictIsEditable(new Byte("1"));
		}
		this.dictBiz.add(myForm.getItem());
		response.sendRedirect("dict.do?o=toList");
		return null;
	}
	public ActionForward toEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		DictForm myForm = (DictForm)form;
		long id=Long.parseLong(request.getParameter("id"));
		BasDict di=dictBiz.get(id);
		if(di.getDictIsEditable()==0){
			myForm.setChecked("on");
		}
		myForm.setItem(di);
		return mapping.findForward("toEdit");
	}
	public ActionForward doEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		DictForm myForm = (DictForm)form;
		BasDict dict=myForm.getItem();
		if(myForm.getChecked()==null){
			myForm.getItem().setDictIsEditable(new Byte("1"));
		}else if(myForm.getChecked()=="on"){
			myForm.getItem().setDictIsEditable(new Byte("0"));
		}
		dictBiz.update(dict);
		response.sendRedirect("dict.do?o=toList");
		return null;
	}
	public ActionForward Del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		DictForm myForm = (DictForm)form;
		long id=Long.parseLong(request.getParameter("id"));
		dictBiz.del(id);
		response.sendRedirect("dict.do?o=toList");
		return null;
	}
	public void setDictBiz(DictBiz dictBiz) {
		this.dictBiz = dictBiz;
	}
}
