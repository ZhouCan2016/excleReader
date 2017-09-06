<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/jb-common.tld" prefix="jb"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<title>jb-aptech��ҵ�����Ŀ</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script src="script/common.js"></script>
</head>
<body>
	<html:form action="chance">
		<div class="page_title">
			���ۻ������&nbsp; &gt; �½����ۻ���
		</div>
		<div class="button_bar">
			<button class="common_button" onclick="help('');">
				����
			</button>
			<button class="common_button" onclick="back();">
				����
			</button>
			<html:submit styleClass="common_button">����</html:submit>
			<html:hidden property="o" value="doAdd" />

		</div>
		<table class="query_form_table">
			<tr>
				<th>
					���
				</th>
				<td>
					<html:text property="item.chcId" readonly="true" />
				</td>
				<th>
					������Դ
				</th>
				<td>
					<html:text property="item.chcSource" />
				</td>
			</tr>
			<tr>
				<th>
					�ͻ�����
				</th>
				<td>
					<html:text property="item.chcCustName" />
					<span class="red_star">*</span>
				</td>
				<th>
					�ɹ�����
				</th>
				<td>
					<html:text property="item.chcRate" />
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					��Ҫ
				</th>
				<td colspan="3">
					<html:text property="item.chcTitle" size="52"></html:text>
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					��ϵ��
				</th>
				<td>
					<html:text size="20" property="item.chcLinkman" />
				</td>
				<th>
					��ϵ�˵绰
				</th>
				<td>
					<html:text size="20" property="item.chcTel" />
				</td>
			</tr>
			<tr>
				<th>
					��������
				</th>
				<td colspan="3">
					<html:textarea rows="6" cols="50" property="item.chcDesc"></html:textarea>
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					������
				</th>
				<td>
					<html:text readonly="true" value="${sessionScope.Login.usrName}"
						size="20" property="item.chcCreateBy"></html:text>
					<span class="red_star">*</span>
				</td>
				<th>
					����ʱ��
				</th>
				<td>
					<html:text readonly="true" size="20"
						property="item.chcCreateDateString"></html:text>
					<span class="red_star">*</span>
				</td>
			</tr>
		</table>
		<br />
		<table disabled class="query_form_table" id="table1">
			<tr>
				<th>
					ָ�ɸ�
				</th>
				<td>
					<html:select property="item.chcDueId">
							<option>
								��ѡ��...
							</option>
							<logic:iterate id="o" name="salchanceForm" property="item.allDue">
								<html:option value="${o.usrId}">
								${o.usrName }
							</html:option>
							</logic:iterate>
						</html:select>
					<span class="red_star">*</span>
				</td>
				<th>
					ָ��ʱ��
				</th>
				<td>
					<input id="t2" name="T20" readonly size="20" />
					<span class="red_star">*</span>
				</td>
			</tr>
		</table>
		<script>
	setCurTime('t2');
</script>
	</html:form>
</body>
</html:html>
