package controller.bank;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.general.*;
import dao.general.*;
import javax.servlet.http.HttpSession;

@WebServlet("/bankEdit")  //changed Servlet Name
public class EditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
                response.setContentType("text/html");
		PrintWriter out = response.getWriter();
                request.getRequestDispatcher("/header.jsp").include(request, response);
                
                 HttpSession session = request.getSession(false);
                 
                String uID="";
                
                try{
                uID=session.getAttribute("Type").toString();
                }
                catch(Exception e1){
                out.print("");
                }
                if((uID.equals("bb"))||(uID.equals("Admin"))){
		 out.println("<h1>Update Blood Bank Member</h1>");
                
		 int sl= Integer.parseInt(request.getParameter("sl"));
                
                
		bankMember e = BankDao.getBankMemberById(sl);
                String dist=e.getDist();
                String req=e.getReq();
                
                

		out.print("<form action='bankEditServlet2' method='post'>");
		out.print("<table style='margin-left:400px;' border=\"1\" width=\"30%\" cellpadding=\"5\" ");
		out.print("<tr><td>Sl.</td><td><input type='text' name='sl' value='" + e.getSl() + "' readonly/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
                out.print("<tr><td>Auth ID:</td><td><input type='text' name='auth_id' value='" + e.getAuth_id() + "'/></td></tr>");
		out.print("<tr><td>Mobile:</td><td><input type='text' name='phone' value='" + e.getPhone() + "'/></td></tr>");
                
                out.print("<tr><td>District:</td><td><select name='dist'>");
                if(dist.equals("Dhaka")){
                out.print("<option value='Dhaka' selected=''>Dhaka</option>");
                out.print("<option value='Gopalganj'>Gopalganj</option>");
                }
                else{
                out.print("<option value='Dhaka' >Dhaka</option>");
                out.print("<option value='Gopalganj' selected=''>Gopalganj</option>");
                }
                out.print("</select></td></tr>");
                
                out.print("<tr><td>Email:</td><td><input type='email' name='mail' value='" + e.getMail() + "'/></td></tr>");
                out.print("<tr><td>Password:</td><td><input type='text' name='pass' value='" + e.getPass() + "'/></td></tr>");
                
                out.print("<tr><td>Group A+:</td><td><select name='gr_a1'>");
                out.print("<option value='Available' selected=''>Available</option>");
                out.print("<option value='Blocked'>Blocked</option>");
                out.print("</select></td></tr>");
                
                out.print("<tr><td>Group A-:</td><td><select name='gr_a2'>");
                out.print("<option value='Available' selected=''>Available</option>");
                out.print("<option value='Blocked'>Blocked</option>");
                out.print("</select></td></tr>");
                
                out.print("<tr><td>Group B+:</td><td><select name='gr_b1'>");
                out.print("<option value='Available' selected=''>Available</option>");
                out.print("<option value='Blocked'>Blocked</option>");
                out.print("</select></td></tr>");
                
                out.print("<tr><td>Group B-:</td><td><select name='gr_b2'>");
                out.print("<option value='Available' selected=''>Available</option>");
                out.print("<option value='Blocked'>Blocked</option>");
                out.print("</select></td></tr>");
                
                out.print("<tr><td>Group O+:</td><td><select name='gr_o1'>");
                out.print("<option value='Available' selected=''>Available</option>");
                out.print("<option value='Blocked'>Blocked</option>");
                out.print("</select></td></tr>");
                
                out.print("<tr><td>Group O-:</td><td><select name='gr_o2'>");
                out.print("<option value='Available' selected=''>Available</option>");
                out.print("<option value='Blocked'>Blocked</option>");
                out.print("</select></td></tr>");
                
                out.print("<tr><td>Group AB+:</td><td><select name='gr_ab1'>");
                out.print("<option value='Available' selected=''>Available</option>");
                out.print("<option value='Blocked'>Blocked</option>");
                out.print("</select></td></tr>");
                
                out.print("<tr><td>Group AB-:</td><td><select name='gr_ab2'>");
                out.print("<option value='Available' selected=''>Available</option>");
                out.print("<option value='Blocked'>Blocked</option>");
                out.print("</select></td></tr>");
                
                out.print("<tr><td>Conditions:</td><td><input type='text' name='conditions' value='" + e.getConditions() + "'/></td></tr>");
                out.print("<tr><td>Location:</td><td><input type='text' name='location' value='" + e.getLocation() + "'/></td></tr>");
                
                out.print("<tr><td>Request:</td><td><select name='req'>");
                
                if(session.getAttribute("Type").equals("Admin")){
                
                if(req.equals("Accepted")){
                out.print("<option value='Accepted' selected=''>Accepted</option>");
                out.print("<option value='Pending'>Pending</option>");
                }
                else{
                out.print("<option value='Accepted' >Accepted</option>");
                out.print("<option value='Pending' selected=''>Pending</option>");
                }
               }
                else{
                out.print("<option value='Accepted' selected=''>Accepted</option>");
                }
                out.print("</select></td></tr>");
                
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
                 
		}
                else{
                       response.sendRedirect("home.jsp");
                }
                request.getRequestDispatcher("/footer.jsp").include(request, response);
		out.close();
	}
}