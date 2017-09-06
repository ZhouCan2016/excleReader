<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/jb-common.tld" prefix="jb"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>jb-aptech��ҵ�����Ŀ</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="script/common.js"></script>
	</head>
	<body>
		<html:form action="service">
			<div class="page_title">
				�ͻ�������� &gt; ������
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					����
				</button>
				<button class="common_button" onclick="back();">
					����
				</button>
				<html:submit styleClass="common_button">����</html:submit>
				<html:hidden property="o" value="doFeedback" />
				<html:hidden property="id" value="${serviceForm.item.svrId }" />
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						���
					</th>
					<td>
						${serviceForm.item.svrId }
					</td>
					<th>
						��������
					</th>
					<td>
						${serviceForm.item.svrType }
					</td>
				</tr>
				<tr>
					<th>
						��Ҫ
					</th>
					<td colspan="3">
						${serviceForm.item.svrTitle }
					</td>
				</tr>
				<tr>
					<th>
						�ͻ�
					</th>
					<td>
						${serviceForm.item.svrCustName }
					</td>
					<th>
						״̬
					</th>
					<td>
						${serviceForm.item.svrStatus }
					</td>
				</tr>
				<tr>
					<th>
						��������
					</th>
					<td colspan="3">
						${serviceForm.item.svrRequest }
						<br>
					</td>
				</tr>
				<tr>
					<th>
						������
					</th>
					<td>
						${serviceForm.item.svrCreateBy }
					</td>
					<th>
						����ʱ��
					</th>
					<td>
						${serviceForm.item.svrCreateDateString }
					</td>
				</tr>
			</table>
			<br />
			<table class="query_form_table" id="table3">
				<tr>
					<th>
						�����
					</th>
					<td>
						${serviceForm.item.svrDueTo }
					</td>
					<th>
						����ʱ��
					</th>
					<td>
						${serviceForm.item.svrDueDateString }
					</td>
				</tr>
			</table>
			<br />
			<table class="query_form_table" id="table1">
				<tr>
					<th>
						������
					</th>
					<td colspan="3">
						${serviceForm.item.svrDeal }
					</td>
				</tr>
				<tr>
					<th>
						������
					</th>
					<td>
						${serviceForm.item.svrDealBy }
					</td>
					<th>
						����ʱ��
					</th>
					<td>
						${serviceForm.item.svrDealDateString }
					</td>
				</tr>
			</table>
			<br />
			<table class="query_form_table" id="table2">
				<tr>
					<th>
						������
					</th>
					<td>
						<html:text size="20" property="item.svrResult" />
						<span class="red_star">*</span>
					</td>
					<th>
						�����
					</th>
					<td>
						<html:select property="item.svrSatisfy">
							<html:option value="-1">��ѡ��...</html:option>
							<html:option value="5">������</html:option>
							<html:option value="4">�����</html:option>
							<html:option value="3">����</html:option>
							<html:option value="2">���</html:option>
							<html:option value="1">��</html:option>
						</html:select>
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
