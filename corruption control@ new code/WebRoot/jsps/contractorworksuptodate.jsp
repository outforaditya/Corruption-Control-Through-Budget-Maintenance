<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<jsp:include page="header1.jsp"></jsp:include>
		<br />
		<form action="./UpdateContractorWorkAction" method="post" name="frm">
			<table align="center" border="1" bgcolor="#A1B2C3" width="70%"
				cellpadding="10">
				<caption>
					<h3>
						Update Work Information
					</h3>
				</caption>
				<tr bgcolor="#adede">
					<i></i>
				</tr>
				<br />
				<br />



				<c:if test="${not empty trans}">
					<c:forEach var="officer" items="${trans}">





						<tr>
							<td>
								Number of Workers
							</td>
							<td>
								<input type="text" name="number" value="${officer.noofworkers}">
							</td>
						</tr>
						<tr>
							<td>
								Work Start Date
							</td>
							<td>
								<input type="text" name="dob" value="${officer.startdate}"
									size="20" />
								<a
									href="javascript:show_calendar('document.frm.dob', document.frm.dob.value);">
									<img src="<%=request.getContextPath()
									+ "/images/cal.gif"%>"
										alt="a" width="18" height="18" border="0" />
								</a>
							</td>
						</tr>
						<tr>
							<td>
								End date
							</td>
							<td>
								<input type="text" name="dob1" value="${officer.targetdate}"
									size="20"/>
								<a
									href="javascript:show_calendar('document.frm.dob1', document.frm.dob1.value);">
									<img src="<%=request.getContextPath()
									+ "/images/cal.gif"%>"
										alt="a" width="18" height="18" border="0" />
								</a>
							</td>
						</tr>
						<tr>
							<td>
								Released Amount
							</td>
							<td>
								<input type="text" name="amount" value="${officer.amount}" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td>
								Amount Spent
							</td>
							<td>
								<input type="text" name="spent" value="${officer.spentamount}">
							</td>
						</tr>

						<tr>
							<td width="139">
								<span class=Title> Work Status</span>
							</td>
							<td width="276">
								<select name="status">
									<option value="select" selected="true">
										<font size="3" face="Verdana">--Select--</font>
									</option>
									<option value="Starting">
										<font size="3" face="Verdana">Staring</font>
									</option>
									<option value="goingon">
										<font size="3" face="Verdana">Work in progress</font>
									</option>
									<option value="Finished">
										<font size="3" face="Verdana">Finished</font>
									</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<span class=Title> Browse Work Photo</span>
							</td>
							<td>

								<input type="hidden" name="photo" value="${officer.photo}" />
								<input type="file" name="photo1" class="textfield"
									value="${officer.photo}" onChange="preview(this)" />

							</td>

							<td border="0" align="left" rowspan="5" colspan='2'>


								<img alt="See Photo Here" id="previewField"
									src="${officer.photo}" height="150" width="120" />

							</td>
						</tr>

						<tr>
							<td></td>
							<td align="center">
								<input type="submit" value="Update">
							</td>
						</tr>
					</c:forEach>
				</c:if>

			</table>
		</form>
		<br />
		<br />



		<jsp:include page="footer.jsp" />
	</body>
</html>
