package controller.general;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.general.*;
import dao.general.*;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
                
                request.getRequestDispatcher("/header.jsp").include(request, response);
		
                String uID="";
                try{
                HttpSession session=request.getSession();
                uID=session.getAttribute("Type").toString();
                }
                catch(Exception e){
                out.print("");
                }
                
                    
		out.println("<h1>Member List</h1>");

		List<generalMember> list = GeneralDao.getAllMembers();

		out.print("<table border=\"1\" class=\"table\" width=\"100%\" style=\"background-color:#ffffcc\";");
		
                if((uID.equals("Admin"))){
                out.print(
				"<tr><th>Sl</th><th>Name</th><th>Phone</th><th>Mail</th><th>Bl Gr.</th><th>Age</th><th>Weight</th><th>PassWord</th><th>Status</th><th>Last Given</th><th>Dist.</th><th>Location</th><th>Request</th><th colspan='2'>Action</th></tr>");
		for (generalMember e : list) {
			out.print("<tr><td>" + e.getSl() + "</td><td>" + e.getName() + "</td><td>" + e.getPhone() + "</td> <td>"
					+ e.getMail() + "</td><td>" + e.getBl_gr() + "</td><td>" + e.getAge()
					+ "</td><td>" + e.getWeight() + "</td><td>" + e.getPass() + "</td>"
                                                + "<td>" + e.getStatus() + "</td><td>" + e.getLast_given() + "</td>"
                                                        + "<td>" + e.getDist() + "</td><td>" + e.getLocation() + "</td><td>" + e.getReq() + "</td><td><a href='EditServlet?sl=" + e.getSl() + "'>Edit</a></td> <td><a href='DeleteServlet?sl="
					+ e.getSl() + "'>Delete</a></td> </tr>");
		}
		
                }
                else if((uID.equals("General"))){
                    out.print(
				"<tr><th>Sl</th><th>Name</th><th>Phone</th><th>Mail</th><th>Bl Gr.</th><th>Age</th><th>Weight</th><th>PassWord</th><th>Status</th><th>Last Given</th><th>Dist.</th><th>Location</th><th>Request</th></tr>");
		for (generalMember e : list) {
			out.print("<tr><td>" + e.getSl() + "</td><td>" + e.getName() + "</td><td>" + e.getPhone() + "</td> <td>"
					+ e.getMail() + "</td><td>" + e.getBl_gr() + "</td><td>" + e.getAge()
					+ "</td><td>" + e.getWeight() + "</td><td>" + e.getPass() + "</td>"
                                                + "<td>" + e.getStatus() + "</td><td>" + e.getLast_given() + "</td>"
                                                        + "<td>" + e.getDist() + "</td><td>" + e.getLocation() + "</td><td>" + e.getReq() + "</td></tr>");
		}
                    }
                
                else{
                out.print("<p>U r not eligible to view this page!</p>");
                    
                }
                
                out.print("</table>");
                request.getRequestDispatcher("/footer.jsp").include(request, response);

		out.close();
	}
}