<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title>�ͻ���ϵ����ϵͳ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body style="border-bottom:solid 1px #666;">

<TABLE style="width:100%;">
<TR >
	<td ><img src="../images/logo.gif"></td>
	<td style="font-family:����;font-size:33px;font-weight:bold;"> �ͻ���ϵ����ϵͳ</td>	
	<td width="25%" align="right" style="font-size:12px;" valign="bottom">��ǰ�û���<bean:write name="Login" property="usrName" scope="session"/>&nbsp;&nbsp;[<a href="../login.do?o=logout" target="_parent" >�Ƴ�ϵͳ</a>]
</tr>
</table>
</body>
</html>

