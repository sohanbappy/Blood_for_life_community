<jsp:include page="header.jsp" />


    <body>
        

<%
    try{
    if(session.getAttribute("Type")==null)
    {
    
%>
You Are Not Logged in!!!!!
plz login <a href="login.jsp">Click Here</a>

<%
    }

else if(session.getAttribute("Type").equals("General")){
   

    %>

        
        Add Donation: <%=session.getAttribute("Name")%>
        <h1>Fill The Form Plz</h1>
        
        <form action="donationSaveServlet" method="POST">
            <table style="margin-left: 400px;" border="1" width="30%" cellpadding="5">
                <tr><td>Name: </td><td><input type="text" name="name" value=<%=session.getAttribute("Name")%> readonly/></td><tr>
            <tr><td>Date: </td><td><input type="date" name="date" placeholder="" required="required"/></td><tr>
           <tr><td> To Whom: </td><td><input type="text" name="to_whom" placeholder="patient's name plz" required="required"/></td><tr>
            <tr><td>Location: </td><td><input type="text" name="location" placeholder="specific location plz" required="required"/></td><tr>
            <tr><td colspan="2"><button type="submit" value="submit">Add Donation Request</button></td><tr>
            </table>
        </form>
        
       <% 
       if(session.getAttribute("uID").equals("admin@")){
       %>
        
       <a href="donationViewServlet"><span style="text-align: center" >View All Donations</span></a><br>
       
        <%
            }
        }
else{

  }
}
catch(Exception e){

         %>
        
         <%}
         %>
    </body>
    
    <jsp:include page="footer.jsp" />
</html>
