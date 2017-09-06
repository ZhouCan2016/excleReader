<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>jb-aptech毕业设计项目</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="script/common.js"></script>
	</head>
	<body>
		<html:form action="chance">
			<div class="page_title">
				销售机会管理&nbsp; &gt; 指派销售机会
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button" onclick="back();">
					返回
				</button>
				<html:submit styleClass="common_button">保存</html:submit>
				<html:hidden property="o" value="doDue" />
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						编号
					</th>
					<td>
						${salchanceForm.item.chcId }
					</td>
					<th>
						机会来源
					</th>
					<td>
						${salchanceForm.item.chcSource }
					</td>
				</tr>
				<tr>
					<th>
						客户名称
					</th>
					<td>
						${salchanceForm.item.chcCustName }
					</td>
					<th>
						成功机率（%）
					</th>
					<td>
						&nbsp;${salchanceForm.item.chcRate }
					</td>
				</tr>
				<tr>
					<th>
						概要
					</th>
					<td colspan="3">
						${salchanceForm.item.chcTitle }
					</td>
				</tr>
				<tr>
					<th>
						联系人
					</th>
					<td>
						${salchanceForm.item.chcLinkman }
					</td>
					<th>
						联系人电话
					</th>
					<td>
						${salchanceForm.item.chcTel }
					</td>
				</tr>
				<tr>
					<th>
						机会描述
					</th>
					<td colspan="3">
						${salchanceForm.item.chcDesc }
					</td>
				</tr>
				<tr>
					<th>
						创建人
					</th>
					<td>
						${salchanceForm.item.chcCreateBy }
					</td>
					<th>
						创建时间
					</th>
					<td>
						${salchanceForm.item.chcCreateDateString }
					</td>
				</tr>
			</table>
			<br />
			<table class="query_form_table" id="table1">
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
						<bean:write name="salchanceForm" property="item.chcDueDate" format="yyyy年MM月dd日 HH时mm分ss秒"/>
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
		</html:form>
		<script>
	setCurTime('t2');
</script>
	</body>
</html>
