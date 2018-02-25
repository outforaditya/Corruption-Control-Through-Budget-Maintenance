<%@ page language="java" import="java.util.*,com.ccbm.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getdeptbudget.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>


</head>
  
  <body onload="javascript:disableBackButton()" bgcolor="#FFFAF0">
  <jsp:include page="header.jsp"/>
  <form action="./GetDistBudgetAction" name="frm" method="post">
  
  <table align="center" cellspacing="4" cellpadding="8" border="5">
  <thead align="center" style="color: blue"> <h4>Enter Transaction password<br></h4></thead>
  <tr><td colspan="2" bordercolor="" style="color:#4B0082">User ID</td><td><input type="text" name="user" value="${sessionScope.user}" readonly="readonly"> </td></tr>
  <tr><td colspan="2" bordercolor="" style="color:#4B0082">Transaction Password</td><td><input type="password" name="password" value=""> </td></tr>
  <tr><td colspan="2" bordercolor="" style="color:#4B0082"></td><td><input type="submit"  value="Submit"> </td><td><input type="reset"  value="Clear"> </td></tr>
  
  </table>
  </form>
  <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("frm");

   
    frmvalidator.addValidation("password","req","Password is required");
   
  </script>
  <jsp:include page="footer.jsp"/>
  </body>
</html>
