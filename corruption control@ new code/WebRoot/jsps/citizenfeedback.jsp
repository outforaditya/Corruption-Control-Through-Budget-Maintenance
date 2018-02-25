<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

 if(session.getAttribute("user")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("/jsps/LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
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

		
			<center><h1>FeedBack Form</h1></center>
		 
<form action="<%=request.getContextPath() %>/FeedbackAction" method="post"  name="Feedback">
<table width="379" border="2" align="center" bordercolor="#000000">
   <tr>
    <td bgcolor="#FFFFFF" class="style2 style3"><strong>FeedBack</strong></td>
    <td bordercolor="#000000" bgcolor="#FFFFFF"><textarea name="feedback"></textarea></td>
  </tr>
   <tr>
    <td width="85" bgcolor="#FFFFFF"><span class="style2 style3"><strong>Name </strong></span></td>
    <td width="284" bordercolor="#000000" bgcolor="#FFFFFF"><input type=text name="name" value="" /></td>
  </tr>
  
   
  
  
    <tr>
    <td bgcolor="#FFFFFF" class="style2 style3"><strong>Phone number</strong></td>
    <td bordercolor="#000000" bgcolor="#FFFFFF"><input type=text name="phone"></td>
  </tr>
  
  
  <tr>
    <td bgcolor="#FFFFFF"><span class="style2 style3"><strong>Email</strong></span><br></td>
    <td bordercolor="#000000" bgcolor="#FFFFFF"><input type=text name="mail"/>
     </td>
  </tr>
  <tr>
    <td bgcolor="#FFFFFF"><span class="style2 style3"><strong>City</strong></span><br></td>
    <td bordercolor="#000000" bgcolor="#FFFFFF"><input type=text name="city"/>
     </td>
  </tr>
  <tr>
    <td bgcolor="#FFFFFF"><span class="style2 style3"><strong>State</strong></span><br></td>
    <td bordercolor="#000000" bgcolor="#FFFFFF"><input type=text name="state"/>
     </td>
  </tr>
  
  
  
  
    <tr bgcolor="#FFFFFF">
    <td colspan="2"><div align="center" class="style3">
      <input type=submit value="PostFeedBack">&nbsp;
     
    </div></td>
  </tr>
</table>
</form>
<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("Feedback");

    frmvalidator.addValidation("feedback","req","Feedback is required");
    frmvalidator.addValidation("feedback","alpha","Feedback is Only Characters");
    frmvalidator.addValidation("name","req","name is required");
     frmvalidator.addValidation("phone","req","Enter 10 Digits");
  
  frmvalidator.addValidation("phone","maxlen=50");
  frmvalidator.addValidation("phone","numeric");
 frmvalidator.addValidation("phone","Phone");
   
    frmvalidator.addValidation("mail","maxlen=50");
  frmvalidator.addValidation("mail","req");
  frmvalidator.addValidation("mail","email");
    
    frmvalidator.addValidation("city","req","City is required");
    frmvalidator.addValidation("state","req","StateName is required");
    
  </script>

 <br/>
     <jsp:include page="../jsps/footer.jsp"></jsp:include>

  </body>
</html>
