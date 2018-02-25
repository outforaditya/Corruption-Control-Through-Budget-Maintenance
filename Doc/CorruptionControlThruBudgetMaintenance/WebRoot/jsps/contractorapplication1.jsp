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
    
    <title>My JSP 'viewdeptbudget.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
   <caption>Contracor's Willing</caption>
     <tr bgcolor="#adede"><i></i></tr>
     <br/><br/>
     
   
   
   <c:if test="${not empty trans}">
   <c:forEach var="officer" items="${trans}">
   
    <tr>
   
    <td>Contractor Name</td><td>${officer.contractorname}</td></tr>
    <tr><td>Interest In</td><td>${officer.intrest}</td></tr>
    <tr><td>WorkName</td><td>${officer.workname}</td></tr>
   <tr><td>Department</td ><td>${officer.deptname}</td></tr>
    <tr><td>District</td><td>${officer.district}</td></tr>
    <c:choose>
        <c:when test="${requestScope.flag} eq 'no'">
   <tr> <td>Accept Contractor</td><td>  <a href="<%=request.getContextPath()+"/AcceptContractorAction"%>?cid=${officer.contractorid}"><b>Accept</b></a></td></tr>
    <tr><td>Reject Contractor</td><td>  <a href="./jsps/distcohome.jsp?cid=${officer.contractorid}&status="Contractorship Rejected""><b>Reject</b></a></td></tr>
    <tr><td></td><td> </td>
    </c:when>
    <c:otherwise>
        
        <c:when test="${requestScope.flag} eq 'yes'">
   <tr> <td></td><td>Accepted Contractor</td></tr>  
    <tr><td></td><td> </td>
    </c:when>
        
     </c:otherwise></c:choose>
   </c:forEach>
   </c:if>
   
    </table>
    <br/><br/>
    
    
  
    <jsp:include page="footer.jsp"/>
  </body>
</html>
