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

		<html:form action="service">
		<div class="page_title">
			�ͻ�������� &gt; ������
		</div>
		<div class="button_bar">
				<button class="common_button" onclick="help('');">
					����
				</button>
				<html:submit styleClass="common_button">����</html:submit>
				<html:hidden property="o" value="toArchList" />
			</div>
		<table class="query_form_table" height="53">
				<tr>
					<th height="28">
						�ͻ�
					</th>
					<td>
						<html:text property="item.svrCustName" />
					</td>
					<th height="28">
						��Ҫ
					</th>
					<td>
						<html:text property="item.svrTitle" />
					</td>
					<th height="28">
						��������
					</th>
					<td>
						<html:select property="item.svrType">
							<html:option value="-1">��ѡ��...</html:option>
							<html:option value="��ѯ">��ѯ</html:option>
							<html:option value="Ͷ��">Ͷ��</html:option>
							<html:option value="����">����</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<th height="22">
						��������
					</th>
					<td colspan="3">
						<input name="T2" size="10" />
						-
						<input name="T1" size="10" />
					</td>
					<th height="22">
						״̬
					</th>
					<td>
						<html:select property="item.svrStatus">
							<html:option value="-1">ȫ��</html:option>
							<html:option value="�ѷ���">�ѷ���</html:option>
							<html:option value="�ѷ���">�ѷ���</html:option>
						</html:select>
					</td>
				</tr>
			</table>
		</html:form>
		<br />
		<table class="data_list_table">
			<tr>
				<th>
					���
				</th>
				<th>
					�ͻ�
				</th>
				<th>
					��Ҫ
				</th>
				<th>
					��������
				</th>
				<th>
					������
				</th>
				<th>
					��������
				</th>
				<th>
					״̬
				</th>
				<th>
					����
				</th>
			</tr>
			<logic:iterate id="ser" name="serviceForm" property="pageResult.list"
				type="com.team3.entity.CstService" indexId="i">
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
					${ser.svrType }
				</td>
				<td class="list_data_op">

					<img onclick="to('service.do?o=toDetail&id=${ser.svrId }');" title="�鿴"
						src="images/bt_detail.gif" class="op_button" />
				</td>
			</tr>
			</logic:iterate>
			<tr>
				<th colspan="8" class="pager">
					<jb:pager form="serviceform"/>
				</th>
			</tr>
		</table>
	</body>
</html>
