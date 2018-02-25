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
    <form action="" name="budget">
   <table align="center" border="1" bgcolor="" width="70%" cellpadding="10">
   <caption>District Officers</caption>
     <tr bgcolor="#adede"><i><br></i></tr>
     <br/><br/>
     <select name="dname" id="select" onchange="javascript:if(document.budget.dname.value==''){alert('Select Any Department');}  {location.href='./ViewDistBudgetAction?distname='+document.budget.dname.value;}">
    <c:choose>
    <option value="">--SELECT--</option>
   <c:if test="${not empty distofficers}">
   <c:forEach var="officer" items="${distofficers}">
   
    
   <option value="${officer.district}">		

    ${officer.district }
    
  
 </option>
    
   
				</c:forEach>
				</c:if>
				 
				</c:choose>	
							
			
				</select>
   
    </table>
 <br/><br/>

     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
