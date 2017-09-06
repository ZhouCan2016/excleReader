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
		<html:form action="plan">
			<div class="page_title">
				�ͻ������ƻ� &gt; �鿴
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					����
				</button>
				<button class="common_button" onclick="back();">
					����
				</button>
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						���
					</th>
					<td>
						${planForm.item.chcId }
					</td>
					<th>
						������Դ
					</th>
					<td>
						${planForm.item.chcSource }
					</td>
				</tr>
				<tr>
					<th>
						�ͻ�����
					</th>
					<td>
						${planForm.item.chcCustName }
					</td>
					<th>
						�ɹ����ʣ�%��
					</th>
					<td>
						&nbsp;${planForm.item.chcRate }
					</td>
				</tr>
				<tr>
					<th>
						��Ҫ
					</th>
					<td>
						${planForm.item.chcTitle }
					</td>
					<th>
						״̬
					</th>
					<td style="color:red;">
						����ʧ��
					</td>
				</tr>
				<tr>
					<th>
						��ϵ��
					</th>
					<td>
						${planForm.item.chcLinkman }
					</td>
					<th>
						��ϵ�˵绰
					</th>
					<td>
						${planForm.item.chcTel }
					</td>
				</tr>
				<tr>
					<th>
						��������
					</th>
					<td colspan="3">
						${planForm.item.chcDesc }
					</td>
				</tr>
				<tr>
					<th>
						������
					</th>
					<td>
						${planForm.item.chcCreateBy }
					</td>
					<th>
						����ʱ��
					</th>
					<td>
						${planForm.item.chcCreateDateChString }
					</td>
				</tr>
				<tr>
					<th>
						ָ�ɸ�
					</th>
					<td>
						${planForm.item.chcDueTo }
					</td>
					<th>
						ָ��ʱ��
					</th>
					<td>
						${planForm.item.chcDueDateString }
					</td>
				</tr>
			</table>
			<br />
			<table class="data_list_table" id="table1">
				<tr>
					<th>
						����
					</th>
					<th>
						�ƻ�
					</th>
					<th>
						ִ��Ч��
					</th>
				</tr>
				<logic:iterate id="o" name="plansList" type="com.team3.entity.SalPlan">
					<tr>
					<td class="list_data_text">
						${o.plaDateString }
					</td>
					<td class="list_data_ltext">
						${o.plaTodo }
					</td>
					<td class="list_data_ltext">
						${o.plaResult }
					</td>
				</tr>
				</logic:iterate>
				
			</table>
		</html:form>
	</body>
</html>
