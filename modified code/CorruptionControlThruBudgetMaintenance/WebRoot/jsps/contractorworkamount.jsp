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
    
    <title>My JSP 'viewdeptbudget.jsp' starting page</title>
    
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
  
  <body onload="javascript:disableBackButton()">
     <jsp:include page="header1.jsp"></jsp:include> <br/>   

   <table align="center" border="1" bgcolor="" width="70%" cellpadding="10">
   <caption>Contractor Work Amount</caption>
     <tr bgcolor="#adede"><i></i></tr>
     <br/><br/>
     <tr><th bgcolor="lightgreen"><b>Work Name</b></th><th bgcolor="lightgreen"><b>Department</b></th><th bgcolor="lightgreen"><b>Budget Amount</b></th><th bgcolor="lightgreen"><b>Financial Year</b></th> 
   </tr>
   
   
   <c:if test="${not empty trans}">
   <c:forEach var="officer" items="${trans}">
   
    <tr>
    <td>${officer.workname}</td>
    <td>${officer.deptname}</td>
    <td>${officer.amount}</td>
    <td>${officer.year}</td>
    
    
 
     </tr>
   </c:forEach>
   </c:if>
   
    </table>
    <br/><br/>
    
     <table align="center" border="1" bgcolor="" width="70%" cellpadding="10">
     <tr><td width="900"> <h3>You have to update and submit your work details and fund utilization Regularly </td></tr>
     </table>
  
    <jsp:include page="footer.jsp"/>
  </body>
</html>
