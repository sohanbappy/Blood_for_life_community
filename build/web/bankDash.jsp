
<jsp:include page="header.jsp" />
 
<body style="height:400px">





<%
    try{
    if(session.getAttribute("Type").equals("bb"))
    {
    
%>
    
    <h1> Welcome <span style="color: green"><%=session.getAttribute("Name")%> </span><br> </h1>
        
       <%
    }
else{
   

    %>
    
You Are Not Logged in As a Blood Bank!!!!!
plz login <a href="login.jsp">Click Here</a>
    
    
       
    <%
        }
     }
     catch(Exception e){
%>
    You Are Not Eligible!!!!!
    plz login <a href="login.jsp">Click Here</a>

<% }
%>
</section>

    
    <jsp:include page="footer.jsp" />
</body>
