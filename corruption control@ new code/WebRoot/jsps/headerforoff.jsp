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
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="border-bottom-color:red;">
    <table align="center" cellpadding="" cellspacing="" border="">
			<tr>
				<td colspan="1" width="900" height="100" valign="top"><img src="<%=request.getContextPath()+"/images/govt.jpg" %>" align="left" height="100" width="100"/></td><td><img src="<%=request.getContextPath()+"/images/asmbly.jpg" %>" align="middle" height="100" width="400"/></td>
			</tr>
			</table>
			<table align="center">
			<tr>
				<td colspan="1" width="1200" height="30"><center><font color="blue" size="6"><b>Budget Maintenance and </b></font><font color="blue" size="6"><b>Monitoring System</b></font></center></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="1" ><img src=<%=request.getContextPath()+"/images/11.jpg" %> height="12" width="900"/></td>
			</tr>
		</table>	
		
		</div>
		
          <table width="1000">
		
   				<c:choose>
   				<c:when test="${sessionScope.role eq 'admin'}">
   				<jsp:include page="./adminmenu.jsp"/>
   				</c:when>
   		        
   				
   				<c:when test="${sessionScope.role eq 'deptoff'}">
   				<jsp:include page="./deptofficermenu.jsp"/>
   				</c:when>
   				
			    			
				
   				<c:when test="${sessionScope.role eq 'distco'}">
   				<jsp:include page="./distcomenu.jsp"/>
   				</c:when>
   				
   				
   
								<c:otherwise>
						<jsp:include page="./menubeforelogin.jsp"/>
					</c:otherwise>
					</c:choose>
		</table>
		
		<br/><br/>
		
		 <center>
   <font color="red"><b>
		 <c:if test="${requestScope.status!='null'}">
					 
                          <c:out value="${requestScope.status}"></c:out> 
                          </c:if>
                          </b>
                          </font>
                         
                           </center>
  </body>
</html>
