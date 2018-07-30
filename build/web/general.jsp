
<jsp:include page="header.jsp" />


    <body>
        <h1>Fill The Form Plz</h1>
        
        <form action="SaveServlet" method="POST"  style="margin-left: 400px">
		<table border="1" width="30%" cellpadding="5" >
		 	
			<tr>
				<th colspan="2">Member Information</th>
			</tr>
			
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" required></input></td>
			</tr>
                        <tr>
				<td>Phone</td>
				<td><input type="text" name="phone" required></input></td>
			</tr>
                        <tr>
				<td>Mail</td>
				<td><input type="email" name="mail" required></input></td>
			</tr>    
			<tr>
				<td>Blood Group</td>
                                <td>
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
                                </td>
			</tr>
                        <tr>
				<td>Age</td>
				<td><input type="text" name="age" required></input></td>
			</tr> 
                        <tr>
				<td>Weight</td>
				<td><input type="text" name="weight" required></input></td>
			</tr>    
			<tr>
				<td>PassWord</td>
                                <td><input type="text" name="pass"  required></input></td>
			</tr>
                        <tr>
				<td>Status</td>
				<td>
                                    <select name="status">
                                        <option selected="">Available</option>
                                        <option>Blocked</option>
                                     </select></td>
			</tr>    
			<tr>
				<td>Last Given</td>
				<td><input type="date" name="last_given"  required/></input></td>
			</tr>
			<tr>
				<td>District</td>
                                <td>
                                    <select name="dist">
                                        <option selected="">Dhaka</option>
                                        <option>Gopalganj</option>
                                     </select>
                                </td>
			</tr> 
                        <tr>
				<td>Location</td>
				<td><input type="text" name="location" required ></input></td>
			</tr> 
                        <tr><td>Request: </td>
                            <td><select name="req">
                            <option selected="">Pending</option>
                        <    /select></td>
                        </tr>
			<tr>
                            <td colspan="2"><button type="submit" value="submit">Submit Request</button></td>
			</tr>
		</table>
		
		</form>
       
        
        
    </body>
    
    <jsp:include page="footer.jsp" />
</html>
