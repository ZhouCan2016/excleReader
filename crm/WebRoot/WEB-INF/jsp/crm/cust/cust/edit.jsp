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
				客户信息管理 > 客户信息
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button" onclick="to('linkman.html');">
					联系人
				</button>
				<button class="common_button" onclick="to('activities.html');">
					交往记录
				</button>
				<button class="common_button" onclick="to('orders.html');">
					历史订单
				</button>

				<button class="common_button" onclick="back();">
					返回
				</button>
				<html:submit styleClass="common_button">保存</html:submit>
				<html:hidden property="o" value="doEdit" />
				<html:hidden property="item.custNo"
					value="${customerForm.item.custNo }" />
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						客户编号
					</th>
					<td>
						${customerForm.item.custNo }
					</td>
					<th>
						名称
					</th>
					<td>
						<html:text property="item.custName" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						地区
					</th>
					<td>
						<html:select property="item.custRegion">
							<html:option value="-1">全部</html:option>
							<logic:iterate id="o" name="customerForm" property="allRegion"
								type="com.team3.entity.BasDict">
								<html:option value="${o.dictItem}">${o.dictItem}</html:option>
							</logic:iterate>
						</html:select>
						<span class="red_star">*</span>
					</td>
					<th>
						客户经理
					</th>
					<td>
						<html:select property="item.custManagerId">
							<html:option value="-1">全部</html:option>
							<logic:iterate id="o" name="customerForm" property="allManager"
								type="com.team3.entity.SysUser">
								<html:option value="${o.usrId}">${o.usrName}</html:option>
							</logic:iterate>
						</html:select>
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						客户等级
					</th>
					<td>
						<html:select property="item.custLevelLabel">
							<html:option value="未分配">
							全部
						</html:option>
							<logic:iterate id="o" name="customerForm" property="allLevel"
								type="com.team3.entity.BasDict">
								<html:option value="${o.dictItem}">${o.dictItem}</html:option>
							</logic:iterate>
						</html:select>
						<span class="red_star">*</span>
					</td>
					<th>
					</th>
					<td>
					</td>
				</tr>
				<tr>
					<th>
						客户满意度
					</th>
					<td>
						<html:select property="item.custSatisfy">
							<option value="">
								未指定
							</option>
							<html:option value="5">
								☆☆☆☆☆
							</html:option>
							<html:option value="4">
								☆☆☆☆
							</html:option>
							<html:option value="3">
								☆☆☆
							</html:option>
							<html:option value="2">
								☆☆
							</html:option>
							<html:option value="1">
								☆
							</html:option>
						</html:select>
						<span class="red_star">*</span>
					</td>
					<th>
						客户信用度
					</th>
					<td>
						<html:select property="item.custCredit">
							<option value="-1">
								未指定
							</option>
							<html:option value="5">
								☆☆☆☆☆
							</html:option>
							<html:option value="4">
								☆☆☆☆
							</html:option>
							<html:option value="3">
								☆☆☆
							</html:option>
							<html:option value="2">
								☆☆
							</html:option>
							<html:option value="1">
								☆
							</html:option>
						</html:select>
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
			<br />
			<table class="query_form_table" id="table1">
				<tr>
					<th>
						地址
					</th>
					<td>
						<html:text property="item.custAddr" />
						<span class="red_star">*</span>
					</td>
					<th>
						邮政编码
					</th>
					<td>
						<html:text property="item.custZip" size="20" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						电话
					</th>
					<td>
						<html:text property="item.custTel" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						传真
					</th>
					<td>
						<html:text property="item.custFax" size="20" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						网址
					</th>
					<td>
						<html:text property="item.custWebsite" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
					</th>
					<td>
					</td>
				</tr>
			</table>
			<br />
			<table class="query_form_table" id="table2">
				<tr>
					<th>
						营业执照注册号
					</th>
					<td>
						<html:text property="item.custLicenceNo" size="20" />
					</td>
					<th>
						法人
					</th>
					<td>
						<html:text property="item.custChieftain" size="20" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						注册资金（万元）
					</th>
					<td>
						<html:text property="item.custBankroll" size="20" />
					</td>
					<th>
						年营业额
					</th>
					<td>
						<html:text property="item.custTurnover" size="20" />
					</td>
				</tr>
				<tr>
					<th>
						开户银行
					</th>
					<td>
						<html:text property="item.custBank" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						银行帐号
					</th>
					<td>
						<html:text property="item.custBankAccount" size="20" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						地税登记号
					</th>
					<td>
						<html:text property="item.custLocalTaxNo" size="20" />
					</td>
					<th>
						国税登记号
					</th>
					<td>
						<html:text property="item.custNationalTaxNo" size="20" />
					</td>
				</tr>
			</table>
			<p>
			</p>
		</html:form>
	</body>
</html>
