

<%@page import="business.general.generalMember"%>
<%@page import="dao.general.*"%>
<%@ page import="java.sql.*" %>

<%
    String sql="";
    
    String mail=request.getParameter("mail");
    String pass=request.getParameter("pass");
    String type=request.getParameter("type");
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bl_for_life","root","");
    
    if(type.equals("General")){
     sql="Select * From gen_table Where mail='"+mail+"' And pass='"+pass+"' AND req='Accepted' ";
     Statement st=con.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    if(rs.next())
    {
        int sl=rs.getInt(1);
        
        //get Info
       generalMember e= GeneralDao.getMemberById(sl);
       
        //session variable
     session.setAttribute("Name", e.getName());
        
        
     session.setAttribute("sl",sl);
     session.setAttribute("uID",mail);
     session.setAttribute("Type",type);
     response.sendRedirect("generalDash.jsp");
     
    }
    else{
    response.sendRedirect("loginFailed.jsp");
    }
    }
    if(type.equals("bb")){
    sql="Select * From bank_tb Where mail='"+mail+"' And pass='"+pass+"' AND req='Accepted' ";
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery(sql);
    
    if(rs.next())
    {
         int sl=rs.getInt(1);
      
     session.setAttribute("Name", rs.getString(2));
     session.setAttribute("sl",sl);   
     session.setAttribute("uID",mail);
     session.setAttribute("Type",type);
     response.sendRedirect("bankDash.jsp");
     
    }
    else{
    
    response.sendRedirect("loginFailed.jsp");
       }
    }
     if(type.equals("Admin")){
   
    if(mail.equals("admin@") && pass.equals("1234"))
    {
     session.setAttribute("uID",mail);
     session.setAttribute("Type",type);
     response.sendRedirect("adminDash.jsp");
     
    }
    else{
     
     response.sendRedirect("loginFailed.jsp");
    }
    } 
%>
