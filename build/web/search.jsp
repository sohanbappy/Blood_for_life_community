<%@ page import="java.sql.*"%>

<jsp:include page="header.jsp" />


        
            <div class="part" id="pdf"  style="background-color:#ffffcc" >
                <h1 text-align:center>Personal Details</h1>
                 <hr> 
         <div   style="margin-left:230px"  >
              <table     cellpadding="10" >
	                   
                        <tr>
				<th >Name</th>
                                <th >E-mail</th>
                                <th>Phone</th>
                                <th>Age</th>
                                <th>Location</th>
                                <th>Last Given</th>
                              
			</tr>            
                        
                <!--Retrieving Notices--->
 <%
  

        String dist22=request.getParameter("dist");
        String bl_gr22=request.getParameter("bl_gr");
        String location22=request.getParameter("location");
        String av22="Available";
     
     
    String sql="Select name,mail,phone,age,location,last_given From gen_table WHERE status='"+av22+"' AND dist='"+dist22+"' AND bl_gr='"+bl_gr22+"' AND location LIKE '%"+location22+"%' ";
    
    String name="",mail="",phone="",age="",location="",last_given="";

    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bl_for_life","root","");
    Statement st=con.createStatement();
    ResultSet rs;
    rs=st.executeQuery(sql);

    while(rs.next()){
    
   
    name=rs.getString("name");
    mail=rs.getString("mail");
    phone=rs.getString("phone");
    age=rs.getString("age");
    location=rs.getString("location");
    last_given=rs.getString("last_given");
    
    
%>	               
           
			<tr>
				<td><%=name%></td>
				<td style="text-align:center"><%=mail%></td>
                                <td><%=phone%></td>
                                <td><%=age%></td>
                                <td><%=location%></td>
                                <td><%=last_given%></td>
			</tr>
			
		<%
                        }
                 %>	
		 </table>
               </div>
            </div>
         
          
        <!-- /.col-md-4 -->
        
            <div class="part" >
              <h1 text-align:center>Blood Bank Details</h1>
               <hr> 
                       <div  style="margin-left:230px">
              <table   cellpadding="10" >
	                   
                        <tr>
				<th>Name.</th>
                                <th>E-mail</th>
                                <th>Phone</th>
                                <th>Location</th>
                                <th>Conditions</th>
                                
			</tr>            
                       
                <!--Retrieving Notices--->
 <%
    String sql1="",av="Available";
    String name2="",mail2="",phone2="",location2="",conditions2="";
    
    if(bl_gr22.equals("A+"))
    {
     sql1="Select name,mail,phone,location,conditions From bank_tb WHERE dist='"+dist22+"' AND gr_a1 ='"+av+"' AND location LIKE '%"+location22+"%'  ";
    }
    if(bl_gr22.equals("A-"))
    {
     sql1="Select name,mail,phone,location,conditions From bank_tb WHERE dist='"+dist22+"' AND gr_a2 ='"+av+"' AND location LIKE '%"+location22+"%'  ";
    }
   if(bl_gr22.equals("B+"))
    {
     sql1="Select name,mail,phone,location,conditions From bank_tb WHERE dist='"+dist22+"' AND gr_b1 ='"+av+"' AND location LIKE '%"+location22+"%'  ";
    }
   if(bl_gr22.equals("B-"))
    {
     sql1="Select name,mail,phone,location,conditions From bank_tb WHERE dist='"+dist22+"' AND gr_b2 ='"+av+"' AND location LIKE '%"+location22+"%'  ";
    }
    if(bl_gr22.equals("O+"))
    {
     sql1="Select name,mail,phone,location,conditions From bank_tb WHERE dist='"+dist22+"' AND gr_o1 ='"+av+"' AND location LIKE '%"+location22+"%'  ";
    }
    if(bl_gr22.equals("O-"))
    {
     sql1="Select name,mail,phone,location,conditions From bank_tb WHERE dist='"+dist22+"' AND gr_o2 ='"+av+"' AND location LIKE '%"+location22+"%'  ";
    }
   if(bl_gr22.equals("AB+"))
    {
     sql1="Select name,mail,phone,location,conditions From bank_tb WHERE dist='"+dist22+"' AND gr_ab1 ='"+av+"' AND location LIKE '%"+location22+"%'  ";
    }
   if(bl_gr22.equals("AB-"))
    {
     sql1="Select name,mail,phone,location,conditions From bank_tb WHERE dist='"+dist22+"' AND gr_ab2 ='"+av+"' AND location LIKE '%"+location22+"%'  ";
    }

    Statement st1=con.createStatement();
    ResultSet rs1;
    rs1=st1.executeQuery(sql1);

    while(rs1.next()){
    
   
    name2=rs1.getString("name");
    mail2=rs1.getString("mail");
    phone2=rs1.getString("phone");
    location2=rs1.getString("location");
    conditions2=rs1.getString("conditions");
    
    
%>	               
              
			<tr>
				<td><%=name2%></td>
                                <td><%=mail2%></td>
                                <td><%=phone2%></td>
                                <td><%=location2%></td>
                                <td><%=conditions2%></td>
			</tr>
			
		<%
                        }
                 %>	
		</table>
               
              </div>
                
            </div>
            <button onclick="printContent('pdf')">Print List</button>
        

    <jsp:include page="footer.jsp" />