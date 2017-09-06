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
	<html:form action="plan">
		<div class="page_title">
			�ͻ������ƻ�
		</div>
		<div class="button_bar">
			<button class="common_button" onclick="help('');">
				����
			</button>
			<html:submit styleClass="common_button">��ѯ</html:submit>
		</div>

		<html:hidden property="o" value="toList" />
		<table class="query_form_table">
			<tr>
				<th>
					�ͻ�����
				</th>
				<td>
					<html:text property="item.chcCustName" />
				</td>
				<th>
					��Ҫ
				</th>
				<td>
					<html:text property="item.chcTitle"></html:text>
				</td>
				<th>
					��ϵ��
				</th>
				<td>
					<html:text property="item.chcLinkman"></html:text>
				</td>
			</tr>
		</table>

		<br />
		<table class="data_list_table">
			<tr>
				<th>
					���
				</th>
				<th>
					�ͻ�����
				</th>
				<th>
					��Ҫ
				</th>
				<th>
					��ϵ��
				</th>
				<th>
					��ϵ�˵绰
				</th>
				<th>
					����ʱ��
				</th>
				<th>
					״̬
				</th>
				<th>
					����
				</th>
			</tr>
			<logic:iterate id="item" name="planForm"
				property="pageResult.list" type="com.team3.entity.SalChance"
				indexId="i">
				<tr>
					<td class="list_data_number">
						${(planForm.pageResult.pageNo-1)*(planForm.pageResult.pageSize)+(i+1)
						}
					</td>
					<td class="list_data_text">
						${item.chcCustName }
					</td>
					<td class="list_data_ltext">
						${item.chcTitle }
					</td>
					<td class="list_data_text">
						${item.chcLinkman }
					</td>
					<td class="list_data_text">
						${item.chcTel }
					</td>
					<td class="list_data_text">
						${item.chcCreateDateChString }
					</td>
					<td class="list_data_text">
						${item.chcStatusString }
					</td>
					<td class="list_data_op">
					<logic:equal name="item" property="chcStatus" value="2">
						<img onclick="to('plan.do?o=toAddPlan&id=${item.chcId }');" title="�ƶ��ƻ�"
							src="images/bt_plan.gif" class="op_button" />
						<img onclick="to('plan.do?o=toExecPlan&id=${item.chcId }');" title="ִ�мƻ�"
							src="images/bt_feedback.gif" class="op_button" />
						<img onclick="to('plan.do?o=success&id=${item.chcId }');" title="�����ɹ�"
							src="images/bt_yes.gif" class="op_button" />
					</logic:equal>
					<logic:equal name="item" property="chcStatus" value="4">
						<img onclick="to('plan.do?o=detail&id=${item.chcId }');" title="�鿴"
							src="images/bt_detail.gif" class="op_button" />
					</logic:equal>
					</td>
				</tr>
			</logic:iterate>
			<logic:empty name="planForm" property="pageResult.list">
				<tr>
					<td class="list_data_text" colspan="20"
						style="text-align:center;height:40px;">
						û�м�¼
					</td>
				</tr>
			</logic:empty>
		</table>
		<jb:pager form="planForm" />
	</html:form>
</body>
</html:html>
