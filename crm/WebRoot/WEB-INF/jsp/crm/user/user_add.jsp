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
		<html:form action="user">
			<div class="page_title">
				用户管理 > 新建用户
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button" onclick="back();">
					返回
				</button>
				<html:submit styleClass="common_button">保存</html:submit>
				<html:hidden property="o" value="doAdd" />
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						用户名
					</th>
					<td>
						<html:text property="item.usrName" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						密码
					</th>
					<td>
						<html:text property="item.usrPassword" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						角色
					</th>
					<td>
						<select name="roleId">
							<option value="-1">
								--请选择--
							</option>
							<logic:iterate id="o" name="userForm" property="item.allRole"
								type="com.team3.entity.SysRole">
								<option value="${o.roleId }">
									${o.roleName }
								</option>
							</logic:iterate>
						</select>
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
