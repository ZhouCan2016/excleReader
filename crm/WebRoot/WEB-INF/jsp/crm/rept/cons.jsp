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
		<html:form action="consRpt">
			<div class="page_title">
				�ͻ����ɷ���
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
						����ʽ
					</th>
					<td>
						<html:select property="type">
							<html:option value="dj">���ȼ�</html:option>
							<html:option value="xy">�����ö�</html:option>
							<html:option value="my">�������</html:option>
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
						${consForm.consName }
					</th>
					<th>
						�ͻ�����
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
