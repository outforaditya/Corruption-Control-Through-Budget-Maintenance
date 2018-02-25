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
   <caption>Budget</caption>
     <tr bgcolor="#adede"><i></i></tr>
     <br/><br/>
     <tr><th bgcolor="lightgreen"><b>Department</b></th><th bgcolor="lightgreen"><b>Subdepartment</b></th><th bgcolor="lightgreen"><b> Amount</b></th><th bgcolor="lightgreen"><b>Financial year</b></th><th bgcolor="lightgreen"><b> Update</b></th><th bgcolor="lightgreen"><b>Delete</b></th> 
   </tr>
   
   
   <c:if test="${not empty subdeptart}">
   <c:forEach var="officer" items="${subdeptart}">
   
    <tr>
   
     <td>${requestScope.departmentname}</td>
    <td>${officer.subdeptname}</td>
    
    
   
    <td> <c:choose>
      <c:when test="${officer.amount=='0'}">Budget Not Entered.
      <br />
      </c:when>

      <c:otherwise>${officer.amount}
      <br />
      </c:otherwise>
    </c:choose>
    </td>
    <td><c:choose>
      <c:when test="${officer.year=='0'}">Budget Not Entered.
      <br />
      </c:when>

      <c:otherwise>${officer.year}
      <br />
      </c:otherwise>
    </c:choose></td>
    
   <td><c:choose>
      <c:when test="${officer.amount=='0'}">NO
      <br />
      </c:when>

      <c:otherwise><a href="./jsps/updatebudget.jsp?dept=${requestScope.departmentname}&subdept=${officer.subdeptname}&amt=${officer.amount}&year=${officer.year}"> Update</a>
      <br />
      </c:otherwise>
    </c:choose></td>
    <td> <c:choose>
      <c:when test="${officer.amount=='0'}">NO
      <br />
      </c:when>

      <c:otherwise><a href="./DeletebudgetAction?dept=${requestScope.departmentname}&subdept=${officer.subdeptname}"> Delete</a>
      <br />
      </c:otherwise>
    </c:choose></td>
 
     </tr>
   </c:forEach>
   </c:if>
   
    </table>
 <br/><br/>

     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
