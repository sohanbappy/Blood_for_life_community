  <jsp:include page="header.jsp" />

    <body>
        <h1>Fill The Form Plz</h1>
        
        <form action="feedbackSaveServlet" method="POST">
            
            <table style="margin-left: 400px;" border="1" width="30%" cellpadding="5">
            
                <tr><td>Name:</td><td> <input type="text" name="name" placeholder="Name plz" required="required"/></td></yr>
                <tr><td>Date: </td><td><input type="date" name="date" placeholder="" required="required"/></td></tr>
                <tr><td>Comments: </td>
                    <td><textarea name="comments" placeholder="comments plz" rows='20' cols="30"></textarea></td></tr>
            
                <tr><td colspan="2"><button type="submit" value="submit">Add Feedback</button></td><tr>
           
            </table>
        </form>
        
        
        
    </body>
    
    
    <jsp:include page="footer.jsp" />
</html>
