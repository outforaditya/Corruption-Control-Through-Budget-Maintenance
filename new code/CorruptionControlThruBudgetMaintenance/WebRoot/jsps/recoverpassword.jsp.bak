<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'recoverpassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
		<style type="text/css">
.Title {
font-family:Verdana;
font-weight:bold;
font-size:8pt
}
.Title1 {font-family:Verdana;
font-weight:bold;
font-size:8pt
}
        </style>
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

	
  
  
  
                      <br>
		<form  action="<%=request.getContextPath()+"/RecoverPasswordAction"%>" method="post" name="register">
			<table border="0" align="center" bgcolor="white" width=80%>

				<tr>
					<td>
						<table border="0" align="center">
                      <center><h3><strong>ForgotPassword Form </strong></h3></center>
							<tr>
								<td align="right"></td>
								<td>
									<table border="0" align="center">
										<tr>
											<td><span class=Title>
												Login Name</span>
											</td>
											<td>
												<input type=text name="username" value=""/>
											</td>
										</tr>
										<tr>
											<td><span class=Title>
												Secret Question</span>
											</td>
											<TD><span class=Title>
												<select name="squest">
      
      <option value="select" selected="true"><font size="3" face="Verdana">--Select One---</font></option>
      <option value="What is your favorite pastime?"><font size="3" face="Verdana">What is your favorite pastime?</font></option>
      <option value="Who your childhood hero?"><font size="3" face="Verdana">Who your childhood hero?</font></option>
      <option value="What is the name of your first school?"><font size="3" face="Verdana">What is the name of your first school?</font></option>
    </select>
										</span>	</TD>
										</tr>
										
										<tr>
											<td><span class=Title>
												Secret Answer</span>
											</td>
											<td>
												<input type=text name="sanswer" />
											</td>
										</tr>
										<tr>
											<td colspan="2"><span class=Title>
												<div align="center">
													<input type=submit value="Recover"/>
													&nbsp;
													<input type=reset value="Clear"/>
												</div></span>
											</td>
										</tr>
									</table>
								</td>
								<td>&nbsp;
									
							  </td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		
      </form>
      
      <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");

        frmvalidator.addValidation("username","req","Loginname is required");
    frmvalidator.addValidation("username","alpha","Loginname is Only Characters");
    frmvalidator.addValidation("squest","req","Security Question is required");
    frmvalidator.addValidation("sanswer","req","Answer is required");

     </script>
      <jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
