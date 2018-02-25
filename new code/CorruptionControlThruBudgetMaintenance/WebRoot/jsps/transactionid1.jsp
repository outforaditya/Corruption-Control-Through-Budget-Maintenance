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
    
    <title>My JSP 'transactionid.jsp' starting page</title>
    
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
  <jsp:include page="header1.jsp"/>
     <center>
     <table>
     <th bgcolor="#FF8C00">Transaction Password </th>
     </br></br></br></br>
     <tr><td>Note: Please Remember it to get Budget amount</td></tr>
    <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr>
    <td align="center" bgcolor="#008000"><font color="aqua"><b>
		                   <c:if test="${requestScope.trans!='null'}">
					 
                          <c:out value="${requestScope.trans}"></c:out> 
                          </c:if>
                          </b>
                          </font></td></tr><tr><td></td></tr>
   
                             </table>
                         
                         
                         
                           </center>
                          
                           
                           
                           <jsp:include page="footer.jsp"/>
  </body>
</html>

