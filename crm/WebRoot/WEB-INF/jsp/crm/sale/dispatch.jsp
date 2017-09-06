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
		<html:form action="chance">
			<div class="page_title">
				���ۻ������&nbsp; &gt; ָ�����ۻ���
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					����
				</button>
				<button class="common_button" onclick="back();">
					����
				</button>
				<html:submit styleClass="common_button">����</html:submit>
				<html:hidden property="o" value="doDue" />
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						���
					</th>
					<td>
						${salchanceForm.item.chcId }
					</td>
					<th>
						������Դ
					</th>
					<td>
						${salchanceForm.item.chcSource }
					</td>
				</tr>
				<tr>
					<th>
						�ͻ�����
					</th>
					<td>
						${salchanceForm.item.chcCustName }
					</td>
					<th>
						�ɹ����ʣ�%��
					</th>
					<td>
						&nbsp;${salchanceForm.item.chcRate }
					</td>
				</tr>
				<tr>
					<th>
						��Ҫ
					</th>
					<td colspan="3">
						${salchanceForm.item.chcTitle }
					</td>
				</tr>
				<tr>
					<th>
						��ϵ��
					</th>
					<td>
						${salchanceForm.item.chcLinkman }
					</td>
					<th>
						��ϵ�˵绰
					</th>
					<td>
						${salchanceForm.item.chcTel }
					</td>
				</tr>
				<tr>
					<th>
						��������
					</th>
					<td colspan="3">
						${salchanceForm.item.chcDesc }
					</td>
				</tr>
				<tr>
					<th>
						������
					</th>
					<td>
						${salchanceForm.item.chcCreateBy }
					</td>
					<th>
						����ʱ��
					</th>
					<td>
						${salchanceForm.item.chcCreateDateString }
					</td>
				</tr>
			</table>
			<br />
			<table class="query_form_table" id="table1">
				<tr>
					<th>
						ָ�ɸ�
					</th>
					<td>
						<html:select property="item.chcDueId">
							<option>
								��ѡ��...
							</option>
							<logic:iterate id="o" name="salchanceForm" property="item.allDue">
								<html:option value="${o.usrId}">
								${o.usrName }
							</html:option>
							</logic:iterate>
						</html:select>
						<span class="red_star">*</span>
					</td>
					<th>
						ָ��ʱ��
					</th>
					<td>
						<bean:write name="salchanceForm" property="item.chcDueDate" format="yyyy��MM��dd�� HHʱmm��ss��"/>
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
		</html:form>
		<script>
	setCurTime('t2');
</script>
	</body>
</html>
