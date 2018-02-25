
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

 if(session.getAttribute("user")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("/jsps/LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
<html>
<head>

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
		
	<center><h2>Reply Form Budget officer</h2></center>
		  <div class="hr"> </div>
          <p></p> 

                    
 
    <table width="637" border="0" align="center" bordercolor="#8692E3">
    
     
     
         <tr bgcolor="#50cccc">
        
        <td width="372"><div align="center" class="style8">Solution</div></td>
        <td width="372"><div align="center" class="style8">Solved date</div></td>
      </tr>
        
        <c:if test="${not empty answer}">
        <c:forEach var="que" items="${answer}">
        
        
        <tr bgcolor="#CcC9cA">
              
        <tr bgcolor="#CcC9cA">
              
        <td bgcolor="#C3D7BA"><div align="center" class="style7">
           
         ${que.ans}
         </div></td>
         <td>${que.adate }</td>
        
        
       
        </c:forEach>
        </c:if>
        
      
           
        
         
       
       
   
    </table>
    
    
    <br/>
     <jsp:include page="footer.jsp"></jsp:include>
  </body>
 </html>
