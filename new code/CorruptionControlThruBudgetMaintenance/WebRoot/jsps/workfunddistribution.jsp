<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath() + "/js/gen_validatorv31.js"%>"
			type="text/javascript">
</script>
		<script language="JavaScript" type="text/javascript"
			src="<%=request.getContextPath() + "/js/ts_picker.js"%>">
</script>
		<script type="text/javascript">
function validateForm() {
	var x = parseInt(document.frm.availbal.value);
	var y = parseInt(document.frm.amount.value);
	var year = parseInt(document.frm.year.value);
	var bal = x - y;

	if (x <= 0 || x == 0 || y == 0) {
		alert("Insufficent Budget Amount ");
		return false;
	} else if (bal < 0) {
		alert("Insufficent Budget Amount ");
		return false;
	} else if (year <= 2011 || year == 'NaN') {
		alert("Enter Correct year ");
		return false;
	}

}
</script>

		<script type="text/javascript">
function disableBackButton() {
	window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>


	</head>

	<body onload="javascript:disableBackButton()">
		<jsp:include page="header.jsp"></jsp:include>
		<br />
		<form action="./InsertWorkBudgetAction" name="frm">

			<table align="center" border="1" bgcolor="" width="70%"
				cellpadding="10">
				<caption>
					District Budget
				</caption>
				<tr bgcolor="#adede">
					<i></i>
				</tr>
				<br />
				<br />
				<tr>
					<th bgcolor="lightgreen">
						<b>Department</b>
					</th>
					<th bgcolor="lightgreen">
						<b>Subdepartment</b>
					</th>
					<th bgcolor="lightgreen">
						<b>District</b>
					</th>
					<th bgcolor="lightgreen">
						<b>DistributedBy</b>
					</th>
					<th bgcolor="lightgreen">
						<b>BudgetDate</b>
					</th>
					<th bgcolor="lightgreen">
						<b> Relesed Amount (In lacks)</b>
					</th>
					<th bgcolor="lightgreen">
						<b>Availble Amount(In Lacks)</b>
					</th>
					<th bgcolor="lightgreen">
						<b>Financial year</b>
					</th>
				</tr>
				<%
					String d = request.getParameter("distbudgetid");
				%>


				<input type='hidden' name='distbudgetid' value='<%=d%>'>


				<c:if test="${not empty distbudget}">
					<c:forEach var="officer" items="${distbudget}">



						<tr>

							<td>
								${officer.deptname}
							</td>
							<td>
								${officer.subdeptname}
							</td>
							<td>
								${officer.district}
							</td>
							<td>
								${officer.distributedby}
							</td>
							<td>
								${officer.budgetdate}
							</td>
							<td>
								${officer.amount}
								<input type='hidden' name='amt' value='${officer.amount}'>
							</td>
							<td>
								${officer.balamt}
								<input type='hidden' name='availbal' value='${officer.balamt}'>
							</td>
							<td>
								${officer.year}
							</td>



						</tr>
						<c:set var="distbudgetid" value="${officer.distbudgetid}"
							scope="request" />
					</c:forEach>
				</c:if>

			</table>
			<br />
			<br />
			<table align="center" width=90% bgcolor="#019283">
				<th colspan="6" bgcolor="#asHblue">
					Budget disrtibution for work
				</th>
				<tr></tr>

				<tr>
					<td>
						Work Name
					</td>
					<td>
						<input type="text" name="workname" value="">
					</td>
				</tr>
				<tr>
					<td>
						Amount [In lakhs]
					</td>
					<td>
						<input type="text" name="amount" value="">
					</td>
				</tr>
				<tr>
					<td>
						Financial Year
					</td>
					<td>
						<input type="text" name="year" value="">
					</td>
				</tr>
				<tr>
					<td>
						Fund Distributed by
					</td>
					<td>
						<input type="text" name="name" value="">
					</td>
				</tr>
				<tr>
					<td>
						Notification Close Date
					</td>
					<td>
						<input type="text" name="dob" value="" size="20" />
						<a
							href="javascript:show_calendar('document.frm.dob', document.frm.dob.value);">
							<img src="./images/cal.gif" alt="a" width="18" height="18"
								border="0" /> </a>
					</td>
				</tr>
				<tr>
					<td>
						Work Target Date
					</td>
					<td>
						<input type="text" name="dob1" value="" size="20" />
						<a
							href="javascript:show_calendar('document.frm.dob1', document.frm.dob1.value);">
							<img src="./images/cal.gif" alt="a" width="18" height="18"
								border="0" /> </a>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="submit"
							onclick="javascript:return validateForm()">
					</td>
					<td>
						<input type="reset" value="Clear"
							onclick="javascript:return validateForm1()">
					</td>
				</tr>
			</table>
		</form>

		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("frm");

frmvalidator.addValidation("workname", "req", "Please Enter Work name");
frmvalidator.addValidation("amount", "req", "Enter Amount");
frmvalidator.addValidation("year", "req", "Enter year");
frmvalidator.addValidation("name", "req", "Please Enter  name");
frmvalidator.addValidation("dob", "req", "Enter Notification Date");
frmvalidator.addValidation("dob1", "req", "Enter Target Date");
</script>
		<br />
		<br />
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
