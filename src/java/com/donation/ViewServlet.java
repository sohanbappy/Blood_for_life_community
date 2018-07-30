package com.donation;





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

@WebServlet("/donationViewServlet")
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
		out.println("<h1>Donation List</h1>");

		List<donation> list = DonationDao.getAllDonations();

		out.print("<table border=\"1\" class=\"table\" width=\"100%\" style=\"background-color:#ffffcc\">");
		out.print(
				"<tr style=\"color:white; background-color:black;\"><th>Name</th><th>Date</th><th>To Whom</th><th>Location</th><th>Action</th></tr>");
		for (donation e : list) {
			out.print("<tr><td>" + e.getName() + "</td><td>" + e.getDate() + "</td><td>" + e.getTo_whom() + "</td><td>" + e.getLocation() + "</td><td><a href='donationDeleteServlet?sl="
					+ e.getSl() + "'>Delete</a></td></tr>");
		}
               
		out.print("</table>");
                }
                else{
                    out.print("U r not eligible to visit!!");
           }
                    request.getRequestDispatcher("/footer.jsp").include(request, response);
		out.close();
	}
       
        
       
}