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
		<html:form action="contrRpt">
			<div class="page_title">
				客户贡献分析
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<html:submit styleClass="common_button">查询</html:submit>
				<html:hidden property="o" value="toList" />
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						客户名称
					</th>
					<td>
						<html:text property="name"></html:text>
					</td>
					<th>
						年份
					</th>
					<td>
						<html:select property="year">
							<html:option value="-1">全部</html:option>
							<html:option value="2002">2002</html:option>
							<html:option value="2003">2003</html:option>
							<html:option value="2004">2004</html:option>
							<html:option value="2005">2005</html:option>
							<html:option value="2006">2006</html:option>
							<html:option value="2007">2007</html:option>
							<html:option value="2008">2008</html:option>
							<html:option value="2009">2009</html:option>
						</html:select>
					</td>
				</tr>
			</table>
			<br />
			<table class="data_list_table">
				<tr>
					<th>
						编号
					</th>
					<th>
						客户名称
					</th>
					<th>
						订单金额（元）
					</th>
				</tr>
				<logic:iterate id="item" name="allList"
					type="com.team3.entity.CstCustomer" indexId="i">
					<tr>
						<td class="list_data_number" align="center">
							${i+1}
						</td>
						<td class="list_data_ltext">
							${item.custName }
						</td>
						<td class="list_data_number">
							${item.allPrice }
						</td>
					</tr>
				</logic:iterate>
				<logic:empty name="allList">
					<tr>
						<td class="list_data_text" colspan="20"
							style="text-align:center;height:40px;">
							没有记录
						</td>
					</tr>
				</logic:empty>
			</table>
		</html:form>
	</body>
</html>
