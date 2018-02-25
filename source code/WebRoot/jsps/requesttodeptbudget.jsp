<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'requesttodeptbudget.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
 <script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>


</head>
  
  <body onload="javascript:disableBackButton()">
  <jsp:include page="header.jsp"/>
  <form action="./RequesttoBudgetAction" method="post" name="frm">
  <h4 align="center" style="color: green"> Request to Budget Fund</h4>
  
   <table align="center" bgcolor="#D8BFD8">
   <th colspan="1" bgcolor="">Enter your Details  for verification</th>
   <tr></tr><tr></tr><tr></tr><tr></tr>
   <tr><td colspan="1">Enter your Login id <br></td><td><input type="text" name="loginid" value=""></td></tr>
   <tr><td>Enter your Password</td><td><input type="password" name="password" value=""></td></tr>
   <tr><td>Enter your Date of Birth</td><td><input type="text" name="dob" value="">[Eg.01-JAN-2010]</td></tr>
   
   <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit"></td><td><input type="reset" value="Clear"></td></tr>
   </table>
   </br></br></br></br></br>
   <jsp:include page="footer.jsp"/>
   </form>
   <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("frm");

    frmvalidator.addValidation("loginid","req","Login Name is required");
    frmvalidator.addValidation("loginid","alpha","Login Name is Only Characters");
    frmvalidator.addValidation("password","req","Password is required");
   frmvalidator.addValidation("dob","req","Date of Birth enter in given format eg:01-jan-2010");
  </script>
  </body>
</html>
