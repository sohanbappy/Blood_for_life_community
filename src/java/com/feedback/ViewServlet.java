package com.feedback;


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

@WebServlet("/feedbackViewServlet")
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
                
		
		out.println("<h1>Feedback List</h1>");

                String uID="";
                try{
                HttpSession session=request.getSession(false);
                uID=session.getAttribute("uID").toString();
                }
                catch(Exception e){
                out.print("");
                }
                
		
                
		List<feedback> list = FeedbackDao.getAllFeedbacks();
                
                if(uID.equals("admin@")){
                    
		out.print("<table border=\"1\" class=\"table\" width=\"100%\" style=\"background-color:#ffffcc\">");
		out.print(
				"<tr style=\"color:white; background-color:black;\"><th>Name</th><th>Date</th><th>Comments</th><th>Action</th></tr>");
		for (feedback e : list) {
			out.print("<tr><td>" + e.getName() + "</td><td>" + e.getDate() + "</td><td>" + e.getComments() + "</td><td><a href='feedbackDeleteServlet?sl="
					+ e.getSl() + "'>Delete</a></td></tr>");
		
                }
                out.print("</table>");
               }
                else{
                

		out.print("<table border=\"1\" class=\"table\" width=\"100%\" style=\"background-color:#ffffcc\">");
		out.print(
				"<tr style=\"color:white; background-color:black;\"><th>Name</th><th>Date</th><th>Comments</th></tr>");
		for (feedback e : list) {
			out.print("<tr><td>" + e.getName() + "</td><td>" + e.getDate() + "</td><td>" + e.getComments() + "</td></tr>");
                }
		out.print("</table>");
	      }
                
                request.getRequestDispatcher("/footer.jsp").include(request, response);
		out.close();
       }
}