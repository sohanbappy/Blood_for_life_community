package controller.bank;


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

@WebServlet("/bankViewServlet")
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
                uID=session.getAttribute("uID").toString();
                }
                catch(Exception e){
                out.print("");
                }
                if((uID!=null)&&(uID.equals("admin@"))){
                    
		out.println("<h1>Member List</h1>");

		List<bankMember> list = BankDao.getAllBankMembers();

		out.print("<table border=\"1\" class=\"table\" width=\"100%\" style=\"background-color:#ffffcc\">");
		out.print(
				"<tr style=\"color:white; background-color:black;\"><th>Name</th><th>Auth ID</th><th>Phone</th><th>Dist. </th><th>Mail</th><th>Pass</th><th>Group A+</th><th>Group A-</th><th>Group B+</th><th>Group B-</th><th>Group O+</th><th>Group O-</th><th>Group AB+</th><th>Group AB-</th><th>Conditions</th><th>Location</th ><th>Request</th ><th colspan='2'>Action</th></tr>");
		for (bankMember e : list) {
			out.print("<tr><td>" + e.getName() + "</td><td>" + e.getAuth_id() + "</td><td>" + e.getPhone() + "</td><td>" + e.getDist() + "</td><td>"
				+ e.getMail() + "</td><td>" + e.getPass() + "</td>"+ "<td>" + e.getGr_a1() + "</td><td>" + e.getGr_a2() + "</td><td>" + e.getGr_b1() + "</td><td>" + e.getGr_b2() + "</td><td>"
                                 + e.getGr_o1() + "</td><td>" + e.getGr_o2()+ "</td><td>" + e.getGr_ab1() + "</td><td>" + e.getGr_ab2() + "</td><td>" + e.getConditions() + "</td><td>" + e.getLocation() + "</td><td>" + e.getReq() + "</td><td><a href='bankEdit?sl=" + e.getSl() + "'>Edit</a></td> <td><a href='bankDeleteServlet?sl="
					+ e.getSl() + "'>Delete</a></td></tr>");
		}
		out.print("</table>");
                
                
                }
                else{
                    out.println("<h1>Member List</h1>");

		List<bankMember> list = BankDao.getAllBankMembers();

		out.print("<table border=\"1\" class=\"table\" width=\"100%\" style=\"background-color:#ffffcc\">");
		out.print(
				"<tr style=\"color:white; background-color:black;\"><th>Name</th><th>Auth ID</th><th>Phone</th><th>Dist. </th><th>Mail</th><th>Pass</th><th>Group A+</th><th>Group A-</th><th>Group B+</th><th>Group B-</th><th>Group O+</th><th>Group O-</th><th>Group AB+</th><th>Group AB-</th><th>Conditions</th><th>Location</th></tr>");
		for (bankMember e : list) {
			out.print("<tr><td>" + e.getName() + "</td><td>" + e.getAuth_id() + "</td><td>" + e.getPhone() + "</td><td>" + e.getDist() + "</td><td>"
				+ e.getMail() + "</td><td>" + e.getPass() + "</td>"+ "<td>" + e.getGr_a1() + "</td><td>" + e.getGr_a2() + "</td><td>" + e.getGr_b1() + "</td><td>" + e.getGr_b2() + "</td><td>"
                                 + e.getGr_o1() + "</td><td>" + e.getGr_o2()+ "</td><td>" + e.getGr_ab1() + "</td><td>" + e.getGr_ab2() + "</td><td>" + e.getConditions() + "</td><td>" + e.getLocation() + "</td></tr>");
		}
		out.print("</table>");
                }
                request.getRequestDispatcher("/footer.jsp").include(request, response);
		out.close();
	}
}