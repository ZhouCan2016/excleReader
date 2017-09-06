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
		<html:form action="customer">
		<div class="page_title">
			客户信息管理
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
					客户编号
				</th>
				<td>
					<html:text property="item.custNo"></html:text>
				</td>
				<th>
					名称
				</th>
				<td>
					<html:text property="item.custName" />
				</td>
				<th>
					地区
				</th>
				<td>
					<html:select property="item.custRegion">
						<html:option value="-1">全部</html:option>
						<logic:iterate id="o" name="customerForm" property="allRegion" type="com.team3.entity.BasDict">
							<html:option value="${o.dictItem}">${o.dictItem}</html:option>
						</logic:iterate>
					</html:select>
				</td>
			</tr>
			<tr>
				<th>
					客户经理
				</th>
				<td>
					<html:text property="item.custManagerName" />
				</td>
				<th>
					客户等级
				</th>
				<td>
					<html:select property="item.custLevelLabel">
						<html:option value="未分配">
							全部
						</html:option>
						<html:option value="战略合作伙伴">
							战略合作伙伴
						</html:option>
						<html:option value="合作伙伴">
							合作伙伴
						</html:option>
						<html:option value="大客户">
							大客户
						</html:option>
						<html:option value="普通客户">
							普通客户
						</html:option>
					</html:select>
				</td>
				<th>
				</th>
				<td>
				</td>
			</tr>
		</table>
		<br />
		<table class="data_list_table">
			<tr>
				<th>
					序号
				</th>
				<th>
					客户编号
				</th>
				<th>
					名称
				</th>
				<th>
					地区
				</th>
				<th>
					客户经理
				</th>
				<th>
					客户等级
				</th>
				<th>
					操作
				</th>
			</tr>
			<logic:iterate id="o" name="customerForm"
				property="pageResult.list" type="com.team3.entity.CstCustomer" indexId="i">
			<tr>
				<td class="list_data_number">
					${(customerForm.pageResult.pageNo-1)*(customerForm.pageResult.pageSize)+(i+1) }
				</td>
				<td class="list_data_text">
					${o.custNo }
				</td>
				<td class="list_data_ltext">
					${o.custName }
				</td>
				<td class="list_data_text">
					${o.custRegion }
				</td>
				<td class="list_data_text">
					${o.custManagerName }
				</td>
				<td class="list_data_text">
					${o.custLevelLabel }
				</td>
				<td class="list_data_op">
					<img onclick="to('customer.do?o=toEdit&custNo=${o.custNo }');" title="编辑"
						src="images/bt_edit.gif" class="op_button" />
					<img onclick="to('linkman.html');" title="联系人"
						src="images/bt_linkman.gif" class="op_button" />
					<img onclick="to('activities.html');" title="交往记录"
						src="images/bt_acti.gif" class="op_button" />
					<img onclick="to('orders.html');" title="历史订单"
						src="images/bt_orders.gif" class="op_button" />

					<img onclick="del('“客户：聪海信息科技有限公司”');" title="删除"
						src="images/bt_del.gif" class="op_button" />

				</td>
			</tr>
			</logic:iterate>
			<logic:empty name="customerForm" property="pageResult.list">
				<tr>
					<td class="list_data_text" colspan="20"
						style="text-align:center;height:40px;">
						没有记录
					</td>
				</tr>
			</logic:empty>
			<tr>
				<th colspan="100" class="pager">
					<jb:pager form="customerForm"/>
				</th>
			</tr>
		</table>
		</html:form>
	</body>
</html>
