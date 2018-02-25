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

			<center><h2><font color="#1236890">Post Answer<br></font></h2></center>
		  <div class="hr"> </div>
          <p></p> 
					<form  method="post" action="<%=request.getContextPath()+"/ReplytoQueryAction"%>" onsubmit="return validation();">
					  <table width="337" border="2" align="center">
                        <tr>
                          <td width="54"><span class="">From</span></td>
                          <td width="273"><label>
                            <input type=text name="from"  size="48" value="<%=(String)session.getAttribute("user")%>"  readonly="readonly" />
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class="">To</span></td>
                          <td><label>
                            <input type=text name="to"   size="48"  value="<%=request.getParameter("username") %>" readonly="readonly"/>
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class="">Solution</span></td>
                          <td><label>
                            <textarea name="ans"  cols="45" rows="5"></textarea>
                          </label><div id="ErrorQuery"></div></td>
                        </tr>
                        
                        <tr>
                          <td><span class="">Date</span></td>
                          <td>
                   <input type=text name="date" readonly="readonly" value="<%=reportDate %>"/>
                   <input type="hidden" name="qid"  value="<%=request.getParameter("qid") %>"/>
                   <input type="hidden" name="userid"  value="<%=request.getParameter("userid") %> %>"/>
      
                     </td>
                        </tr>
                        
                        <tr>
                          <td colspan="2"><label>
                            <div align="center">
                              <input type=submit value=Reply>
                             </div>
                          </label></td>
                        </tr>
                      </table>
                      
                      
                       <br/><br/>
                  <table>
                  </table>
                  </form>
                  
                  <br/>
     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
