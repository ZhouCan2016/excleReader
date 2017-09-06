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
		<html:form action="product">
			<div class="page_title">
				产品查询
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
						名称
					</th>
					<td>
						<html:text property="item.prodName" />
					</td>
					<th>
						型号
					</th>
					<td>
						<html:text property="item.prodType" />
					</td>
					<th>
						批次
					</th>
					<td>
						<html:text property="item.prodBatch" />
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
						名称
					</th>
					<th>
						型号
					</th>
					<th>
						等级/批次
					</th>
					<th>
						单位
					</th>
					<th>
						单价（元）
					</th>
					<th>
						备注
					</th>
				</tr>
				<logic:iterate id="item" name="productForm"
					property="pageResult.list" type="com.team3.entity.Product"
					indexId="i">
					<tr>
						<td class="list_data_number">
							${(productForm.pageResult.pageNo-1)*(productForm.pageResult.pageSize)+(i+1) }
						</td>
						<td class="list_data_ltext">
							${item.prodName }
						</td>
						<td class="list_data_text">
							${item.prodType }
						</td>
						<td class="list_data_text">
							${item.prodBatch }
						</td>
						<td class="list_data_text">
							${item.prodUnit }
						</td>
						<td class="list_data_number">
							${item.prodPrice }
						</td>
						<td class="list_data_ltext">
							${item.prodMemo }
						</td>
					</tr>
				</logic:iterate>
				<logic:empty name="productForm" property="pageResult.list">
				<tr>
					<td class="list_data_text" colspan="20"
						style="text-align:center;height:40px;">
						没有记录
					</td>
				</tr>
			</logic:empty>
				<tr>
					<th colspan="100" class="pager">
						<jb:pager form="productForm" />
					</th>
				</tr>
			</table>
		</html:form>
	</body>
</html>
