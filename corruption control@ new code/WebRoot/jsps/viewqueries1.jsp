
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
		
	<center><h2>View Queries</h2></center>
		  <div class="hr"> </div>
          <p></p> 

                    <form  method="post" action="DisplayQueryAction">
 
    <table width="637" border="0" align="center" bordercolor="#8692E3">
    
     
     
         <tr bgcolor="#50cccc">
        <td width="233" height="16"><div align="center" class="style8">Name</div></td>
        <td width="233" height="16"><div align="center" class="style8">Query</div></td>
        <td width="372"><div align="center" class="style8">Query Date</div></td>
        <td width="372"><div align="center" class="style8">Status</div></td>
        <td width="372"><div align="center" class="style8"><br></div></td>
      </tr>
        
        <c:if test="${not empty query}">
        <c:forEach var="que" items="${query}">
        
        
        <tr bgcolor="#CcC9cA">
              
        <tr bgcolor="#CcC9cA">
              <td bgcolor="#C3D7BA"><div align="center"><span class="style7">${que.name}</span></div></td>
        <td bgcolor="#C3D7BA"><div align="center" class="style7">
           
         ${que.query }
         </div></td>
         <td>${que.qdate }</td>
        
        
        
        <td bgcolor="#C3D7BA"><div align="center">${que.qstatus }</div></td>
        
        
        <td bgcolor="#C3D7BA"><div align="center" class="style3">
        
        
        
        
        
        
        <c:choose>
        <c:when test="${que.qstatus eq 'solved'or que.qstatus eq 'SOLVED'}">
        
         <div align="center" class="style3"><strong>Already Solved</strong></div><a href="./DeleteQueryAction?qid=${que.qid }"> DELETE</a>
         </c:when>
         </c:choose></div></td></tr>
        </c:forEach>
        </c:if>
        
      
           
        
         
       
       
   
    </table>
    </form>
    
    <br/>
     <jsp:include page="../jsps/footer.jsp"></jsp:include>
  </body>
 </html>
