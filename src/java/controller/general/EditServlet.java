package controller.general;

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

@WebServlet("/EditServlet")
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
                
                String[] groups={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
                
                HttpSession session = request.getSession(false);
                 
                 String uID="";
                
                try{
                uID=session.getAttribute("Type").toString();
                }
                catch(Exception e1){
                out.print("");
                }
                if((uID.equals("General"))||(uID.equals("Admin"))){
                
		out.println("<h1>Update Member's Info</h1>");
		String temp = request.getParameter("sl");
		int sl = Integer.parseInt(temp);

		generalMember e = GeneralDao.getMemberById(sl);

                String dist=e.getDist();
                String bl_gr=e.getBl_gr();
                String req=e.getReq();
                String status=e.getStatus();
                
                
		out.print("<form action='EditServlet2' method='post' style='margin-left:450px'>");
		out.print("<table border=\"1\" width=\"30%\" cellpadding=\"5\" >");
		out.print("<tr><td>Sl.</td><td><input type='text' name='sl' value='" + e.getSl() + "' readonly/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
		out.print("<tr><td>Mobile:</td><td><input type='text' name='phone' value='" + e.getPhone() + "'/></td></tr>");
                out.print("<tr><td>Email:</td><td><input type='email' name='mail' value='" + e.getMail() + "'/></td></tr>");
		
                out.print("<tr><td>Blood Group:</td><td><select name='bl_gr'>");
                for(int i=0;i<groups.length;i++){
                if(bl_gr.equals(groups[i])){
                out.print("<option value='"+groups[i]+"' selected=''>"+groups[i]+"</option>");
                
                }
                else{
                out.print("<option value='"+groups[i]+"' >"+groups[i]+"</option>");
                 }
                } 
                out.print("</select></td></tr>");
                
                
		out.print("<tr><td>Age:</td><td><input type='text' name='age' value='" + e.getAge() + "'/></td></tr>");
                out.print("<tr><td>Weight:</td><td><input type='text' name='weight' value='" + e.getWeight() + "'/></td></tr>");
                out.print("<tr><td>Password:</td><td><input type='text' name='pass' value='" + e.getPass() + "'/></td></tr>");
               
                out.print("<tr><td>Status: </td><td><select name='status'>");
                if(status.equals("Available")){
                out.print("<option value='Available' selected=''>Available</option>");
                out.print("<option value='Blocked'>Blocked</option>");
                }
                else{
                out.print("<option value='Available' >Available</option>");
                out.print("<option value='Blocked' selected=''>Blocked</option>");
                }
                out.print("</select></td></tr>");
                
                out.print("<tr><td>Last Given:</td><td><input type='date' name='last_given' value='" + e.getLast_given() + "'/></td></tr>");
                
                
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