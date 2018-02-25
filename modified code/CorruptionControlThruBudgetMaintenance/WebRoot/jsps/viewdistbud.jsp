<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

  <head>
  
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
   <caption>District Budget</caption>
     <tr bgcolor="#adede"><i></i></tr>
     <br/><br/>
     <tr><th bgcolor="lightgreen"><b>Department</b></th><th bgcolor="lightgreen"><b>Subdepartment</b></th><th bgcolor="lightgreen"><b>District</b></th><th bgcolor="lightgreen"><b>DistributedBy</b></th><th bgcolor="lightgreen"><b>BudgetDate</b></th><th bgcolor="lightgreen"><b> Amount</b></th><th bgcolor="lightgreen"><b>Financial year</b></th><th bgcolor="lightgreen"><b>Work Budget</b></th>
   </tr>
   
   
   <c:if test="${not empty distbudget}">
   <c:forEach var="officer" items="${distbudget}">
   
    <tr>
   
    <td>${officer.deptname}</td>
    <td>${officer.subdeptname}</td>
    <td>${officer.district}</td>
    <td>${officer.distributedby}</td>
    <td>${officer.budgetdate}</td>
    <td>${officer.amount}</td>
    <td>${officer.year}</td>
    <td><a href="<%=request.getContextPath()+"/DistributeBudgettoWorkAction"%>?distbudgetid=${officer.distbudgetid}">ASSIGN BUDGET TO WORK</a></td>
   
 
     </tr>
   </c:forEach>
   </c:if>
   
    </table>
 <br/><br/>

     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
