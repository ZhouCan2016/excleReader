<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/jb-common.tld" prefix="jb"%>
<html>
	<head>
		<title>jb-aptech��ҵ�����Ŀ</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="script/common.js"></script>
	</head>
	<body>
		<html:form action="role">
			<div class="page_title">
				��ɫ����
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						��ɫ��
					</th>
					<td>
						${roleForm.item.roleName }
					</td>
					<th>
						��ɫ����
					</th>
					<td>
						${roleForm.item.roleDesc }
					</td>
					<th>
						״̬
					</th>
					<td>
						${roleForm.item.roleFlagString }
					</td>
				</tr>
				<tr>
					<th>
						Ȩ��
					</th>
					<td colspan="5">
						<button class="common_button" onclick="back();">
							����
						</button>
						<html:submit>����</html:submit>
						<html:hidden property="o" value="doAssignRight" />
						<html:hidden property="roleId" value="${roleForm.item.roleId}" />
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<logic:iterate id="right" name="ALL_Rights"
							type="com.team3.entity.SysRight">
							<div>
								<%
											for (int i = 0; i < right.getRightCode().length(); ++i) {
											out.print("&nbsp;&nbsp;&nbsp;");
										}
								%>
								${right.rightText }
								<input name="selectedRights" type="checkbox"
									${right.isSelected } value="${right.rightCode }">
							</div>
						</logic:iterate>
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
