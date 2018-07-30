    <%
    session.setAttribute("uID", null);
    session.invalidate();
    
    response.sendRedirect("login.jsp");
    %>