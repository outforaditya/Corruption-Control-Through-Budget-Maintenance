<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

  <head>
   <base href="<%=basePath%>">
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
     <jsp:include page="header.jsp"></jsp:include> <br/>   
 <form action="./AddDeptAction" method="post" name="register" onSubmit="return validate()">
   <table align="center" border="1" bgcolor="#456987" width="70%" cellpadding="10">
   <caption>Department Details Form</caption>
     <tr bgcolor="#adede" align="center"><i>Enter Department Details </i></tr>
     
     
				 
     
     
     <tr>
        <td>Enter New Department Name</td><td><input type="text" name="deptname" value=""></td>
     </tr>
   	
   <tr>
        <td>Sub Department Name</td><td><input type="text" name="subdeptname" value=""></td>
     </tr>
   
  <tr>
        <td></td><td><input type="submit" value="Submit"> &nbsp; &nbsp;      <input type="reset" value="Clear"></td>
   </tr> 
    </table>
 <br/><br/>
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
  
  frmvalidator.addValidation("deptname","req","Please enter Deptname");
   frmvalidator.addValidation("subdeptname","req","Please enter subDeptname");
   
   </script>
     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
