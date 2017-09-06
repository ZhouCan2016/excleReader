<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/jb-common.tld" prefix="jb" %>
<script src="validate.js" ></script>
<script src="icommon.js" ></script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <title>�û�����</title>
	<link rel="stylesheet" type="text/css" href="styles.css" >
  </head>
  
  <body class="main">
  <html:form action="user">
  	<html:hidden property="o" value="toList" />
  	<span style="font-weight:bold;">��ѯ����</span>
		<table class="input_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<td class="input_title">�û���</td>
				<td class="input_content">
					<html:text property="item.usrName" />
				</td>
				<td class="input_title">״̬</td>
				<td class="input_content">
					<html:select property="item.usrFlag">
						<html:option value="-1">ȫ��</html:option>
						<html:option value="1">����</html:option>
						<html:option value="0">��ɾ��</html:option>
					</html:select>				
				</td>
				<td class="input_content" colspan="2" style="text-align:right;">
					<button onclick="javascript:doSubmit('toList');">��    ѯ</button>
				</td>
			</tr>
		</table>
		<!-- �б����� -->
		<span style="font-weight:bold;">�����б�</span>
		<table class="data_table" border="0" cellPadding="3" cellSpacing="0">
		<tr>
			<td class="data_title" style="width:40px;" onclick="order_by('usrId');">���</td>
			<td class="data_title" style="width:50%;" onclick="order_by('usrName');">�û���</td>
			<td class="data_title" style="width:20%;" onclick="order_by('usrFlag');">״̬</td>
			<td class="data_title">����</td>
		</tr>
		<logic:iterate id="item" name="userForm" property="pageResult.list"
			type="org.jb.y272.team0.entity.SysUser"> 
			<tr>
				<td class="data_cell" style="text-align:right;padding:0 10px;">${item.usrId }</td>
				<td class="data_cell" style="text-align:center;">${item.usrName }</td>
				<td class="data_cell">${item.usrFlagString }&nbsp;</td>
				<td class="data_cell">
					<button class="op_button" onclick="window.location.href='?o=toDetail&id=${item.usrId }'" style="width:40px;">�鿴</button>
					<button class="op_button" onclick="window.location.href='?o=toEdit&id=${item.usrId }'" style="width:40px;">�༭</button>
					<button class="op_button" onclick="doDel('id=${item.usrId }','doDel')" style="width:40px;">ɾ��</button>
				</td>
			</tr>
		</logic:iterate>
		<logic:empty name="userForm" property="pageResult.list">
			<tr><td class="data_cell" colspan="20" style="text-align:center;height:40px;">û�м�¼</td></tr>
		</logic:empty>
		</table>
		<jb:pager form="userForm" />
	</html:form>	
  </body>
</html:html>
