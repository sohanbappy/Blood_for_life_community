package com.feedback;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.general.*;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

@WebServlet("/feedbackDeleteServlet")
public class DeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
            
                 response.setContentType("text/html");
		PrintWriter out = response.getWriter();
                String uID="";
                try{
                HttpSession session=request.getSession();
                uID=session.getAttribute("uID").toString();
                }
                catch(Exception e){
                out.print("");
                }
                if((uID!=null)&&(uID.equals("admin@"))){
                String temp = request.getParameter("sl");
		int sl = Integer.parseInt(temp);
		FeedbackDao.delete(sl);
		response.sendRedirect("feedbackViewServlet");
                
                }
                else{
                        response.sendRedirect("home.jsp");
                        }
	}
}