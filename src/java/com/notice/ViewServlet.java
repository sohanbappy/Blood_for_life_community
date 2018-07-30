package com.notice;



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

@WebServlet("/noticeViewServlet")
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
                HttpSession session=request.getSession(false);
                uID=session.getAttribute("uID").toString();
                }
                catch(Exception e){
                out.print("");
                }
                if((uID.equals("admin@"))){
		
		out.println("<h1>Notice List</h1>");

		List<notice> list = NoticeDao.getAllNotices();

		out.print("<table border=\"1\" class=\"table\" width=\"100%\" style=\"background-color:#ffffcc\">");
		out.print(
				"<tr style=\"color:white; background-color:black;\"><th>Title</th><th>Bl. group</th><th>Unit(bags)</th><th>District</th><th>Location</th><th>Contact</th><th>Date</th><th>Published By</th><th>Action</th></tr>");
		for (notice e : list) {
			out.print("<tr><td>" + e.getTitle() + "</td><td>" + e.getGr() + "</td><td>" + e.getUnit() + "</td><td>" + e.getDist() + "</td><td>"
				+ e.getLocation() + "</td><td>" + e.getContact() + "</td>"+ "<td>" + e.getDate() + "</td><td>" + e.getPublished_by() + "</td><td><a href='noticeDeleteServlet?sl="
					+ e.getSl() + "'>Delete</a></td></tr>");
		}
		out.print("</table>");
                
                out.println("<a href='notice.jsp' style='color:white;'>Add New Notice</a>");
                out.print("<h1>Visitor is: </h1>"+uID);
                }
                //for All
               else{
                
                    out.println("<h1>Notice List</h1>");

		List<notice> list = NoticeDao.getAllNotices();

		out.print("<table border=\"1\" class=\"table\" width=\"100%\" style=\"background-color:#ffffcc\">");
		out.print(
				"<tr style=\"color:white; background-color:black;\"><th>Title</th><th>Bl. group</th><th>Unit(bags)</th><th>District</th><th>Location</th><th>Contact</th><th>Date</th><th>Published By</th></tr>");
		for (notice e : list) {
			out.print("<tr><td>" + e.getTitle() + "</td><td>" + e.getGr() + "</td><td>" + e.getUnit() + "</td><td>" + e.getDist() + "</td><td>"
				+ e.getLocation() + "</td><td>" + e.getContact() + "</td>"+ "<td>" + e.getDate() + "</td><td>" + e.getPublished_by() + "</td></tr>");
		}
		out.print("</table>");
                 
                }
                
                request.getRequestDispatcher("/footer.jsp").include(request, response);
		out.close();
	}
}