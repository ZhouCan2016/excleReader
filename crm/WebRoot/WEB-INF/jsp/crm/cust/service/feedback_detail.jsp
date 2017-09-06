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
		<html:form action="service">
			<div class="page_title">
				客户服务管理 &gt; 服务处理
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button" onclick="back();">
					返回
				</button>
				<html:submit styleClass="common_button">保存</html:submit>
				<html:hidden property="o" value="doFeedback" />
				<html:hidden property="id" value="${serviceForm.item.svrId }" />
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						编号
					</th>
					<td>
						${serviceForm.item.svrId }
					</td>
					<th>
						服务类型
					</th>
					<td>
						${serviceForm.item.svrType }
					</td>
				</tr>
				<tr>
					<th>
						概要
					</th>
					<td colspan="3">
						${serviceForm.item.svrTitle }
					</td>
				</tr>
				<tr>
					<th>
						客户
					</th>
					<td>
						${serviceForm.item.svrCustName }
					</td>
					<th>
						状态
					</th>
					<td>
						${serviceForm.item.svrStatus }
					</td>
				</tr>
				<tr>
					<th>
						服务请求
					</th>
					<td colspan="3">
						${serviceForm.item.svrRequest }
						<br>
					</td>
				</tr>
				<tr>
					<th>
						创建人
					</th>
					<td>
						${serviceForm.item.svrCreateBy }
					</td>
					<th>
						创建时间
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
						分配给
					</th>
					<td>
						${serviceForm.item.svrDueTo }
					</td>
					<th>
						分配时间
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
						服务处理
					</th>
					<td colspan="3">
						${serviceForm.item.svrDeal }
					</td>
				</tr>
				<tr>
					<th>
						处理人
					</th>
					<td>
						${serviceForm.item.svrDealBy }
					</td>
					<th>
						处理时间
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
						处理结果
					</th>
					<td>
						<html:text size="20" property="item.svrResult" />
						<span class="red_star">*</span>
					</td>
					<th>
						满意度
					</th>
					<td>
						<html:select property="item.svrSatisfy">
							<html:option value="-1">请选择...</html:option>
							<html:option value="5">☆☆☆☆☆</html:option>
							<html:option value="4">☆☆☆☆</html:option>
							<html:option value="3">☆☆☆</html:option>
							<html:option value="2">☆☆</html:option>
							<html:option value="1">☆</html:option>
						</html:select>
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
