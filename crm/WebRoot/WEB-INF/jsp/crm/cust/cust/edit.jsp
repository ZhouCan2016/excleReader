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
				�ͻ���Ϣ���� > �ͻ���Ϣ
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					����
				</button>
				<button class="common_button" onclick="to('linkman.html');">
					��ϵ��
				</button>
				<button class="common_button" onclick="to('activities.html');">
					������¼
				</button>
				<button class="common_button" onclick="to('orders.html');">
					��ʷ����
				</button>

				<button class="common_button" onclick="back();">
					����
				</button>
				<html:submit styleClass="common_button">����</html:submit>
				<html:hidden property="o" value="doEdit" />
				<html:hidden property="item.custNo"
					value="${customerForm.item.custNo }" />
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						�ͻ����
					</th>
					<td>
						${customerForm.item.custNo }
					</td>
					<th>
						����
					</th>
					<td>
						<html:text property="item.custName" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						����
					</th>
					<td>
						<html:select property="item.custRegion">
							<html:option value="-1">ȫ��</html:option>
							<logic:iterate id="o" name="customerForm" property="allRegion"
								type="com.team3.entity.BasDict">
								<html:option value="${o.dictItem}">${o.dictItem}</html:option>
							</logic:iterate>
						</html:select>
						<span class="red_star">*</span>
					</td>
					<th>
						�ͻ�����
					</th>
					<td>
						<html:select property="item.custManagerId">
							<html:option value="-1">ȫ��</html:option>
							<logic:iterate id="o" name="customerForm" property="allManager"
								type="com.team3.entity.SysUser">
								<html:option value="${o.usrId}">${o.usrName}</html:option>
							</logic:iterate>
						</html:select>
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						�ͻ��ȼ�
					</th>
					<td>
						<html:select property="item.custLevelLabel">
							<html:option value="δ����">
							ȫ��
						</html:option>
							<logic:iterate id="o" name="customerForm" property="allLevel"
								type="com.team3.entity.BasDict">
								<html:option value="${o.dictItem}">${o.dictItem}</html:option>
							</logic:iterate>
						</html:select>
						<span class="red_star">*</span>
					</td>
					<th>
					</th>
					<td>
					</td>
				</tr>
				<tr>
					<th>
						�ͻ������
					</th>
					<td>
						<html:select property="item.custSatisfy">
							<option value="">
								δָ��
							</option>
							<html:option value="5">
								������
							</html:option>
							<html:option value="4">
								�����
							</html:option>
							<html:option value="3">
								����
							</html:option>
							<html:option value="2">
								���
							</html:option>
							<html:option value="1">
								��
							</html:option>
						</html:select>
						<span class="red_star">*</span>
					</td>
					<th>
						�ͻ����ö�
					</th>
					<td>
						<html:select property="item.custCredit">
							<option value="-1">
								δָ��
							</option>
							<html:option value="5">
								������
							</html:option>
							<html:option value="4">
								�����
							</html:option>
							<html:option value="3">
								����
							</html:option>
							<html:option value="2">
								���
							</html:option>
							<html:option value="1">
								��
							</html:option>
						</html:select>
						<span class="red_star">*</span>
					</td>
				</tr>
			</table>
			<br />
			<table class="query_form_table" id="table1">
				<tr>
					<th>
						��ַ
					</th>
					<td>
						<html:text property="item.custAddr" />
						<span class="red_star">*</span>
					</td>
					<th>
						��������
					</th>
					<td>
						<html:text property="item.custZip" size="20" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						�绰
					</th>
					<td>
						<html:text property="item.custTel" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						����
					</th>
					<td>
						<html:text property="item.custFax" size="20" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						��ַ
					</th>
					<td>
						<html:text property="item.custWebsite" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
					</th>
					<td>
					</td>
				</tr>
			</table>
			<br />
			<table class="query_form_table" id="table2">
				<tr>
					<th>
						Ӫҵִ��ע���
					</th>
					<td>
						<html:text property="item.custLicenceNo" size="20" />
					</td>
					<th>
						����
					</th>
					<td>
						<html:text property="item.custChieftain" size="20" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						ע���ʽ���Ԫ��
					</th>
					<td>
						<html:text property="item.custBankroll" size="20" />
					</td>
					<th>
						��Ӫҵ��
					</th>
					<td>
						<html:text property="item.custTurnover" size="20" />
					</td>
				</tr>
				<tr>
					<th>
						��������
					</th>
					<td>
						<html:text property="item.custBank" size="20" />
						<span class="red_star">*</span>
					</td>
					<th>
						�����ʺ�
					</th>
					<td>
						<html:text property="item.custBankAccount" size="20" />
						<span class="red_star">*</span>
					</td>
				</tr>
				<tr>
					<th>
						��˰�ǼǺ�
					</th>
					<td>
						<html:text property="item.custLocalTaxNo" size="20" />
					</td>
					<th>
						��˰�ǼǺ�
					</th>
					<td>
						<html:text property="item.custNationalTaxNo" size="20" />
					</td>
				</tr>
			</table>
			<p>
			</p>
		</html:form>
	</body>
</html>
