package com.common.taglib;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.common.util.PageResult;
import com.common.web.form.BaseForm;

public class PaginationTag extends TagSupport {
	private static final long serialVersionUID = -5904339614208817088L;
	private String form = null;
	
	public int doEndTag() {
		try {
			BaseForm oForm = null;
			if (form!=null && !"".equals(form.trim())){
				oForm = (BaseForm) pageContext.getRequest().getAttribute(form);
				if (null==oForm){
					oForm = (BaseForm) pageContext.getSession().getAttribute(form);
				}
				if (oForm!=null){
					PageResult pageResult = oForm.getPageResult();
					StringBuffer sb = new StringBuffer();
					sb.append("<div style=\"text-align:right;padding:6px 6px 0 0;\">\r\n")	
					.append("��"+pageResult.getRecTotal()+"����¼&nbsp;\r\n")	
					.append("ÿҳ��ʾ<input name=\"pageResult.pageSize\" value=\""+pageResult.getPageSize()+"\" size=\"3\" />��&nbsp;\r\n")
					.append("��<input name=\"pageResult.pageNo\" value=\""+pageResult.getPageNo()+"\" size=\"3\" />ҳ")
					.append(" / ��"+pageResult.getPageTotal()+"ҳ \r\n")
					.append("<a href=\"javascript:page_first();\">��һҳ</a> \r\n")
					.append("<a href=\"javascript:page_pre();\">��һҳ</a>\r\n")
					.append("<a href=\"javascript:page_next();\">��һҳ</a> \r\n")
					.append("<a href=\"javascript:page_last();\">���һҳ</a>\r\n")
					.append("<input type=\"button\" onclick=\"javascript:page_go();\" value=\"ת��\" />\r\n")
					.append("<input type=\"hidden\" name=\"pageResult.orderBy\"  value=\""+pageResult.getOrderBy()+"\" />\r\n")
					.append("<input type=\"hidden\" name=\"pageResult.sort\"  value=\""+pageResult.getSort()+"\" />\r\n")
					.append("<script>\r\n")
					.append("	var pageTotal = "+pageResult.getPageTotal()+";\r\n")
					.append("	var recTotal = "+pageResult.getRecTotal()+";\r\n")
					.append("</script>\r\n")
					.append("</div>\r\n");
					sb.append("<script>\r\n");
					sb.append("function page_go()\r\n")
					.append("{\r\n")
					.append("	page_validate();		\r\n")
					.append("	document.forms[0].submit();\r\n")
					.append("}\r\n")
					.append("function page_first()\r\n")
					.append("{\r\n")
					.append("	document.forms[0].elements[\"pageResult.pageNo\"].value = 1;\r\n")
					.append("	document.forms[0].submit();\r\n")
					.append("}\r\n")
					.append("function page_pre()\r\n")
					.append("{\r\n")
					.append("	var pageNo = document.forms[0].elements[\"pageResult.pageNo\"].value;\r\n")
					.append("	document.forms[0].elements[\"pageResult.pageNo\"].value = parseInt(pageNo) - 1;\r\n")
					.append("	page_validate();\r\n")
					.append("	document.forms[0].submit();\r\n")
					.append("}\r\n")
					.append("function page_next()\r\n")
					.append("{\r\n")
					.append("	var pageNo = document.forms[0].elements[\"pageResult.pageNo\"].value;\r\n")
					.append("	document.forms[0].elements[\"pageResult.pageNo\"].value = parseInt(pageNo) + 1;\r\n")
					.append("	page_validate();\r\n")
					.append("	document.forms[0].submit();\r\n")
					.append("}\r\n")
					.append("function page_last()\r\n")
					.append("{\r\n")
					.append("	document.forms[0].elements[\"pageResult.pageNo\"].value = pageTotal;\r\n")
					.append("	document.forms[0].submit();\r\n")
					.append("}\r\n")
					.append("function page_validate()\r\n")
					.append("{\r\n")
					.append("	var pageNo = document.forms[0].elements[\"pageResult.pageNo\"].value;\r\n")
					.append("	if (pageNo<1)pageNo=1;\r\n")
					.append("	if (pageNo>pageTotal)pageNo=pageTotal;\r\n")
					.append("	document.forms[0].elements[\"pageResult.pageNo\"].value = pageNo;\r\n")						
					.append("	var pageSize = document.forms[0].elements[\"pageResult.pageSize\"].value;\r\n")
					.append("	if (pageSize<1)pageSize=1;\r\n")
					.append("	document.forms[0].elements[\"pageResult.pageSize\"].value = pageSize;\r\n")
					.append("}\r\n")
					.append("function order_by(field){\r\n")
					.append("	document.forms[0].elements[\"pageResult.orderBy\"].value = field;\r\n")
					.append("	page_first();\r\n")
					.append("}\r\n");
					sb.append("</script>\r\n");
					JspWriter out = pageContext.getOut();
					out.println(sb.toString());
				}
			}
		} catch (Exception e) {
		}
		return EVAL_PAGE;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
}
