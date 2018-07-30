
<jsp:include page="header.jsp" />

<body >
    
    <%
        try{
    if((session.getAttribute("Type").equals("Admin")))
    {
    
     %>
    <h1>Welcome to Admin Panel</h1>
    
      <%
    }
   else{


    %> 
    
    You Are Not Logged in As an Admin!!!!!<br><br>
    Plz login <a href="login.jsp">Click Here</a>
    
    <%   }
      }
    catch(Exception e){

    %>
    You Are Not Eligible!!!!!<br><br>
    Plz login <a href="login.jsp">Click Here</a>
    
    <%
    }
    %>
    
    </body>
    
    <jsp:include page="footer.jsp" />
</html>
