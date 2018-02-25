
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>
	<script language="javascript" src="scripts/moveclock.js"></script>
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

 <jsp:include page="headercitizen.jsp"></jsp:include>
      
        <form action="<%=request.getContextPath()+"/LoginAction1"%>" method=post name="login">
        <table  border="0" align="center"  bgcolor="lightyellow" width="80%">
               <tr>
                 <td height="120" align="right"></td>
                 <td><table border="0" align="center" bgcolor="">
                   <tr align="center"><strong><h3>Login Form</h3></strong>
 	</tr>
                   <tr>
                     <td ><span class="Title">UserID</span></td>
                      <td ><input type="text" name="username"> </td>
                      </tr>
                   <tr>
                     <td><span class="Title">Password</span></td>
                      <td>
                        <input type="password" name="password"> </td>
                      </tr>
                   <tr>
                     <td colspan="2">
                       <div align="center" class="style11">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  <input type="submit" name="Submit" value="Sign In"> 
                          &nbsp; 
                          <input name="Input2" type="reset" value="Clear">
                         </div>                        </td>
                      </tr>
                      <tr></tr>
                      <tr>
               <td></td><td align="left">&nbsp;<a href="<%=request.getContextPath() %>/jsps/citizenregistration.jsp"><b style="color: black;">New User Sign Up !...</b></a></td>
               </tr>
               <tr>
               <td></td><td align="left">&nbsp;<a href="<%=request.getContextPath() %>/jsps/recoverpassword.jsp"><b style="color: black;">Forgot Password...?</b></a></td>
               </tr>
                 </table></td>
                 <td>&nbsp;</td>
               </tr>
               
             </table>
		
		
          </form>
          
             <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("login");

    frmvalidator.addValidation("username","req","Login Name is required");
    frmvalidator.addValidation("username","alpha","Login Name is Only Characters");
    frmvalidator.addValidation("password","req","Password is required");
   
  </script> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
           <br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
           <br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
           <br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
           <br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
           <jsp:include page="footer.jsp"></jsp:include>
          
	</body>
</html>