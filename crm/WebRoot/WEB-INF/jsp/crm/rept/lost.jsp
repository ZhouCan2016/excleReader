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
		<html:form action="lostRpt">
			<div class="page_title">
				客户流失分析
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<html:submit styleClass="common_button">查询</html:submit>
				<html:hidden property="o" value="toList" />
			</div>
			<table class="query_form_table" border="0" cellPadding="3"
				cellSpacing="0">
				<tr>
					<th>
						客户名称
					</th>
					<td>
						<html:text property="item.lstCustName"></html:text>
					</td>
					<th>
						客户经理
					</th>

					<td>
						<html:text property="item.lstCustManagerName"></html:text>
					</td>

				</tr>
			</table>
			<br />
			<table class="data_list_table">
				<tr>
					<th height="28">
						编号
					</th>
					<th height="28">
						年份
					</th>
					<th height="28">
						客户
					</th>
					<th height="28">
						客户经理
					</th>
					<th height="28">
						流失原因
					</th>
				</tr>
				<logic:iterate id="item" name="lostForm" property="pageResult.list"
					type="com.team3.entity.CstLost" indexId="i">

					<tr>
						<td class="list_data_number" height="27">
							${(lostForm.pageResult.pageNo-1)*(lostForm.pageResult.pageSize)+(i+1) }
						</td>
						<td class="list_data_text" height="27">
							${item.lostYear }
						</td>
						<td class="list_data_text" height="27">
							${item.lstCustName }
						</td>
						<td class="list_data_text" height="27">
							${item.lstCustManagerName }
						</td>
						<td class="list_data_ltext" height="27">
							${item.lstReason }
						</td>
					</tr>
				</logic:iterate>
				<logic:empty name="lostForm" property="pageResult.list">
				<tr>
					<td class="list_data_text" colspan="20"
						style="text-align:center;height:40px;">
						没有记录
					</td>
				</tr>
			</logic:empty>
				<tr>
					<th colspan="7" class="pager">
						<jb:pager form="lostForm" />
					</th>
				</tr>
			</table>
		</html:form>
	</body>
</html>
