package com.donation;




import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.general.*;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

@WebServlet("/donationDeleteServlet")
public class DeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
                response.setContentType("text/html");
		PrintWriter out = response.getWriter();
                String type="";
                try{
                HttpSession session=request.getSession();
                type=session.getAttribute("Type").toString();
                }
                catch(Exception e){
                out.print("");
                }
                if((type.equals("General"))||(type.equals("Admin"))){
            
                String temp = request.getParameter("sl");
		int sl = Integer.parseInt(temp);
		DonationDao.delete(sl);
		response.sendRedirect("generalDash.jsp");
                }
                else{
                out.print("U r not eligible to visit!!");
                request.getRequestDispatcher("/home.jsp").include(request, response);
                }
	}
}