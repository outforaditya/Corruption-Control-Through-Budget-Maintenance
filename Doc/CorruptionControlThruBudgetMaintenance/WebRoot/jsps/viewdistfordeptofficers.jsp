
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
  <html>
  <head>
  
  <script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
			
			
			
			
			
		
		
	
	
	
  <script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>


</head>
  
  <body onload="javascript:disableBackButton()">
 
  <jsp:include page="header.jsp"></jsp:include>
 
 
  <center><b><h2>Districts</h2></b></center>
  
  
	
		<form action="" name="budget">
		
		
		<table cellspacing=2 align="center" bgcolor="#CEF6CE" width="325" height="60">
		
				<tr><td><b>District Name</b></td><td> 
				<select name="dname" id="select" onchange="javascript:if(document.budget.dname.value==''){alert('Select Any Department');} {location.href='./ViewDistOffAction?dist='+document.budget.dname.value;}">
				<c:choose>
				 <c:when test="${requestScope.dept ne null}">
				   <option value="${requestScope.dept}">${requestScope.dept}</option>
				 </c:when>
				 <c:otherwise>
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty deptofficers}">
				<c:forEach var="depart" items="${deptofficers}">
				<option value="${depart.district}">								
				${depart.district}
				</option>
				</c:forEach>
				</c:if>
				 </c:otherwise>
				</c:choose>	
							
			
				</select>
				
	    </table>
   </form>
   
  
  <br/>
     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
