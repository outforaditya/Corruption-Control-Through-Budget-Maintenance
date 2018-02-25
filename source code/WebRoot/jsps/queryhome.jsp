<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import=" java.text.DateFormat"%>
<%@page import=" java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%

 if(session.getAttribute("user")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("/jsps/LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

 <%!
   
             Date date=new Date();
              DateFormat df = new SimpleDateFormat("dd-MMM-yy");
              
            String  reportDate = df.format(date); 
             
              
    

 %>
<head>

<script type="text/javascript">

function validation(){

document.getElementById("ErrorQuery").innerHTML="";
if(document.getElementById("query").value==""){

document.getElementById("ErrorQuery").innerHTML="Plz Enter Query";
return false;
}else if(!isNaN(document.getElementById("query").value)){
document.getElementById("ErrorQuery").innerHTML="Plz Enter Only Alphabets";
return false;
}

}



</script>
<script type="text/javascript">

function validation(){

document.getElementById("ErrorQuery").innerHTML="";
if(document.getElementById("query").value==""){

document.getElementById("ErrorQuery").innerHTML="Plz Enter Query";
return false;
}else if(!isNaN(document.getElementById("query").value)){
document.getElementById("ErrorQuery").innerHTML="Plz Enter Only Alphabets";
return false;
}

}



</script>


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
	
	
	 <center>
   <font color="red">
		 <c:if test="${'requestScope.status'!='null'}">
					 
                          <c:out value="${param.status}"></c:out> 
                          </c:if>
                          </font>
                           </center>
			
			<br/>

			<br/><br/><br/><br/><br/>
			
			
			
			
			
                      
                      
                   
                  
                  <br/>
     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
