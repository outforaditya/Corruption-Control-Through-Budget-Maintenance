<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'citizenhome.jsp' starting page</title>
    
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

    <jsp:include page="header.jsp"></jsp:include>
		<br/><br/><br/>
		
		<marquee><h2><i><font color="purple">Welcome to Citizen  </font> 
		</i>
		</h2></marquee>
		<br/>
		<table align="center" bgcolor="">
			<tr>
				<td colspan="1" width="50" height="" valign="top"><img src="<%=request.getContextPath()+"/images/8a.jpg"%>" align="top" height="200" width="300"/></td>
			</tr>
			</table>
		
	     <br/><br/>
			
                <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
