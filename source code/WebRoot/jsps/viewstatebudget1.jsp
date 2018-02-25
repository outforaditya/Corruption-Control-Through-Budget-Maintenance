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
   <caption>State Budget</caption>
     <tr bgcolor="#adede"><i></i></tr>
     <br/><br/>
     <tr><th bgcolor="lightgreen"><b>Department</b></th><th bgcolor="lightgreen"><b>Subdepartment</b></th><th bgcolor="lightgreen"><b>BudgetDate</b></th><th bgcolor="lightgreen"><b>Total Amount[In Lacks]</b></th><th bgcolor="lightgreen"><b>Financial year</b></th> 
   </tr>
   
   
   <c:if test="${not empty statebudget}">
   <c:forEach var="officer" items="${statebudget}">
   
    <tr>
   
    <td>${officer.deptname}</td>
    <td>${officer.subdeptname}</td>
    <td>${officer.budgetdate}</td>
    <td>${officer.amount}</td>
    <td>${officer.year}</td>
    
   
 
     </tr>
   </c:forEach>
   </c:if>
   
    </table>
    <br/><br/>
    
    <table align="center">
    <th><u>NOTE</u></th>
   <tr> <td>1.Based on the conditions, you have to distribute fund to Districts.</td></tr>
    <tr><td>2.Fund should be sanction to elegiable Districts only.</td></tr>
   <tr> <td>3.Before fund transfer you have to get Transaction password by apply Request to Budget amount. </td></tr>
    </table>

     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
