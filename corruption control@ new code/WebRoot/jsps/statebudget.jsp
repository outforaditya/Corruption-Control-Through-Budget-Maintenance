
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
 
 
  <center><b><h4>Budget Entry Form</h4></b></center>
  
  
	
		<form action="<%=request.getContextPath()+"/AddStateBudgetAction"%>" name="budget">
		
		
		<table cellspacing=2 align="center" bgcolor="#CEF6CE" width="325" height="60">
		
				<tr><td><b>DepartmentName</b></td><td> 
				<select name="dname" id="select" onchange="javascript:if(document.budget.dname.value==''){alert('Select Any Department');}  {location.href='./ViewSubDepartmentAction?deptname='+document.budget.dname.value;}">
				<c:choose>
				 <c:when test="${requestScope.departmentname ne null}">
				   <option value="${requestScope.departmentname}">${requestScope.departmentname}</option>
				 </c:when>
				 <c:otherwise>
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty deptart}">
				<c:forEach var="depart" items="${deptart}">
				<option value="${depart.deptname}">								
				${depart.deptname}
				</option>
				</c:forEach>
				</c:if>
				 </c:otherwise>
				</c:choose>	
							
			
				</select>
				<input type="hidden" value="${requestScope.departmentname }" name="departmentname">
				<tr><td><b>SubDepartmentName</b></td><td> <select name="subdeptname" id="select"">
				<c:choose>
				 <c:when test="${requestScope.subdeptname ne null}">
				   <option value="${requestScope.subdeptname}">${requestScope.subdeptname}</option>
				 </c:when>
				 <c:otherwise>
				   <option value="">--SELECT--</option>
				   
				 </c:otherwise>
				</c:choose>	
	
				<c:if test="${not empty subdeptart}">
				<c:forEach var="sub" items="${subdeptart}">
				<option value="${sub.subdeptname}">
				${sub.subdeptname}
				</option>
				</c:forEach>
				</c:if>
				
				
				
				</select>
				
				</td></tr>
				
				
				<tr><td><b> Budget Amount ( Lakhs)</b></td><td> <input type=text name="amount" /></td></tr>
				<tr><td><b> Financial Year </b></td><td> <input type=text name="year" /></td></tr>
				<tr><td></td><td><input type=submit value=Submit></td></tr>
	    </table>
   </form>
   
   <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("budget");

  frmvalidator.addValidation("dname","req","Select Dept");
    frmvalidator.addValidation("subdeptname","req","Select Sub Dept");
    frmvalidator.addValidation("amount","req","Amount required");
    frmvalidator.addValidation("amount","numeric","Only Numeric");
     frmvalidator.addValidation("year","req","Enter year");
    frmvalidator.addValidation("year","numeric","Only Numeric");

  </script>
  <br/>
     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
