

<jsp:include page="header.jsp" />

<div>
<section id="mainbody">
<header>

</header>
</section>
</div>
    <body >
 
	<div class="container" text-align="center">
		<h1>Login Page</h1>
		<form action="loginCheck.jsp" method="POST" style="margin-left:400px">
		<table border="1"  cellpadding="5" >
			<tr>
				<th colspan="2" style="background-color:white; color:red">Input Plz</th>
			</tr>
			<tr>
				<td style="background-color:white; color:black">E-mail</td>
				<td><input type="text" name="mail" placeholder="mail plz"></input></td>
			</tr>
			<tr>
				<td style="background-color:white; color:black">PassWord</td>
				<td><input type="text" name="pass" placeholder="password plz"></input></td>
			</tr>
                        <tr>
				<td style="background-color:white; color:black">Type</td>
                                <td>
                                    <select name="type">
                                        <option value="Admin">Admin</option>
                                        <option value="bb">Blood Bank</option>
                                        <option value="General" selected="">General</option>
                                    </select>
                                </td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit" value="Login"></input></td>
				<td><input type="reset" value="Clear"></input></td>
			</tr>
			<tr>
				<td>Not registered??</td>
				<td><a href="registration.jsp">click here</a></td>
			</tr>
		</table>
		
		</form>
	</div>
</body>
        

    <jsp:include page="footer.jsp" />