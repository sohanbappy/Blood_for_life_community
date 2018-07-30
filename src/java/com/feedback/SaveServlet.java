package com.feedback;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.general.*;
import dao.general.*;

@WebServlet("/feedbackSaveServlet")
public class SaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
                 PrintWriter out = response.getWriter();
            try    
                {
                
                
		String name = request.getParameter("name");
                String date = request.getParameter("date");
                String comments = request.getParameter("comments");
                
                feedback e = new feedback();
                 
				e.setName(name);
                                e.setDate(date);
                                e.setComments(comments);
                                
                int status1 = FeedbackDao.save(e);
                if (status1 > 0) {
                    out.print("<p>Record saved successfully!</p>");
                    request.getRequestDispatcher("feedback.jsp").include(request, response);
                } else {
                    out.println("Sorry! unable to save record");
                    request.getRequestDispatcher("feedback.jsp").include(request, response);
                }
            }
            catch(Exception ex){
            
            }
	}
}