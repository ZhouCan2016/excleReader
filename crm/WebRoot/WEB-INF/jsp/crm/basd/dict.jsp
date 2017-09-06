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
		<html:form action="dict">
			<div class="page_title">
				�����ֵ����
			</div>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					����
				</button>
				<button class="common_button" onclick="to('dict.do?o=toAdd');">
					�½�
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
						<html:text property="item.dictType" />
					</td>
					<th>
						��Ŀ
					</th>
					<td>
						<html:text property="item.dictItem" />
					</td>
					<th>
						ֵ
					</th>
					<td>
						<html:text property="item.dictValue" />
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
						���
					</th>
					<th>
						��Ŀ
					</th>
					<th>
						ֵ
					</th>
					<th>
						�Ƿ�ɱ༭
					</th>
					<th>
						����
					</th>
				</tr>
				<logic:iterate id="item" name="dictForm" property="pageResult.list"
					type="com.team3.entity.BasDict" indexId="i">
					<tr>
						<td class="list_data_number">
							${(dictForm.pageResult.pageNo-1)*(dictForm.pageResult.pageSize)+(i+1) }
						</td>
						<td class="list_data_ltext">
							${item.dictType }
						</td>
						<td class="list_data_text">
							${item.dictItem }
						</td>
						<td class="list_data_text">
							${item.dictValue }
						</td>
						<td class="list_data_text">
							${item.dictIsEditableString }
						</td>
						<td class="list_data_op">
							<logic:equal name="item" property="dictIsEditable" value="0">
								<img onclick="to('dict.do?o=toEdit&id=${item.dictId }');" title="�༭"
									src="images/bt_edit.gif" class="op_button" />
								<img onclick="del('��${item.dictType }��${item.dictItem }��','dict.do?o=Del&id=${item.dictId }');" title="ɾ��"
									src="images/bt_del.gif" class="op_button" />
							</logic:equal>
						</td>
					</tr>

				</logic:iterate>
				<logic:empty name="dictForm" property="pageResult.list">
				<tr>
					<td class="list_data_text" colspan="20"
						style="text-align:center;height:40px;">
						û�м�¼
					</td>
				</tr>
			</logic:empty>
				<tr>
					<th colspan="6" class="pager">
						<jb:pager form="dictForm" />
					</th>
				</tr>
			</table>
		</html:form>
	</body>
</html>
