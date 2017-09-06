<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>jb-aptech��ҵ�����Ŀ</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="script/common.js"></script>
	</head>
	<body>
		<html:form action="svrRpt">
			<div class="page_title">
				�ͻ��������
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					����
				</button>
				<html:submit styleClass="common_button">��ѯ</html:submit>
				<html:hidden property="o" value="toList" />
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						���
					</th>
					<td>
						<html:select property="year">
							<html:option value="-1">ȫ��</html:option>
							<html:option value="2002">2002</html:option>
							<html:option value="2003">2003</html:option>
							<html:option value="2004">2004</html:option>
							<html:option value="2005">2005</html:option>
							<html:option value="2006">2006</html:option>
							<html:option value="2007">2007</html:option>
							<html:option value="2008">2008</html:option>
							<html:option value="2009">2009</html:option>
							<html:option value="2010">2010</html:option>
							<html:option value="2011">2011</html:option>
						</html:select>
					</td>
					<th>
						&nbsp;
					</th>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>
			<br />
			<table class="data_list_table">
				<tr>
					<th>
						���
					</th>
					<th>
						��Ŀ
					</th>
					<th>
						��������
					</th>
				</tr>
				<logic:iterate id="item" name="allList" indexId="i">
					<tr>
						<td class="list_data_text">
							${i+1 }
						</td>
						<td class="list_data_text">
							${item[0] }
						</td>
						<td class="list_data_text">
							${item[1] }
						</td>
					</tr>
				</logic:iterate>
				<logic:empty name="allList">
					<tr>
						<td class="list_data_text" colspan="20"
							style="text-align:center;height:40px;">
							û�м�¼
						</td>
					</tr>
				</logic:empty>
			</table>
		</html:form>
	</body>
</html>