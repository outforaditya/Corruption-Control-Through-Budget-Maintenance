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
    
    <title>My JSP 'distributebudgettodistricts.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
function validateForm()
{
var x=parseInt(document.frm.availfund.value);
var y=parseInt(document.frm.amount.value);
var z=parseInt(document.frm.budget.value);
var year=parseInt(document.frm.year.value);
var bal=x-y;

if(x<=0||x==0||y==0){
  alert("Insufficent Budget Amount ");
  return false;
}
 else if(bal<0) {
 alert("Insufficent Budget Amount ");
 return false;
 }
 else if(year<=2011||year=='NaN') {
 alert("Enter Correct year ");
 return false;
 }
 
}
</script>
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
     <form action="./InsertDistrictBudgetAction" name="frm"  method="post" >
       <table align="left" width=90% bgcolor="#019283">
<th colspan="6" bgcolor="#asHblue">District level Budget disrtibution </th>
<tr></tr>

<tr><td>Depertment Name</td><td><input type="text" name="deptname" value="${requestScope.deptname}" readonly="readonly"></td></tr>
<tr><td>SubDepertment Name</td><td><input type="text" name="subdept" value="${requestScope.subdept}" readonly="readonly"></td></tr>
<tr><td> Total Budget</td><td><input type="text" name="budget" value="${requestScope.budget}" readonly="readonly"></td></tr>

<tr>
                 

					<td>District</td>
					<td width="276">
						<select name="dname" id="select" >
				<c:choose>
				 <c:when test="${requestScope.departmentname ne null}">
				   <option value="${requestScope.departmentname}">${requestScope.departmentname}</option>
				 </c:when>
				 <c:otherwise>
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty district}">
				<c:forEach var="depart" items="${district}">
				<option value="${depart.district}">								
				${depart.district}
				</option>
				</c:forEach>
				</c:if>
				 </c:otherwise>
				</c:choose>	

</tr>
<tr><td>Available Amount</td><td><input type="text" name="availfund" value="<%=request.getAttribute("availfund") %>" readonly="readonly"></td></tr>
<tr><td>Budget Amount</td><td><input type="text" name="amount" value=""></td></tr>

<tr><td>Financial year</td><td><input type="text" name="year" value=""></td></tr>
<tr><td align="center"> <input type="submit" value="Submit" onclick="javascript:return validateForm()"></td><td><input type="reset" value="Clear"></td></tr>
   <tr></tr><tr>  </tr>
   
    </table></form> 
    
  </body>
</html>
