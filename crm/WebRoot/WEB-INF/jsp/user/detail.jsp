<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<title>����û�</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body class="main">
	<html:form action="user">
		<html:hidden property="o" value="doAdd" />
    �û�����:<html:text property="item.usrName"></html:text>
		<br>
    �û�����:<html:text property="item.usrPassword"></html:text>
		<br>
	�û�״̬:	<html:text property="item.usrFlagString"></html:text>
		
		
	</html:form>
</body>
</html:html>
