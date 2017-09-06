<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/jb-common.tld" prefix="jb"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<title>jb-aptech毕业设计项目</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script src="script/common.js"></script>
</head>
<body>
	<html:form action="chance">
		<div class="page_title">
			销售机会管理&nbsp; &gt; 新建销售机会
		</div>
		<div class="button_bar">
			<button class="common_button" onclick="help('');">
				帮助
			</button>
			<button class="common_button" onclick="back();">
				返回
			</button>
			<html:submit styleClass="common_button">保存</html:submit>
			<html:hidden property="o" value="doAdd" />

		</div>
		<table class="query_form_table">
			<tr>
				<th>
					编号
				</th>
				<td>
					<html:text property="item.chcId" readonly="true" />
				</td>
				<th>
					机会来源
				</th>
				<td>
					<html:text property="item.chcSource" />
				</td>
			</tr>
			<tr>
				<th>
					客户名称
				</th>
				<td>
					<html:text property="item.chcCustName" />
					<span class="red_star">*</span>
				</td>
				<th>
					成功机率
				</th>
				<td>
					<html:text property="item.chcRate" />
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					概要
				</th>
				<td colspan="3">
					<html:text property="item.chcTitle" size="52"></html:text>
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					联系人
				</th>
				<td>
					<html:text size="20" property="item.chcLinkman" />
				</td>
				<th>
					联系人电话
				</th>
				<td>
					<html:text size="20" property="item.chcTel" />
				</td>
			</tr>
			<tr>
				<th>
					机会描述
				</th>
				<td colspan="3">
					<html:textarea rows="6" cols="50" property="item.chcDesc"></html:textarea>
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					创建人
				</th>
				<td>
					<html:text readonly="true" value="${sessionScope.Login.usrName}"
						size="20" property="item.chcCreateBy"></html:text>
					<span class="red_star">*</span>
				</td>
				<th>
					创建时间
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
					指派给
				</th>
				<td>
					<html:select property="item.chcDueId">
							<option>
								请选择...
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
					指派时间
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
