<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/jb-common.tld" prefix="jb"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>jb-aptech��ҵ�����Ŀ</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="script/common.js"></script>
	</head>
	<body>
		<html:form action="lostRpt">
			<div class="page_title">
				�ͻ���ʧ����
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					����
				</button>
				<html:submit styleClass="common_button">��ѯ</html:submit>
				<html:hidden property="o" value="toList" />
			</div>
			<table class="query_form_table" border="0" cellPadding="3"
				cellSpacing="0">
				<tr>
					<th>
						�ͻ�����
					</th>
					<td>
						<html:text property="item.lstCustName"></html:text>
					</td>
					<th>
						�ͻ�����
					</th>

					<td>
						<html:text property="item.lstCustManagerName"></html:text>
					</td>

				</tr>
			</table>
			<br />
			<table class="data_list_table">
				<tr>
					<th height="28">
						���
					</th>
					<th height="28">
						���
					</th>
					<th height="28">
						�ͻ�
					</th>
					<th height="28">
						�ͻ�����
					</th>
					<th height="28">
						��ʧԭ��
					</th>
				</tr>
				<logic:iterate id="item" name="lostForm" property="pageResult.list"
					type="com.team3.entity.CstLost" indexId="i">

					<tr>
						<td class="list_data_number" height="27">
							${(lostForm.pageResult.pageNo-1)*(lostForm.pageResult.pageSize)+(i+1) }
						</td>
						<td class="list_data_text" height="27">
							${item.lostYear }
						</td>
						<td class="list_data_text" height="27">
							${item.lstCustName }
						</td>
						<td class="list_data_text" height="27">
							${item.lstCustManagerName }
						</td>
						<td class="list_data_ltext" height="27">
							${item.lstReason }
						</td>
					</tr>
				</logic:iterate>
				<logic:empty name="lostForm" property="pageResult.list">
				<tr>
					<td class="list_data_text" colspan="20"
						style="text-align:center;height:40px;">
						û�м�¼
					</td>
				</tr>
			</logic:empty>
				<tr>
					<th colspan="7" class="pager">
						<jb:pager form="lostForm" />
					</th>
				</tr>
			</table>
		</html:form>
	</body>
</html>
