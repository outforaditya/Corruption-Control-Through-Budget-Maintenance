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
     <jsp:include page="header.jsp"></jsp:include> <br/>   

   <table align="center" border="1" bgcolor="" width="70%" cellpadding="10">
   <caption>Department  Budget</caption>
     <tr bgcolor="#adede"><i></i></tr>
     <br/><br/>
     <tr><th bgcolor="lightgreen"><b>Department</b></th><th bgcolor="lightgreen"><b>Subdepartment</b></th><th bgcolor="lightgreen"><b>BudgetDate</b></th><th bgcolor="lightgreen"><b>Total Amount</b></th><th bgcolor="lightgreen"><b>Financial year</b></th><th bgcolor="lightgreen"><b>Distribute Budget</b></th> 
   </tr>
   
   
   <c:if test="${not empty trans}">
   <c:forEach var="officer" items="${trans}">
   
    <tr>
   
    <td>${officer.deptname}</td>
    <td>${officer.subdeptname}</td>
    <td>${officer.budgetdate}</td>
    <td>${officer.amount}</td>
    <td>${officer.year}</td>
    <td>  <a href="<%=request.getContextPath()+"/DistributeBudgettoDistrictsAction"%>?budget=${officer.amount}&availfund=${officer.availfund}&deptname=${officer.deptname}&subdept=${officer.subdeptname}"><b>Distribute Budget</b></a></td>

     </tr>
   </c:forEach>
   </c:if>
   
    </table>
    <br/><br/>
    <table align="center" cellpadding="7" cellspacing="2" bgcolor="#85787856">
    <thead>Note:</thead>
    <tr><td>1. This Amount should be distribute to districts as per report and orders which are got from State Govt.</td></tr>
    <tr><td>2. Distribute fund to only listed eligible Districts as per in your record.</td></tr>
    <tr><td></td></tr>
    
    
    </table>
    
  
    <jsp:include page="footer.jsp"/>
  </body>
</html>
