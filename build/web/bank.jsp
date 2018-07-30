<jsp:include page="header.jsp" />


    <body>
        <h1>Fill The Form Plz</h1>
        
        <form action="bankSaveServlet" method="POST" style="margin-left: 400px">
            <table  border="1" width="30%" cellpadding="5">
            
            <tr><td>Name: </td><td><input type="text" name="name" placeholder="name plz" required="required"/></td></tr>
            <tr><td>Auth ID: </td><td><input type="text" name="auth_id" placeholder="Auth ID plz" required="required"/></td></tr>
            <tr><td>Phone: </td><td><input type="text" name="phone" placeholder="phone plz" required="required"/></td></tr>
            <tr><td>Dist:  </td><td><select name="dist">
                        <option selected="">Dhaka</option>
                        <option>Gopalganj</option>
                    </select></td></tr>
            <tr><td>Mail: </td><td><input type="email" name="mail" placeholder="mail plz" required="required"/></td></tr>
            <tr><td>PassWord: </td><td><input type="text" name="pass" placeholder="pass plz" required="required"/></td></tr>
            <tr><td>Group A+:  </td><td><select name="gr_a1">
                            <option selected="">Available</option>
                            <option>Blocked</option>
                        </select></td></tr>
            <tr><td>Group A-: </td><td><select name="gr_a2">
                            <option selected="">Available</option>
                            <option>Blocked</option>
                        </select></td></tr>
            <tr><td>Group B+: </td><td><select name="gr_b1">
                            <option selected="">Available</option>
                            <option>Blocked</option>
                        </select></td></tr>
            <tr><td>Group B-: </td><td><select name="gr_b2">
                            <option selected="">Available</option>
                            <option>Blocked</option>
                        </select></td></tr>
            <tr><td>Group O+: </td><td><select name="gr_o1">
                            <option selected="">Available</option>
                            <option>Blocked</option>
                        </select></td></tr>
             <tr><td>Group O-: </td><td><select name="gr_o2">
                            <option selected="">Available</option>
                            <option>Blocked</option>
                        </select></td></tr>
             <tr><td>Group AB+: </td><td><select name="gr_ab1">
                            <option selected="">Available</option>
                            <option>Blocked</option>
                        </select></td></tr>
             <tr><td>Group AB-: </td><td><select name="gr_ab2">
                            <option selected="">Available</option>
                            <option>Blocked</option>
                        </select></td></tr>
             <tr><td>Conditions: </td><td><input type="text" name="conditions" placeholder="Always or Limit" required="required"/></td></tr>
             <tr><td>Location: </td><td><input type="text" name="location" placeholder="specific location plz" required="required"/></td></tr>
            <tr><td>Request: </td><td><select name="req">
                            <option selected="">Pending</option>
                        </select></td></tr>
             <tr ><td colspan="2"><button type="submit" value="submit">Submit Request</button></td></tr>
            </table>  
        </form>
        
        
        
    </body>
    
    
    <jsp:include page="footer.jsp" />
</html>
