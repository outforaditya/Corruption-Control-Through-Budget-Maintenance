<html>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/mm_menu.js"></script>
<%-- <script language="" src="js/mm_menu.js"></script> --%>
<link rel="stylesheet" href="../css/menu.css" type="text/css"></link>

<body>
 <jsp:include page="header.jsp"></jsp:include>
   
<form action="./ContractorAction" method="post" name="fr">

      

    <table cellspacing="10" cellpadding="10" align="center" border="1" bgcolor="#408080">
    <thead align="Right" style="color: Blue"> Request to get Contractorship and related information</thead>
    <tr>
					<td>    WorkName</td>
					<td width="276">
						<select name="workname" id="select" >
				    
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty trans}">
				  <c:forEach var="depart" items="${trans}">
				  <option value="${depart.workname}">								
				  ${depart.workname}
				  </option>
				  </c:forEach>
				  </c:if>
				 
				

</tr>
 <tr>
					<td>    Department Name</td>
					<td width="276">
						<select name="dept" id="select" >
				    
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty trans}">
				  <c:forEach var="depart" items="${trans}">
				  <option value="${depart.deptname}">								
				  ${depart.deptname}
				  </option>
				  </c:forEach>
				  </c:if>
				 
				

</tr>
<!-- 
 <tr>
					<td>   Notification Close Date</td>
					<td width="276">
						<select name="closedate" id="select" >
				    
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty trans}">
				  <c:forEach var="depart" items="${trans}">
				  <option value="${depart.lastdate}">								
				  ${depart.lastdate}
				  </option>
				  </c:forEach>
				  </c:if>
				 
				

</tr>
 <tr>
					<td>    Work Target Date</td>
					<td width="276">
						<select name="target" id="select" >
				    
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty trans}">
				  <c:forEach var="depart" items="${trans}">
				  <option value="${depart.targetdate}">								
				  ${depart.targetdate}
				  </option>
				  </c:forEach>
				  </c:if>
				 
				

</tr>
 -->
 <tr>
					<td>    District Name</td>
					<td width="276">
						<select name="dist" id="select" >
				    
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty trans}">
				  <c:forEach var="depart" items="${trans}">
				  <option value="${depart.district}">								
				  ${depart.district}
				  </option>
				  </c:forEach>
				  </c:if>
				 
				

</tr>

   
    <tr><td>User Name:</td><td><input type="text" name="username"></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password"></td></tr>
    <tr><td>Contractor Name:</td><td><input type="text" name="name"></td></tr>
     <tr><td>Intrest in</td><td><textarea name="ta" ></textarea></td></tr>
    <tr><td align="right"><input type="submit" value="submit"></td><td><input type="reset" value="reset"></td></tr>
    <tr><td></td></tr>
    </table>
    </form>
 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>                      