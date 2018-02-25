<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js" %>type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="/js/ts_picker.js"></script>
<script language="JavaScript1.1" src="/js/pass.js">


</script> <script type="text/javascript" src="js/image.js"> </script>
 <script type="text/javascript" src="js/general.js"> </script>
 <script type="text/javascript" src="js/adi.js"> </script>
 <script type="text/javascript" src="js/form_validation.js"> </script>
<script language="JavaScript" src="js/javascripts.js"></script>
		<script language="JavaScript" src="js/pop-closeup.js"></script>
		
		

<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
	<script language="JavaScript" type="text/javascript"
		src="<%=request.getContextPath()+"/js/ts_picker.js"%>"></script>
<script>
//var x_win = window.self; 

function goOn() {

var dName=document.register.dname.value;
var userName=document.register.userName.value;
window.location.href="<%=request.getContextPath()%>/DeptChekUserAction?userName="+userName+"&deptname="+dName;

} 
</script>

		
		
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
		<body>
		 <jsp:include page="header.jsp"></jsp:include>
		   <h3><div align="center"><span class=subHead> Department Officer Register Form </span></div></h3>
<form action="./DeptOfficerRegistrationAction" method="post" name="register" onSubmit="return validate()">
 <!--<table border="1"><tr><td></td></tr></table>-->

 
 <table align="left" width=90% bgcolor="#278384">
<th colspan="6" bgcolor="#asHblue"><span class=Title>Account Details</span></th>
<tr></tr><tr></tr>

<tr>
					<td><pre><span class=Title>    Department</span></pre></td>
					<td width="276">
						<select name="dname" id="select" >
				<c:choose>
				 <c:when test="${requestScope.departmentname ne null}">
				   <option value="${requestScope.departmentname}">${requestScope.departmentname}</option>
				 </c:when>
				 <c:otherwise>
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty deptart}">
				<c:forEach var="depart" items="${deptart}">
				<option value="${depart.deptname}">								
				${depart.deptname}
				</option>
				</c:forEach>
				</c:if>
				 </c:otherwise>
				</c:choose>	

</tr>
 <tr>
    <td><pre><span class=Title>    User Name</span></pre></td>
    <td width="303"><input type="text" name="userName" value="<%if(request.getParameter("userName")!=null)out.print(request.getParameter("userName")); %>" size="20" onBlur="goOn()"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
 
				<font color="red">
				
				${requestScope.status }
				
				</font>
				</td>
			
			<td>
			<center>
   <font color="green">
		
                          </font>
                           </center>
                           </td>
    
    <td> <table align="center"> <tr><td border="0" align="left" rowspan="5" colspan='2'>


						<img alt="See Photo Here" id="previewField" src="images/1.jpg"
							height="150" width="120" />

					</td></tr></table></td>
</tr>

<tr>
 <td><pre><span class=Title>    PassWord</span></pre></td>
  <td>
    
        <input type="password" name="password"  onkeyup="testPassword(document.forms.register.password.value);" onChange="Encrypt(document.forms.register.password.value);"></td></tr>
        <tr><td></td><td>
     <span class=Title><a id="Words"><br></a></td>
      <td><table cellpadding=0 cellspacing=0><tr><td height=15  bgcolor=#dddddd></td></tr></table></td>
</tr>
<tr>
    <td><pre><span class=Title>    Confirm</span><pre></td>
    <td><input type="password" name="conformpassword" value="" size="20" onBlur="checkconformpassword();"/></td>
</tr>
<tr>
    <td><pre><span class=Title>    SecurityQuestion</span></pre></td>
    <td><select name="squest">
      <option value="select" selected="true"><font size="3" face="Verdana">--Select One---</font></option>
      <option value="What is your favorite pastime?"><font size="3" face="Verdana">What is your favorite pastime?</font></option>
      <option value="Who your childhood hero?"><font size="3" face="Verdana">Who your childhood hero?</font></option>
      <option value="What is the name of your first school?"><font size="3" face="Verdana">What is the name of your first school?</font></option>
     
      <option value="What is your pet name?"><font size="3" face="Verdana">What is your pet name?</font></option>
    </select></td>
</tr>
 
<tr>
    <td><pre><span class=Title>    Security Answer</span></pre></td>
    <td><input type="text" name="secrete" value="" size="20"/></td>
</tr>
<tr>
    <td><pre><span class=Title>    Role</span></pre></td>
    <td><input type="text" name="role" value="deptoff" readonly="readonly" size="20"/></td>
</tr>


<tr>
    <td><pre><span class=Title>    Email</span></pre></td>
    <td width="276"><input type="text" name="email" value=""></td>
  </tr>

<tr></tr><tr></tr>
  <th colspan="6" bgcolor="#asHblue"><span class=Title>Personal Details</span>  </th>
  <tr></tr><tr></tr>
  <tr>
    <td><pre><span class=Title>    First Name</span></pre></td>
    <td width="276"><input type="text" name="firstName" value=""></td>
  </tr>
