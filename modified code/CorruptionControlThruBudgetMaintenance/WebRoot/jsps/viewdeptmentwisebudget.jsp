<%@ page language="java" import="java.util.*,com.ccbm.bean.*" pageEncoding="ISO-8859-1"%>
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
<span class="style13">Report Export to : <a href="./ExportXLS" target="_blank"><font color="brown">XLS</font></a></span><br/>
   <table align="center" border="1" bgcolor="" width="70%" cellpadding="10">
   <caption>District Budget</caption>
     <tr bgcolor="#adede"><i></i></tr>
     <br/><br/>
     <tr><th bgcolor="lightgreen"><b>Department</b></th><th bgcolor="lightgreen"><b>Subdepartment</b></th><th bgcolor="lightgreen"><b> Amount</b></th><th bgcolor="lightgreen"><b>Financial year</b></th> 
   </tr>
   
   
   <c:if test="${not empty subdeptart}">
   <c:forEach var="officer" items="${subdeptart}">
   
    <tr>
   
     <td>${requestScope.departmentname}</td>
    <td>${officer.subdeptname}</td>
    
    
   
    <td>${officer.amount}</td>
    <td>${officer.year}</td>
    
   
 
     </tr>
   </c:forEach>
   </c:if>
   
    </table>
 <br/><br/>

 <% String report="";
           report+=" <table align='center' border=1 bgcolor='#A1B2C3' width='70%' cellpadding='10'>";
           report+=" <caption><h3>District Budget Details</h3> </caption>"; 
           report+=" <tr><td>Deartment</td><td>SubDepartment</td><td>District</td><td>Amount</td><td>Year</td></tr>"; 
      
			Vector v=(Vector)request.getAttribute("subdeptart"); 
				 Iterator it=v.listIterator();
				while(it.hasNext()){
				BudgetBean r=(BudgetBean)it.next();
								
	report+= "<tr><td align='center'><b>"+r.getDeptname()+"</b></td><td align='center'><b>"+r.getSubdeptname()+"</td><td align='center'><b>"+r.getAmount()+"</b></td><td align='center'><b>"+r.getYear()+"</b></td></tr>";
		}
		report+="</table>";
		session.setAttribute("Report",report);
		
		%>
     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
