<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

  <head>
  
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
     <jsp:include page="header.jsp"></jsp:include> <br/>   
 <form action=""  name="budget">
   <table align="center" border="1" bgcolor="#456987" width="70%" cellpadding="10">
   <caption></caption>
     <tr bgcolor="#adede" align="center"><i>View Work Details </i></tr>
     
     <tr>
        <td>Available Departments</td>
        <td> 
				<select select name="dname" id="select" onchange="javascript:if(document.budget.dname.value==''){alert('Select Any Department');}  {location.href='./ViewDistforWorkAction?deptname='+document.budget.dname.value;}">
				<c:choose>
				 <c:when test="${requestScope.departmentname ne null}">
				   <option value="${requestScope.departmentname}">${requestScope.departmentname}</option>
				 </c:when>
				 <c:otherwise>
				   <option value="" >--LIST OF DEPARTMENTS--</option>
				   <c:if test="${not empty deptart}">
				<c:forEach var="depart" items="${deptart}">
				<option value="${depart.deptname}" >								
				${depart.deptname}
				</option>
				</c:forEach>
				</c:if>
				 </c:otherwise>
				</c:choose>	
							
			
				</select>
        </td>
     </tr>
     <tr><td><b>District Name</b></td><td> 
				<select name="dname1" id="select" onchange="javascript:if(document.budget.dname1.value==''){alert('Select Any Department');}  {var deptname=document.getElementById('dname').value;var dist=document.getElementById('dname1').value;location.href='./ViewWorkDetailsforCitizenAction?distname='+dist+'&deptname='+deptname}">
				<c:choose>
				 <c:when test="${requestScope.district ne null}">
				   <option value="${requestScope.district}">${requestScope.district}</option>
				 </c:when>
				 <c:otherwise>
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty deptart}">
				<c:forEach var="depart" items="${deptart}">
				<option value="${depart.district}">								
				${depart.district}
				</option>
				</c:forEach>
				</c:if>
				 </c:otherwise>
				</c:choose>	
							
			
				</select>
				</td></tr>
    
  
    </table>
 <br/><br/>
    </form>
    
     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
