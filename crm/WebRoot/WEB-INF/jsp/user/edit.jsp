<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<title>添加用户</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body class="main">
	<html:form action="user"  >
		<html:hidden property="o" value="doEdit" />
    用户姓名:<html:text property="item.usrName" ></html:text>
		<br>
    用户密码:<html:text property="item.usrPassword"></html:text>
		<br>
	用户状态:		<html:select property="item.usrFlag">
						<html:option value="-1">全部</html:option>
						<html:option value="1">正常</html:option>
						<html:option value="0">已删除</html:option>
					</html:select>	 
		<html:submit>修改</html:submit>
		
	</html:form>
</body>
</html:html>
