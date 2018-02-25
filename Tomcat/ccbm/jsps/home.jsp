<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" src="scripts/moveclock.js"></script>
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
    
    <jsp:include page="header.jsp"></jsp:include>
		<br/>
		
		<marquee><h2><i><font color="purple">Welcome </font> 
		</i>
		</h2></marquee>
		<br/>
		<table align="center" bgcolor="" bordercolor="#105678">
			<tr>
				<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td colspan="1" width="50" height="" valign="top" align="right"><img src="<%=request.getContextPath()+"/images/10~~.jpg"%>" align="top" height="150" width="400"/></td>
		        <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
		        
		        <td bgcolor="" colspan="" width="" height=""  align="right">
		        		 
		         </td>	
			</tr>
			</table>
			 <br/><br/> <br/><br/> 
			<table align="center" border="11">
		        <td bgcolor="#CFECEC">
                          <pre> Contractors Required.If u r </pre>
                           <pre>new one, Please login Through  </pre> 
                           <pre>following link</pre>
                         
                     
                           <center> <a href="./jsps/registrationform.jsp">ClickHere</a></center>
                           </td>
                    </table>
		   
	     <br/><br/>
			
                <jsp:include page="footer.jsp"></jsp:include>
		</body>
  
</html>
