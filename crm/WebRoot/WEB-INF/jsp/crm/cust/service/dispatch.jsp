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
				客户服务管理 > 服务分配
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<html:submit styleClass="common_button">保存</html:submit>
				<html:hidden property="o" value="toDispatch" />
			</div>
			<table class="query_form_table" height="53">
				<tr>
					<th height="28">
						客户
					</th>
					<td>
						<html:text property="item.svrCustName" />
					</td>
					<th height="28">
						概要
					</th>
					<td>
						<html:text property="item.svrTitle" />
					</td>
					<th height="28">
						服务类型
					</th>
					<td>
						<html:select property="item.svrType">
							<html:option value="-1">请选择...</html:option>
							<html:option value="咨询">咨询</html:option>
							<html:option value="投诉">投诉</html:option>
							<html:option value="建议">建议</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<th height="22">
						创建日期
					</th>
					<td colspan="3">
						<input name="T2" size="10" />
						-
						<input name="T1" size="10" />
					</td>
					<th height="22">
						状态
					</th>
					<td>
						<html:select property="item.svrStatus">
							<html:option value="新创建">新创建</html:option>
						</html:select>
					</td>
				</tr>
			</table>
		</html:form>
		<br />
		<table class="data_list_table">
			<tr>
				<th>
					编号
				</th>
				<th>
					客户
				</th>
				<th>
					概要
				</th>
				<th>
					服务类型
				</th>
				<th>
					创建人
				</th>
				<th>
					创建日期
				</th>
				<th>
					分配给
				</th>
				<th>
					操作
				</th>
			</tr>
			<logic:iterate id="ser" name="serviceForm" property="pageResult.list"
				type="com.team3.entity.CstService" indexId="i">
				<html:form action="service">
					<tr>
						<td class="list_data_number">
							${ser.svrId }
						</td>
						<td class="list_data_text">
							${ser.svrCustName }
						</td>
						<td class="list_data_ltext">
							${ser.svrTitle}
						</td>
						<td class="list_data_text">
							${ser.svrType }
						</td>
						<td class="list_data_text">
							${ser.svrCreateBy }
						</td>
						<td class="list_data_text">
							${ser.svrCreateDateString }
						</td>
						<td class="list_data_text">

							<html:select property="item.svrDueId">
								<option>
									请选择...
								</option>
								<logic:iterate id="obj" name="serviceForm"
									property="item.allDue">
									<html:option value="${obj.usrId}">
										${obj.usrName }
									</html:option>
								</logic:iterate>
							</html:select>
							<html:hidden property="id" value="${ser.svrId }"/>
							<html:hidden property="o" value="doDispatch" />		
							<html:submit styleClass="common_button">分配</html:submit>

						</td>
						<td class="list_data_op">

							<img
								onclick="del('“客户：${ser.svrCustName }”','service.do?o=del&id=${ser.svrId }');"
								title="删除" src="images/bt_del.gif" class="op_button" />

						</td>
					</tr>
				</html:form>
			</logic:iterate>
			<logic:empty name="serviceForm" property="pageResult.list">
				<tr>
					<td class="list_data_text" colspan="20"
						style="text-align:center;height:40px;">
						没有记录
					</td>
				</tr>
			</logic:empty>

			<tr>
				<th colspan="8" class="pager">
					<jb:pager form="serviceForm" />
				</th>
			</tr>
		</table>
	</body>
</html>
