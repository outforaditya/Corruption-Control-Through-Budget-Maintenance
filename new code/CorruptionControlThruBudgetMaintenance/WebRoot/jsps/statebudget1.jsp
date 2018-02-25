
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
					+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript"></script>
		
		
		


	</head>

	<body >

		<jsp:include page="header.jsp"></jsp:include>


		<center>
			<b> <h4>
					Budget Entry Form
				</h4>
			</b>
		</center>



		<form action="<%=request.getContextPath() + "/AddStateBudgetAction"%>"
			name="village">


			<table cellspacing=2 align="center" bgcolor="#CEF6CE" width="325"
				height="60">

				<tr>
					<td>
						<b>DepartmentName</b>
					</td>
					<td>
						<select name="sname" id="select"
							onchange="javascript:if(document.village.sname.value==''){alert('Select Any Department');} else{ location.href='./ViewSubDepartmentAction?sname='+document.village.sname.value;}">
							<c:choose>
								<c:when test="${requestScope.statename ne null}">
									<option value="${requestScope.statename}">
										${requestScope.statename}
									</option>
								</c:when>
								<c:otherwise>
									<option value="">
										--SELECT--
									</option>
									<c:if test="${not empty villstate}">
										<c:forEach var="State" items="${villstate}">
											<option value="${State.sname}">
												${State.sname}
											</option>
										</c:forEach>
									</c:if>
								</c:otherwise>
							</c:choose>


						</select>
						<input type="hidden" value="${requestScope.statename }"
							name="stname">
				<tr>
					<td>
						<b>DistrictName</b>
					</td>
					<td>
						<select name="dname" id="select">
							<c:choose>
								<c:when test="${requestScope.districtname ne null}">
									<option value="${requestScope.districtname}">
										${requestScope.districtname}
									</option>
								</c:when>
								<c:otherwise>
									<option value="">
										--SELECT--
									</option>
								</c:otherwise>
							</c:choose>



							<c:if test="${not empty distmandal}">
								<c:forEach var="State" items="${distmandal}">
									<option value="${State.dname}">
										${State.dname}
									</option>
								</c:forEach>
							</c:if>



						</select>
				<tr>
					<td>
						<b>VillageName</b>
					</td>
					<td>
						<input type=text name="vname" />
					</td>
				</tr>
				<tr>
					<td>
						<input type=submit value=AddVillage>
					</td>
					<td>
						<input type=submit value=Clear>
					</td>
				</tr>
			</table>
		</form>

		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("village");

  frmvalidator.addValidation("vname","req","Village Name is required");
    frmvalidator.addValidation("vname","alpha","Village Name is Only Characters");

  </script>
		<br />
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
