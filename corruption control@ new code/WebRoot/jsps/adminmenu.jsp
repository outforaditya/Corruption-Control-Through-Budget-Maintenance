 <style type="text/css">
.tab{
font-family: arial, verdana, san-serif;
font-size: 14px;
}
.asd
{
text-decoration: none;
font-family: arial, verdana, san-serif;
font-size: 13px;
color:#4234ff;
}

/*****remove the list style****/
#nav {
margin:0;
padding:0;
list-style:none;
}

/*****LI display inline *****/
#nav li {
float:left;
display:block;
width:140px;
background:lightpink;
position:relative;
z-index:500;
margin:0 1px;
}

/*****parent menu*****/
#nav li a {
display:block;
padding:8px 5px 0 5px;
font-weight:700;
height:23px;
text-decoration:none;
color:lightblue;
text-align:center;
color:blue;
}

#nav li a:hover
{
color:;
}

/* style for default selected value */ #nav a.selected {
color:#4234ff;
}
/* submenu */ #nav ul
{
position:absolute;
left:0;
display:none;
margin:0 0 0 -1px;
padding:0;
list-style:none;
}

#nav ul li
{
width:150px;
float:left;
border-top:1px solid #fff;
}

/* display block will make the link fill the whole area of LI */ #nav ul a
{
display:block;
padding:8px 5px 0 5px;
font-weight:1000;
height:23px;
text-decoration:none;
color:lightblue;
text-align:center;
color:black;
}

#nav ul a:hover
{
text-decoration:underline;
padding-left:15px;
}
</style>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js">
</script>

<script type="text/javascript">
$(document).ready(function () {
$('#nav li').hover(
function () {
//show its submenu
$('ul', this).slideDown(350);
},
function () {
//hide its submenu
$('ul', this).slideUp(350);
}
);
});
</script>

<input type=hidden name=arav value="4*#*#*1*#*#*1*#*#*1*#*#*1">
<ul id='nav'>
<li> <a href=<%=request.getContextPath()+"/jsps/adminhome.jsp" %>  >Home</a>
<ul>
</ul>

<li> <a href=<%=request.getContextPath()+"/ViewDeptsforAddDept" %>  >AddDepartment</a>
<ul>
</ul>
<li> <a href='#'>DepartmentOfficers</a>
<ul>
<li style='background-color:lightblue;'><a href=<%=request.getContextPath()+ "/ViewDepartmentsofDo" %>>View Department Officers</a></li>
<li style='background-color:lightblue;'><a href=<%=request.getContextPath()+"/ViewDepartmentAction?user="+"deptoff" %>>Add Department Officers</a></li>

</ul>
<li> <a href='#'>DistrictOfficers</a>
<ul>

<li style='background-color:lightblue;'><a href="<%=request.getContextPath()+"/ViewDistrictOfficersAction" %>" >View District Officers </a></li>
<li style='background-color:lightblue;'><a href="<%=request.getContextPath()+ "/ViewDepartmentAction?user="+"distoff"%>"  >Add District Officers </a></li>

</ul>

<li> <a href='#'>Budget</a>
<ul>
<li style='background-color:lightblue;'><a href="<%=request.getContextPath()+"/ViewDeptAction" %>" >ViewBudget </a></li>
<li style='background-color:lightblue;'><a href="<%=request.getContextPath()+"/ViewDepartmentAction" %>" >EnterBudget </a></li>


</ul>


<li> <a href='#'>Queries</a>
<ul>
<li style='background-color:lightblue;'> <a href="<%=request.getContextPath()+"/ViewQueryAction"%>">ViewQueries</a></li>
<li style='background-color:lightblue;'> <a href="<%=request.getContextPath()+"/ViewQueryforDeleteAction"%>">DeleteQueries</a></li>



</ul>

<li> <a href="<%=request.getContextPath()+"/LogoutAction"%>">LogOut</a>
<ul>
</ul>
</li>
</ul>