<tr>
    <td width="139"><pre><span class=Title>    Last Name</span></pre></td>
    <td width="276">
      <input type="text" name="lastName" value="" size="20"/>
    </td>
  </tr>
  <tr>
    <td width="139"><pre><span class=Title>    Gender</span></pre></td>
    <td width="276">
      <select name="gender">
							<option value="select" selected="true">
								<font size="3" face="Verdana">--Select--</font>
							</option>
							<option value="Male">
								<font size="3" face="Verdana">Male</font>
							</option>
							<option value="Female">
								<font size="3" face="Verdana">Female</font>
							</option>
						</select>
      </td>
     </tr>
     <tr>
    <td><pre><span class=Title>    Birth Date</span></pre></td>
    <td>
   <input type="text" name="dob" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.register.dob', document.register.dob.value);"> <img src="<%=request.getContextPath()+"/images/cal.gif"%>" alt="a" width="18" height="18" border="0"/></a>    </td>
  </tr>
    <tr>
    <td><pre><span class=Title>    Browse Photo</span></pre></td>
    <td><input type="file" name="photo" class="textfield" onChange="preview(this)" /></td>
  </tr>
  <tr></tr><tr></tr>
<th colspan="6" bgcolor="#asHblue"><center><span class=Title>Contact Details</span>
</center></th>
<tr></tr><tr></tr>

<tr>
    <td><pre><span class=Title>    House No</span></pre></td>
    <td><input type="text" name="houseNo" value="" size="20"/></td>
</tr>
<tr>
    <td><pre><span class=Title>    Street</span></pre></td>
    <td><input type="text" name="street" value="" size="20"/></td>
</tr>



<tr>
    <td width="120"><pre><span class=Title>   City</span></pre></td>
    <td width="273">
      <input type="text" name="city" value="" size="20"/>
    </td>
  </tr>
  
  <tr>
    <td width="120"><pre><span class=Title>   District</span></pre></td>
    <td width="273">
      <input type="text" name="district" value="" size="20"/>
    </td>
  </tr>
  <tr>
    <td><pre><span class=Title>   State</span></pre></td>
    <td>
      <input type="text" name="state" value="" size="20"/>
    </td>
  </tr>
  <tr>
    <td><pre><span class=Title>   Country</span></pre></td>
    <td>
      <input type="text" name="country" value="" size="20"/>
   </td>
  </tr>
  
  <tr>
    <td><pre><span class=Title>   Pin</span></pre></td>
    <td>
      <input type="text" name="pin" value="" size="20" onChange="showStatus()"/>
    </td>
  </tr>
  <tr>
    <td><pre><span class=Title>    Phone No</span></pre></td>
    <td><input type="text" name="phoneNo" value="" size="20" onBlur="ValidateForm()"/></td>
</tr>
  
<th colspan="5">&nbsp;</th>
<tr></tr><tr></tr>

<tr><td></td>
    <td align="center"><font size="3" face="Verdana">
    <pre>                   <input type="submit" name="register" value="Register"/>&nbsp;  <input type="reset" name="cancel" value="Clear"/>
   </pre> </font></td>
    <td align="center"></td>
</tr>
</table>
 <p><br/>
     <br/>
   <br/>
   </p>
 <p>&nbsp;</p>
 <p>&nbsp;</p>
 <p>&nbsp;</p>
 <p><br/>
      </p>
 
</form>

<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
  
  frmvalidator.addValidation("userName","req","Please enter your Username");
   frmvalidator.addValidation("password","req","Please enter your Password");
   frmvalidator.addValidation("conformpassword","req","Please enter your Confirm Password");
   frmvalidator.addValidation("secrete","req","Please enter your Answer");
    frmvalidator.addValidation("squest","dontselect=0");
     frmvalidator.addValidation("email","maxlen=50");
  frmvalidator.addValidation("email","req");
  frmvalidator.addValidation("email","email");
  frmvalidator.addValidation("firstName","req","Please enter your First Name");
  frmvalidator.addValidation("firstName","maxlen=30",	"Max length for FirstName is 30");
  frmvalidator.addValidation("firstName","alpha"," First Name Alphabetic chars only");
  
  frmvalidator.addValidation("lastName","req","Please enter your Last Name");
  frmvalidator.addValidation("lastName","maxlen=20","Max length is 20");
  frmvalidator.addValidation("lastName","alpha"," Last Name Alphabetic chars only");
  
   frmvalidator.addValidation("gender","dontselect=0");
   frmvalidator.addValidation("dob","req","Please enter your DOB"); 
  
   frmvalidator.addValidation("photo","req","Please Load Your Photo"); 
  
 
   
  
  
   
   frmvalidator.addValidation("houseNo","req","Please enter your House Number");
   
   frmvalidator.addValidation("street","req","Please enter your Street Number");
     
  
   frmvalidator.addValidation("city","req","Please enter your city Name");
    frmvalidator.addValidation("district","req","Please enter your District Name");
   frmvalidator.addValidation("state","req","Please enter your State Name");
   frmvalidator.addValidation("country","req","Please enter your Country Name");
   frmvalidator.addValidation("pin","req","Please enter your pin Number");
    frmvalidator.addValidation("phoneNo","req");
  
  frmvalidator.addValidation("phoneNo","maxlen=50");
  frmvalidator.addValidation("phoneNo","numeric");
 frmvalidator.addValidation("phoneNo","Phone");
   
  
  
  
   
    
 </script>
 											



	</body>
</html>
