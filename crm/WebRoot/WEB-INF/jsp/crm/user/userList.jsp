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
		<html:form action="user">
			<div class="page_title">
				查询条件
			</div>

			<table class="query_form_table">
				<tr>
					<th>
						用户名
					</th>
					<td>
						<html:text property="item.usrName" />
					</td>
					<th>
						状态
					</th>
					<td>
						<html:select property="item.usrFlag">
							<html:option value="-1">全部</html:option>
							<html:option value="1">正常</html:option>
							<html:option value="0">已删除</html:option>
						</html:select>
					</td>
					<th>
						&nbsp;
					</th>
					<td style="text-align:center;">
						<html:submit styleClass="common_button">查询</html:submit>
						<html:hidden property="o" value="toList" />
						<button class="common_button" onclick="to('user.do?o=toAdd&id=${item.usrId }');">新增</button>
					</td>
				</tr>
			</table>
			<br />
			<div class="page_title">
				单据列表
			</div>
			<table class="data_list_table">
				<tr>
					<th>
						编号
					</th>
					<th>
						用户名
					</th>
					<th>
						状态
					</th>
					<th>
						操作
					</th>
				</tr>
				<logic:iterate id="item" name="userForm" property="pageResult.list"
					type="com.team3.entity.SysUser" indexId="i">
					<tr>
						<td class="list_data_number"
							style="text-align:right;padding:0 10px;">
							${(userForm.pageResult.pageNo-1)*(userForm.pageResult.pageSize)+(i+1)
							}
						</td>
						<td class="list_data_ltext" style="text-align:center;">
							${item.usrName }
						</td>
						<td class="list_data_ltext">
							${item.usrFlagString }
						</td>
						<td class="list_data_text">
							<img onclick="to('user.do?o=toEdit&id=${item.usrId }');" title="编辑"
								src="images/bt_edit.gif" class="op_button" />
							
							<img onclick="del('“用户：${item.usrName }”','user.do?o=Del&id=${item.usrId }');" title="删除"
								src="images/bt_del.gif" class="op_button" />

						</td>
					</tr>
				</logic:iterate>
				<logic:empty name="userForm" property="pageResult.list">
					<tr>
						<td class="list_data_text" colspan="20"
							style="text-align:center;height:40px;">
							没有记录
						</td>
					</tr>
				</logic:empty>
				<tr>
					<th colspan="100" class="pager">
						<jb:pager form="userForm" />
					</th>
				</tr>
			</table>
		</html:form>
	</body>
</html>
