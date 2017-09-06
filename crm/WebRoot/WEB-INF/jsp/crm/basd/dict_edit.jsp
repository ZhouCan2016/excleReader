<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<html:form action="dict">
<div class="page_title">数据字典管理 > 编辑数据字典条目</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<html:submit styleClass="common_button">保存</html:submit>
	<html:hidden property="o" value="doEdit" />
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><html:text property="item.dictId" readonly="true"/></td>
		<th>类别</th>
		<td><html:text property="item.dictType"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>条目</th>
		<td><html:text property="item.dictItem"/><span class="red_star">*</span></td>
		<th>值</th>
		<td><html:text property="item.dictValue" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>是否可编辑</th>
		<td>1111<html:checkbox property="checked"  /></td>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
</table>
</html:form>
</body>
</html>