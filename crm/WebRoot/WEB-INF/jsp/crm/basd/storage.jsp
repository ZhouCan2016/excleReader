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
		<html:form action="storage">
			<div class="page_title">
				��Ʒ��ѯ
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
						��Ʒ
					</th>
					<td>
						<html:text property="item.product.prodName"></html:text>
					</td>
					<th>
						�ֿ�
					</th>
					<td>
						<html:text property="item.stkWarehouse"></html:text>
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
						��Ʒ
					</th>
					<th>
						�ֿ�
					</th>
					<th>
						��λ
					</th>
					<th>
						����
					</th>
					<th>
						��ע
					</th>
				</tr>
				<logic:iterate id="item" name="storageForm"
					property="pageResult.list" type="com.team3.entity.Storage"
					indexId="i">
				<tr>
					<td class="list_data_number">
						${(storageForm.pageResult.pageNo-1)*(storageForm.pageResult.pageSize)+(i+1) }
					</td>
					<td class="list_data_ltext">
						${item.product.prodName }
					</td>
					<td class="list_data_ltext">
						${item.stkWarehouse }
					</td>
					<td class="list_data_text">
						${item.stkWare }
					</td>
					<td class="list_data_number">
						${item.stkCount }
					</td>
					<td class="list_data_ltext">
						${item.stkMemo }
					</td>
				</tr>
				</logic:iterate>
				<logic:empty name="storageForm" property="pageResult.list">
				<tr>
					<td class="list_data_text" colspan="20"
						style="text-align:center;height:40px;">
						û�м�¼
					</td>
				</tr>
			</logic:empty>
				<tr>
					<th colspan="100" class="pager">
						<jb:pager form="storageForm" />
					</th>
				</tr>
			</table>
		</html:form>
	</body>
</html>
