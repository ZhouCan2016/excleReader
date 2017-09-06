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
				�ͻ�������� > ���񴴽�
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					����
				</button>
				<html:submit styleClass="common_button">����</html:submit>
				<html:hidden property="o" value="doAdd" />
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						���
					</th>
					<td>
						<html:text property="item.svrId" disabled="true" />
					</td>
					<th>
						��������
					</th>
					<td>
						<html:select property="item.svrType">
							<html:option value="-1">��ѡ��...</html:option>
							<html:option value="��ѯ">��ѯ</html:option>
							<html:option value="Ͷ��">Ͷ��</html:option>
							<html:option value="����">����</html:option>
						</html:select>
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						��Ҫ
					</th>
					<td colspan="3">
						<html:text property="item.svrTitle" size="53" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						�ͻ�
					</th>
					<td>
						<html:text property="item.svrCustName" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						״̬
					</th>
					<td>
						�´���
					</td>
				</tr>
				<tr>
					<th>
						��������
					</th>
					<td colspan="3">
						<html:textarea property="item.svrRequest" rows="6" cols="50"></html:textarea>
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						������
					</th>
					<td>
						<html:hidden property="item.svrCreateId"
							value="${sessionScope.Login.usrId}" />
						<html:text property="item.svrCreateBy"
							value="${sessionScope.Login.usrName}" readonly="true" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						����ʱ��
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
						�����
					</th>
					<td>
						<html:select property="item.svrDueId">
							<option>
								��ѡ��...
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
						����ʱ��
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
						������
					</th>
					<td colspan="3">
						<textarea rows="6" cols="50"></textarea>
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						������
					</th>
					<td>
						<input name="T17" readonly size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						����ʱ��
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
						������
					</th>
					<td>
						<input name="T10" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						�����
					</th>
					<td>
						<select name="D1">
							<option>
								��ѡ��...
							</option>
							<option>
								������
							</option>
							<option>
								�����
							</option>
							<option>
								����
							</option>
							<option>
								���
							</option>
							<option>
								��
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
