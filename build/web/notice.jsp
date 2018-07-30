<jsp:include page="header.jsp" />


    

    <body>
        <%
    try{
    if((session.getAttribute("Type").equals("General")))
    {
    
       %>
        
        <h1>Fill The Form Plz</h1>
        
        <form action="noticeSaveServlet" method="POST">
            
        
            Title: <input type="text" name="title" placeholder="title plz" required="required"/><br><br>
            Blood Group Needed: <input type="text" name="gr" placeholder="Expected Blood Group plz" required="required"/><br><br>
            Unit(bags): <input type="text" name="unit" placeholder="no. of unit plz" required="required"/><br><br>
            Dist: <input type="text" name="dist" placeholder="Dist plz" required="required"/><br><br>
            Location: <input type="text" name="location" placeholder="specific location plz" required="required"/><br><br>
            Contact: <input type="text" name="contact" placeholder="contact no. plz" required="required"/><br><br>
            Date: <input type="date" name="date" placeholder="" required="required"/><br><br>
            Published by: <input type="text" name="published_by" placeholder="ur Name plz" required="required"/><br><br>
            <button type="submit" value="submit">Add Notice</button>
            
        </form>
      <%  
           }
      else{


    %>
    You Are Not Logged in  As a General User!!!!!<br><br>
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
        
    </body>
    
    
    <jsp:include page="footer.jsp" />
</html>
