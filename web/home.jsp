<%@ page import="java.sql.*"%>

<jsp:include page="header.jsp" />


      <!-- Content Row -->
      
      <div class="part" >
           <h1 text-align:center>Welcome</h1>
              <p >Welcome to the community of Blood.Donate blood save life. We all here for others as well as ours. </p>
            
      </div>
            
          
        <!-- /.col-md-4 -->
        
            <div class="part" style="background-color:#ffffcc" >
                <h1 text-align:center>Recent Notices</h1>
                 <hr> 
         <div   style="margin-left:30px">
              <table   cellpadding="5" width="100%">
	                   
                        <tr style="color:white; background-color:black;">
				<th>Sl.</th>
                                <th width="100%" >Title</th>
                                <th>Group</th>
                                <th>Unit(bags)</th>
                                <th>District</th>
                                <th>Location</th>
                                <th>Contact</th>
                                <th>Date</th>
                                <th>Publisher</th>
                              
			</tr>            
                        
                <!--Retrieving Notices--->
 <%
    int sl=0;
    String title="",gr="",unit="",dist="",location="",contact="",date="",published_by="";
    String sql="Select * From notice_tb LIMIT 2";


    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bl_for_life","root","");
    Statement st=con.createStatement();
    ResultSet rs;
    rs=st.executeQuery(sql);

    while(rs.next()){
    
    sl=rs.getInt("sl");
    title=rs.getString("title");
    gr=rs.getString("gr");
    unit=rs.getString("unit");
    dist=rs.getString("dist");
    location=rs.getString("location");
    contact=rs.getString("contact");
    date=rs.getString("date");
    published_by=rs.getString("published_by");
    
    
%>	               
           
			<tr>
				<td><%=sl%></td>
				<td style="text-align:center"><%=title%></td>
                                <td><%=gr%></td>
                                <td><%=unit%></td>
                                <td><%=dist%></td>
                                <td><%=location%></td>
                                <td><%=contact%></td>
                                <td><%=date%></td>
                                <td><%=published_by%></td>
			</tr>
			
		<%
                        }
                 %>	
		</table>
            </div>
                  
                        
              <a href="noticeViewServlet" class="btn btn-primary">More Notices</a>
            </div>
         
          
        <!-- /.col-md-4 -->
        
            <div class="part" >
              <h1 style="text-align:center">Feedbacks</h1>
               <hr> 
                       <div   style="margin-left:330px;">
                  <table   cellpadding="15" style="text-align: center">
	                   
                        <tr style="color:white; background-color:black;">
				<th>Sl.</th>
                                <th>Name</th>
                                <th>Date</th>
                                <th width="50%">Comments</th>
                                
			</tr>            
                       
                <!--Retrieving Notices--->
 <%
    int sl2=0;
    String name="",date2="",comments="";
    String sql1="Select * From feedback LIMIT 2";

    Statement st1=con.createStatement();
    ResultSet rs1;
    rs1=st1.executeQuery(sql1);

    while(rs1.next()){
    
    sl2=rs1.getInt("sl");
    name=rs1.getString("name");
    date2=rs1.getString("date");
    comments=rs1.getString("comments");
    
    
%>	               
              
			<tr>
				<td><%=sl2%></td>
                                <td><%=name%></td>
                                <td><%=date2%></td>
                                <td style="text-align:center"><%=comments%></td>
			</tr>
			
		<%
                        }
                 %>	
		</table>
            </div>
              <a href="feedbackViewServlet" class="btn btn-primary">More Feedbacks</a>
            </div>
           
        

    <jsp:include page="footer.jsp" />