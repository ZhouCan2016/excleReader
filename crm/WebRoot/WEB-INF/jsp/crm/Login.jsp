<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>login_</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=GB2312">
<style>
	th{
		font-size:12px;
		text-align:right;
		font-weight:normal;
	}
	td{
		font-size:12px;
		text-align:left;
	}
	input{
		width:100px;
		font-size:12px;
		border:solid 1px lightblue;
	}
</style>
<script type="text/javascript">
function Loginsubmit(){
	document.forms[0].submit();
}
</script>
</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 style="text-align:center;padding-top:20px;">
<TABLE WIDTH=800 BORDER=0 CELLPADDING=0 CELLSPACING=0>
  <TR>
		<TD COLSPAN=7>
			<IMG SRC="images/login/login_01.jpg" WIDTH=800 HEIGHT=71 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=71 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=7>&nbsp;
		
		</TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=66 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=7>
			<IMG SRC="images/login/login_03.jpg" WIDTH=800 HEIGHT=6 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=6 ALT=""></TD>
	</TR>
	<TR>
		
    <TD COLSPAN=3>&nbsp; </TD>
		<TD COLSPAN=3 ROWSPAN=2>
			<IMG SRC="images/login/login_05.jpg" WIDTH=426 HEIGHT=83 ALT=""></TD>
		
    <TD ROWSPAN=3>&nbsp;</TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=44 ALT=""></TD>
	</TR>
	<TR>
		
    <TD ROWSPAN=4>&nbsp; </TD>
		<TD COLSPAN=2>
			<IMG SRC="images/login/login_08.jpg" WIDTH=94 HEIGHT=39 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=39 ALT=""></TD>
	</TR>
	<TR>
		<TD ROWSPAN=3>
			<IMG SRC="images/login/login_09.jpg" WIDTH=15 HEIGHT=141 ALT=""></TD>
		
    <TD COLSPAN=2 ROWSPAN=2 background="images/login/login_10.jpg" >
    <html:form action="login">
    <html:hidden property="o" value="doLogin" />
<table width="100%">
        <tr> 
          <th>用户名</th>
          <td><html:text size="10" maxlength="20" property="item.usrName"/></td>    
        </tr>
        <tr> 
          <th>密码</th>
          <td><html:password size="10" maxlength="20"  property="item.usrPassword"/></td>
        </tr>
         <tr> 
          <th></th>
          <td><html:errors property="error2"/></td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
          <td><img onclick="javascript:Loginsubmit();" src="images/login/login_button.jpg" width="73" height="25"></td>
        </tr>
      </table>
</html:form>
	
    </TD>
		<TD COLSPAN=2>
			<IMG SRC="images/login/login_11.jpg" WIDTH=304 HEIGHT=86 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=86 ALT=""></TD>
	</TR>
	<TR>
		<TD ROWSPAN=2>
			<IMG SRC="images/login/login_12.jpg" WIDTH=19 HEIGHT=55 ALT=""></TD>
		
    <TD COLSPAN=2 ROWSPAN=3>&nbsp; </TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=28 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=2>
			<IMG SRC="images/login/login_14.jpg" WIDTH=201 HEIGHT=27 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=27 ALT=""></TD>
	</TR>
	<TR>
		
    <TD COLSPAN=5>&nbsp; </TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=67 ALT=""></TD>
	</TR>
	<TR>
		
    <TD COLSPAN=7 background="images/login/login_16.jpg" style="text-align:right;padding-right:25px;"> 
			&copy; 2008 北京阿博泰克北大青鸟信息技术有限公司
    </TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=55 ALT=""></TD>
	</TR>
	<TR>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=150 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=15 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=79 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=122 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=19 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=285 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=130 HEIGHT=1 ALT=""></TD>
		<TD></TD>
	</TR>
</TABLE>
</BODY>
</HTML>