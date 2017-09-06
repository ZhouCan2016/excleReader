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
				<html:hidden property="o" value="doDeal" />
				<html:hidden property="id" value="${serviceForm.item.svrId }"/>
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
						<html:textarea property="item.svrDeal" rows="6" cols="50"></html:textarea>
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						������
					</th>
					<td>
						<html:hidden property="item.svrDealId" value="sessionScope.Login.usrId"/>
						<html:text property="item.svrDealBy" value="${sessionScope.Login.usrName}" readonly="true"
							size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						����ʱ��
					</th>
					<td>
						<html:text readonly="true" size="20"
							property="item.svrDealDateString" />
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
			<br />
			<table disabled class="query_form_table" id="table2">
				<tr>
					<th>
						������
					</th>
					<td>
						<input name="T10" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						�����
					</th>
					<td>
						<select name="D1">
							<option>
								��ѡ��...
							</option>
							<option>
								������
							</option>
							<option>
								�����
							</option>
							<option>
								����
							</option>
							<option>
								���
							</option>
							<option>
								��
							</option>
						</select>
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
