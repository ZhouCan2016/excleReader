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
				客户服务管理 > 服务创建
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
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
						<html:text property="item.svrId" disabled="true" />
					</td>
					<th>
						服务类型
					</th>
					<td>
						<html:select property="item.svrType">
							<html:option value="-1">请选择...</html:option>
							<html:option value="咨询">咨询</html:option>
							<html:option value="投诉">投诉</html:option>
							<html:option value="建议">建议</html:option>
						</html:select>
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						概要
					</th>
					<td colspan="3">
						<html:text property="item.svrTitle" size="53" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						客户
					</th>
					<td>
						<html:text property="item.svrCustName" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						状态
					</th>
					<td>
						新创建
					</td>
				</tr>
				<tr>
					<th>
						服务请求
					</th>
					<td colspan="3">
						<html:textarea property="item.svrRequest" rows="6" cols="50"></html:textarea>
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						创建人
					</th>
					<td>
						<html:hidden property="item.svrCreateId"
							value="${sessionScope.Login.usrId}" />
						<html:text property="item.svrCreateBy"
							value="${sessionScope.Login.usrName}" readonly="true" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						创建时间
					</th>
					<td>
						<html:text readonly="true" size="20"
							property="item.svrCreateDateString" />
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
			<br />
			<table disabled class="query_form_table" id="table3">
				<tr>
					<th>
						分配给
					</th>
					<td>
						<html:select property="item.svrDueId">
							<option>
								请选择...
							</option>
							<logic:iterate id="o" name="serviceForm" property="item.allDue">
								<html:option value="${o.usrId}">
								${o.usrName }
							</html:option>
							</logic:iterate>
						</html:select>
						<span class="red_star">*</span>
					</td>
					<th>
						分配时间
					</th>
					<td>
						<html:text readonly="true" size="20"
							property="item.svrDueDateString" />
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
			<br />
			<table disabled class="query_form_table" id="table1">
				<tr>
					<th>
						服务处理
					</th>
					<td colspan="3">
						<textarea rows="6" cols="50"></textarea>
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						处理人
					</th>
					<td>
						<input name="T17" readonly size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						处理时间
					</th>
					<td>
						<input id="t3" name="T16" readonly size="20" />
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
			<br />
			<table disabled class="query_form_table" id="table2">
				<tr>
					<th>
						处理结果
					</th>
					<td>
						<input name="T10" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						满意度
					</th>
					<td>
						<select name="D1">
							<option>
								请选择...
							</option>
							<option>
								☆☆☆☆☆
							</option>
							<option>
								☆☆☆☆
							</option>
							<option>
								☆☆☆
							</option>
							<option>
								☆☆
							</option>
							<option>
								☆
							</option>
						</select>
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
			<script>
	setCurTime('t1');
	setCurTime('t2');
	setCurTime('t3');
</script>
		</html:form>
	</body>
</html>
