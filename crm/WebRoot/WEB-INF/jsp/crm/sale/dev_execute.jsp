<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/jb-common.tld" prefix="jb"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>jb-aptech毕业设计项目</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="script/common.js"></script>
	</head>
	<body>
		<div class="page_title">
			客户开发计划 &gt; 执行计划
		</div>
		<div class="button_bar">
			<button class="common_button" onclick="help('');">
				帮助
			</button>
			<button class="common_button"
				onclick="to('plan.do?o=fail&id=${planForm.item.chcId }');">
				终止开发
			</button>
			<button class="common_button" onclick="back();">
				返回
			</button>
			<button class="common_button" onclick="to('dev_plan.html');">
				制定计划
			</button>
			<button class="common_button"
				onclick="to('plan.do?o=success&id=${planForm.item.chcId }');">
				开发成功
			</button>

		</div>
		<table class="query_form_table">
			<tr>
				<th>
					编号
				</th>
				<td>
					${planForm.item.chcId }
				</td>
				<th>
					机会来源
				</th>
				<td>
					${planForm.item.chcSource }
				</td>
			</tr>
			<tr>
				<th>
					客户名称
				</th>
				<td>
					${planForm.item.chcCustName }
				</td>
				<th>
					成功机率（%）
				</th>
				<td>
					&nbsp;${planForm.item.chcRate }
				</td>
			</tr>
			<tr>
				<th>
					概要
				</th>
				<td colspan="3">
					${planForm.item.chcTitle }
				</td>

			</tr>
			<tr>
				<th>
					联系人
				</th>
				<td>
					${planForm.item.chcLinkman }
				</td>
				<th>
					联系人电话
				</th>
				<td>
					${planForm.item.chcTel }
				</td>
			</tr>
			<tr>
				<th>
					机会描述
				</th>
				<td colspan="3">
					${planForm.item.chcDesc }
				</td>
			</tr>
			<tr>
				<th>
					创建人
				</th>
				<td>
					${planForm.item.chcCreateBy }
				</td>
				<th>
					创建时间
				</th>
				<td>
					${planForm.item.chcCreateDateChString }
				</td>
			</tr>
			<tr>
				<th>
					指派给
				</th>
				<td>
					${planForm.item.chcDueTo }
				</td>
				<th>
					指派时间
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
					日期
				</th>
				<th>
					计划
				</th>
				<th>
					执行效果
				</th>
			</tr>
			<logic:iterate id="o" name="plansList"
				type="com.team3.entity.SalPlan">
				<html:form action="plan">
					<tr>
						<td class="list_data_text" height="24">
							${o.plaDateString }
						</td>
						<td class="list_data_ltext">
							${o.plaTodo }
						</td>
						<td class="list_data_ltext" height="24">
							<input name="plaResult" size="50" value="${o.plaResult }" />
							<html:submit styleClass="common_button">保存</html:submit>
							<html:hidden property="o" value="doUpdateResult" />
							<html:hidden property="id" value="${planForm.item.chcId}" />
							<html:hidden property="planId" value="${o.plaId}" />
						</td>
					</tr>
				</html:form>
			</logic:iterate>

		</table>
	</body>
</html>
