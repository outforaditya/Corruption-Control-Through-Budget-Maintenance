<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
     <jsp:include page="header.jsp"></jsp:include> <br/>   

   <table align="center" border="1" bgcolor="" width="70%" cellpadding="10">
   <caption>Department Officers</caption>
     <tr bgcolor="#adede"><i></i></tr>
     <br/><br/>
     <tr><th bgcolor="lightgreen"><b>OfficerId</b></th><th bgcolor="lightgreen"><b>Officer Name</b></th><th bgcolor="lightgreen"><b>Department</b></th><th bgcolor="lightgreen"><b>District</b></th> <th bgcolor="lightgreen"><b>Delete</b></th>
   </tr>
   
   
   <c:if test="${not empty deptofficer}">
   <c:forEach var="officer" items="${deptofficer}">
   
    <tr>
   
    <td>${officer.userName}</td>
    <td>${officer.firstName}</td>

    <td>${officer.addresstype}</td>
    <td>${officer.district }</td>
    
   
 <td> <a href="./DeleteDeptofficerAction?qid=${officer.userName}">Delete</a></td>
     </tr>
   </c:forEach>
   </c:if>
   
    </table>
 <br/><br/>

     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
