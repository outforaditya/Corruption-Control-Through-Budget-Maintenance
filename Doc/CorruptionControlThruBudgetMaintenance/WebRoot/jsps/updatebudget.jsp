<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

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


		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/js/gen_validatorv31.js"%>type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript"
			src="/js/ts_picker.js"></script>
		<script language="JavaScript1.1" src="/js/pass.js">


</script>
		<script type="text/javascript" src="js/image.js"> </script>
		<script type="text/javascript" src="js/general.js"> </script>
		<script type="text/javascript" src="js/adi.js"> </script>
		<script type="text/javascript" src="js/form_validation.js"> </script>
		<script language="JavaScript" src="js/javascripts.js"></script>
		<script language="JavaScript" src="js/pop-closeup.js"></script>



		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/js/gen_validatorv31.js"%>"
			type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript"
			src="<%=request.getContextPath() + "/js/ts_picker.js"%>"></script>
		<script>
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>


	</head>
	<body onload="javascript:disableBackButton()">
		<jsp:include page="header.jsp"></jsp:include>
		<br />
		<form action="./UpdateBudgetAction" method="post" name="frm">
			<table align="center" border="1" bgcolor="#A1B2C3" width="70%"
				cellpadding="10">
				<caption>
					<h3>
						Update Budget
					</h3>
				</caption>
				<tr bgcolor="#adede">
					<i></i>
				</tr>
				<br />
				<br />

        
       
				





						<tr>
							<td>
								Department Name
							</td>
							<td>
								<input type="text" name="dept" readonly="readonly" value="<%=request.getParameter("dept") %>">
							</td>
						</tr>
						<tr>
							<td>
								SubDepartment Name
							</td>
							<td>
								<input type="text" name="subdept" readonly="readonly" value="<%=request.getParameter("subdept") %>"
									size="20" />
								
							</td>
						</tr>
						
						<tr>
							<td>
								 Amount
							</td>
							<td>
								<input type="text" name="amt"  value="<%=request.getParameter("amt") %>">
							</td>
						</tr>
						<tr>
							<td>
								Year
							</td>
							<td>
								<input type="text" name="year"  value="<%=request.getParameter("year") %>">
							</td>
						</tr>

						<tr>
							
							<td align="center">
								<input type="submit" value="Update">
							</td><td><input type="reset" value="Clear"></td>
						</tr>
					

			</table>
		</form>
		<br />
		<br />



		<jsp:include page="footer.jsp" />
	</body>
</html>
