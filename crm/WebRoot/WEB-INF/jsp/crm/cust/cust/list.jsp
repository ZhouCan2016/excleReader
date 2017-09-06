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
		<html:form action="customer">
		<div class="page_title">
			�ͻ���Ϣ����
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
					�ͻ����
				</th>
				<td>
					<html:text property="item.custNo"></html:text>
				</td>
				<th>
					����
				</th>
				<td>
					<html:text property="item.custName" />
				</td>
				<th>
					����
				</th>
				<td>
					<html:select property="item.custRegion">
						<html:option value="-1">ȫ��</html:option>
						<logic:iterate id="o" name="customerForm" property="allRegion" type="com.team3.entity.BasDict">
							<html:option value="${o.dictItem}">${o.dictItem}</html:option>
						</logic:iterate>
					</html:select>
				</td>
			</tr>
			<tr>
				<th>
					�ͻ�����
				</th>
				<td>
					<html:text property="item.custManagerName" />
				</td>
				<th>
					�ͻ��ȼ�
				</th>
				<td>
					<html:select property="item.custLevelLabel">
						<html:option value="δ����">
							ȫ��
						</html:option>
						<html:option value="ս�Ժ������">
							ս�Ժ������
						</html:option>
						<html:option value="�������">
							�������
						</html:option>
						<html:option value="��ͻ�">
							��ͻ�
						</html:option>
						<html:option value="��ͨ�ͻ�">
							��ͨ�ͻ�
						</html:option>
					</html:select>
				</td>
				<th>
				</th>
				<td>
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
					�ͻ����
				</th>
				<th>
					����
				</th>
				<th>
					����
				</th>
				<th>
					�ͻ�����
				</th>
				<th>
					�ͻ��ȼ�
				</th>
				<th>
					����
				</th>
			</tr>
			<logic:iterate id="o" name="customerForm"
				property="pageResult.list" type="com.team3.entity.CstCustomer" indexId="i">
			<tr>
				<td class="list_data_number">
					${(customerForm.pageResult.pageNo-1)*(customerForm.pageResult.pageSize)+(i+1) }
				</td>
				<td class="list_data_text">
					${o.custNo }
				</td>
				<td class="list_data_ltext">
					${o.custName }
				</td>
				<td class="list_data_text">
					${o.custRegion }
				</td>
				<td class="list_data_text">
					${o.custManagerName }
				</td>
				<td class="list_data_text">
					${o.custLevelLabel }
				</td>
				<td class="list_data_op">
					<img onclick="to('customer.do?o=toEdit&custNo=${o.custNo }');" title="�༭"
						src="images/bt_edit.gif" class="op_button" />
					<img onclick="to('linkman.html');" title="��ϵ��"
						src="images/bt_linkman.gif" class="op_button" />
					<img onclick="to('activities.html');" title="������¼"
						src="images/bt_acti.gif" class="op_button" />
					<img onclick="to('orders.html');" title="��ʷ����"
						src="images/bt_orders.gif" class="op_button" />

					<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��"
						src="images/bt_del.gif" class="op_button" />

				</td>
			</tr>
			</logic:iterate>
			<logic:empty name="customerForm" property="pageResult.list">
				<tr>
					<td class="list_data_text" colspan="20"
						style="text-align:center;height:40px;">
						û�м�¼
					</td>
				</tr>
			</logic:empty>
			<tr>
				<th colspan="100" class="pager">
					<jb:pager form="customerForm"/>
				</th>
			</tr>
		</table>
		</html:form>
	</body>
</html>
