<!DCOTYPE html>
<html lan="en-US">

<head>
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/header.css" type="text/css"/>
	<script>
	function printContent(d){
	var restorpage=document.body.innerHTML;
	var printDiv=document.getElementById(d).innerHTML;
	document.body.innerHTML=printDiv;
	window.print();
	document.body.innerHTML=restorpage;
	}
	</script>
</head>

<body>
<div id="main">

<header id="header">
 <h1 style="color:black">Blood For Life Community </h1>
<p><img src="01.jpg" id="logo" alt="logo" ></p>
<div>
<h3 ><marquee id="welcome"> Be a member to Post an Emergency Notice or Other Query</marquee> </h3>
</div>
</header>
<div style="background-color: pink;padding: 10px">    
<nav>
<ul>

<li><a href="home.jsp" style="color:blue; text-decoration:none; padding:5px; "> Home </a></li>
<li><a href="aboutBlood.jsp" id="aaa" style="color:blue; text-decoration:none; padding:5px;"> About Blood </a></li>
<li><b><a href="why.jsp" style="color:blue; text-decoration:none; padding:5px; "> Why U r here?</b></a></li>
<li><b><a href="bankViewServlet" style="color:blue; text-decoration:none; padding:5px;"> View  Blood Bank</b></a></li>
<li><a href="feedback.jsp" style="color:blue; text-decoration:none; padding:5px;"> Post a Feedback </a></li>
 <li><div class="dropdown">
                <h4 class="dropbtn">Registration</h4>
                <div class="dropdown-content">
                  <a href="general.jsp">As General</a>
                  <a href="bank.jsp">As Blood Bank</a>
                </div> </div>
           </li>
<li><a href="login.jsp" style="color:blue; text-decoration:none; padding:5px;"> Login </a></li>
<br><br>


<form id="search" action="search.jsp" method="POST">
    District: 
    <select name="dist">
        <option selected="">Dhaka</option>
        <option>Gopalganj</option>
    </select>
    Blood Group: 
    <select name="bl_gr">
        <option selected="">A+</option>
        <option>A-</option>
        <option>B+</option>
        <option>B-</option>
        <option>AB+</option>
        <option>AB-</option>
        <option>O+</option>
        <option>O-</option>
        
    </select>
  
<input type="text" name="location" placeholder="ex: place/hospital" required="">
<input type="submit" value=">>" style="border:5px solid red">

</form>


</ul>
</nav>
</div>
<!-- Sub Menu-->
  <%
      try{
    if((session.getAttribute("Type").equals("General")))
    {
    
  %>
  <div > 
 <nav>
       
       <ul>
           <li><a href="EditServlet?sl=<%=session.getAttribute("sl")%>" style="color:red; text-decoration:none; padding:5px; ">  Edit Info </a></li>
           <li><a href="donation.jsp" style="color:red; text-decoration:none; padding:5px; "> Add Donation</a></li>
           <li><a href="donationViewServlet2" style="color:red; text-decoration:none; padding:5px; "> View Donation</a></li>
           <li><a href="logout.jsp" style="color:red; text-decoration:none; padding:5px; ">LogOut</a></li>
       </ul>
 </nav>
  </div>          
    
       <%
    }
else if((session.getAttribute("Type").equals("bb")))
    {
    
  %>
 <div >  
 <nav>
       
       <ul>
           <li><a href="bankEdit?sl=<%=session.getAttribute("sl")%>" style="color:red; text-decoration:none; padding:5px; ">  Edit Info </a></li>
           <li><a href="logout.jsp" style="color:red; text-decoration:none; padding:5px; ">LogOut</a></li>
       </ul>
 </nav>
 </div>          
   <%
    }
else if((session.getAttribute("Type").equals("Admin")))
    {
    
  %>
 <div  >  
 <nav>
       
       <ul>
           <li><div class="dropdown">
                <h4 class="dropbtn">General User</h4>
                <div class="dropdown-content">
                  <a href="ViewServlet">View All</a>
                  <a href="general.jsp">Add New</a>
                </div> </div>
           </li>
           <li><div class="dropdown">
                <h4 class="dropbtn">Blood Bank User</h4>
                <div class="dropdown-content">
                  <a href="bankViewServlet">View All</a>
                  <a href="bank.jsp">Add New</a>
                </div> </div>
           </li>
            <li><div class="dropdown">
                <h4 class="dropbtn">Manage Others</h4>
                <div class="dropdown-content">
                  <a href="noticeViewServlet">Notices</a>
                  <a href="donationViewServlet">Donations</a>
                  <a href="feedbackViewServlet">Feedbacks</a>
                </div> </div>
           </li>
           <li><b><a href="logout.jsp" style="color:red; text-decoration:none; padding:5px; ">LogOut</a></b></li>
       </ul>
 </nav>       
 </div> 
  
  <%
      }
else{
    %>
        
  
   
   <% } 
}
catch(Exception e){
 
    out.print("");
 }
   %>