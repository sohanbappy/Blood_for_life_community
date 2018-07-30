
<jsp:include page="header.jsp" />
 
<body style="height:400px">





<%
    try{
    if((session.getAttribute("Type").equals("General")))
    {
    
%>
    
    <h1> SuccessFully Logged in!! <span style="color: green"><%=session.getAttribute("Name")%> </span><br> </h1>
    
    <section >
      
       <%
    }
else{


    %>
    You Are Not Logged in As a General User!!!!!<br><br>
    plz login <a href="login.jsp">Click Here</a>
       
    <%
        }
}
    catch(Exception e){
     %>
     You Are Not Eligible!!!!!<br><br>
     plz login <a href="login.jsp">Click Here</a>
     
     <% }
      %>
</section>

    
    <jsp:include page="footer.jsp" />
</body>
