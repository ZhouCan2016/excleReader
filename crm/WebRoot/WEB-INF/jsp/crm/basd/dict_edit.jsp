<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech��ҵ�����Ŀ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<html:form action="dict">
<div class="page_title">�����ֵ���� > �༭�����ֵ���Ŀ</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">����</button>
	<button class="common_button" onclick="back();">����</button>
	<html:submit styleClass="common_button">����</html:submit>
	<html:hidden property="o" value="doEdit" />
</div>
<table class="query_form_table">
	<tr>
		<th>���</th>
		<td><html:text property="item.dictId" readonly="true"/></td>
		<th>���</th>
		<td><html:text property="item.dictType"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>��Ŀ</th>
		<td><html:text property="item.dictItem"/><span class="red_star">*</span></td>
		<th>ֵ</th>
		<td><html:text property="item.dictValue" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>�Ƿ�ɱ༭</th>
		<td>1111<html:checkbox property="checked"  /></td>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
</table>
</html:form>
</body>
</html>