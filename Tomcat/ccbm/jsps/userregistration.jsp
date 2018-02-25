<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>

<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js">


</script> <script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>

<script type="text/javascript" src="scripts/moveclock.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
	<script language="JavaScript" type="text/javascript"
		src="<%=request.getContextPath()+"/js/ts_picker.js"%>"></script>
<style type="text/css">
<!--
body {
	background-color:;
}
body,td,th {
	font-size: 18px;
}
-->
</style>
 <script>
//var x_win = window.self; 

function goOn() {


var userName=document.register.userName.value;
window.location.href="./ChekUserAction?userName="+userName;

} 
</script>
 
</head>
<body >

          
           <jsp:include page="header.jsp"></jsp:include>   
          
               <h3>Register Form</h3>
 <form action="" method="post" name="f"><fieldset>
					  <div align="center">
                    <%
					  if(request.getParameter("status")!=null)
					  {
					%>
                    <span class="style2"><%=request.getParameter("status")%>					</span>
                    <%
					  }
					%>     
                    </div>
                    <br />
                      <table border="0" align="center">
                        <tr>
                          <td class="tiny style3">First Name </td>
                          <td><input type="text" name="fname" class="textfield"/>                          </td>
                        </tr>
                        <tr>
                          <td><span class="style3">Last Name </span></td>
                          <td><input type="text" name="lname" class="textfield"/>                          </td>
                        </tr>
                        <tr>
                          <td><span class="style3">Birth Date </span></td>
                          <td><input type="text" name="bdate"  />
                            <a href="javascript:show_calendar('document.f.bdate', document.f.bdate.value);"> <img src="images/cal.gif" alt="a" width="18" height="18" border="0"/></a> </td>
                        </tr>
                        <tr>
                          <td class="style3">House No</td>
                          <td><input type="text" name="hno" class="textfield"/></td>
                        </tr>
                        <tr>
                          <td class="style3">Street</td>
                          <td><input type="text" name="street" class="textfield"/></td>
                        </tr>
                        <tr>
                          <td class="style3">City</td>
                          <td><input type="text" name="city" class="textfield"/></td>
                        </tr>
                        <tr>
                          <td class="style3">District</td>
                          <td><input type="text" name="district" class="textfield"/></td>
                        </tr>
                        <tr>
                          <td class="style3">State</td>
                          <td><input type="text" name="state" class="textfield"/></td>
                        </tr>
                        <tr>
                          <td class="style3">Country</td>
                          <td><input type="text" name="country" class="textfield"/></td>
                        </tr>
                        
                        <tr>
                          <td class="style3">Pincode</td>
                          <td><input type="text" name="pincode" class="textfield"/></td>
                        </tr>
                        <tr>
                          <td class="style3">Contact No</td>
                          <td><input type="text" name="phoneno" class="textfield"/></td>
                        </tr>
                        <tr>
                          <td class="style3">Email</td>
                          <td><input type="text" name="email" class="textfield"/></td>
                        </tr>
                        <tr>
                          <td><span class="style3">Login Name</span></td>
                          <td><input type="text" name="userName" value="<%if(request.getParameter("userName")!=null)out.print(request.getParameter("userName")); %>"/>                          </td>
                        </tr>
                        <tr>
                          <td><span class="style3">Password</span></td>
                          <td><input name="password" type="password" id="password" onkeyup="testPassword(document.forms.register.password.value);" onChange="Encrypt(document.forms.register.password.value);" />                          </td>
                        </tr>
                        <tr>
                          <td><span class="style3">Confirm Password</span></td>
                          <td><input name="confirmpassword" type="password" id="password" onBlur="checkconformpassword()" />                          </td>
                        </tr>
                        
                        <tr>
                          <td><span class="style3"> Secret Question </span></td>
<td><select name="squest">
                              <option value="1">What is your favorite pastime?</option>
                              <option value="2">Who your childhood hero?</option>
                              <option value="3">What is the name of your first school?</option>
                              <option value="4">Where did you meet your spouse?</option>
                              <option value="5">What is your favorite sports team?</option>
                              <option value="6">What is your father's middle name?</option>
                              <option value="7">What was your high school mascot?</option>
                              <option value="8">What make was your first car or bike?</option>
                              <option value="9">What is your pet's name?</option>
                          </select></td>
                        </tr>
                       
                        <tr>
                          <td><span class="style3">Secret Answer</span></td>
                          <td><input name="sanswer" type="text" /></td>
                        </tr>
                        <tr>
                          <td height="11" colspan="2"></td>
                        </tr>
                        <tr>
                          <td colspan="2"><div align="center">
                            <input name="Input" type="submit" value="Register" /> &nbsp; &nbsp;   <input type="reset" value="Clear">
                          </div></td>
                        </tr>
                      </table>
                   
					</fieldset>
				</form>
				    
				<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("f");
  
 
  frmvalidator.addValidation("fname","req","Please enter your First Name");
  frmvalidator.addValidation("fname","maxlen=20",	"Max length for FirstName is 20");
  frmvalidator.addValidation("fname","alpha"," First Name Alphabetic chars only");
  
  frmvalidator.addValidation("lname","req","Please enter your Last Name");
  frmvalidator.addValidation("lname","maxlen=20","Max length is 20");
  frmvalidator.addValidation("lname","alpha"," Last Name Alphabetic chars only");
  
   
   frmvalidator.addValidation("bdate","req","Please enter your DOB"); 
  
     
  frmvalidator.addValidation("email","maxlen=50");
  frmvalidator.addValidation("email","req");
  frmvalidator.addValidation("email","email");
   
  
   frmvalidator.addValidation("hno","req","Please enter your House Number");
   
   frmvalidator.addValidation("street","req","Please enter your Street Number");
     
   frmvalidator.addValidation("phoneno","req");
  
  frmvalidator.addValidation("phoneno","maxlen=50");
  frmvalidator.addValidation("phoneno","numeric");
 frmvalidator.addValidation("phoneno","Phone");
   
   frmvalidator.addValidation("city","req","Please enter your city Name");
   frmvalidator.addValidation("district","req","Please enter your District Name");
   frmvalidator.addValidation("state","req","Please enter your State Name");
   frmvalidator.addValidation("country","req","Please enter your Country Name");
   frmvalidator.addValidation("pincode","req","Please enter your pin Number");
   
   frmvalidator.addValidation("email","maxlen=50");
  frmvalidator.addValidation("email","req");
  frmvalidator.addValidation("email","email");
   
   frmvalidator.addValidation("loginname","req","Please enter your Username");
   frmvalidator.addValidation("password","req","Please enter your Password");
    frmvalidator.addValidation("conformpassword","req","Please enter your Confirm Password");
    
   frmvalidator.addValidation("sanswer","req","Please enter your Answer");
   frmvalidator.addValidation("squest","dontselect=0");
     
 </script>
 
 

                
              
			  
              
                 
                 
<!-- SiteSearch Google -->
            
        
       
    <jsp:include page="footer.jsp"></jsp:include>  


</body></html>