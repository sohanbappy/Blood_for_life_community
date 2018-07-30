package com.donation;





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

@WebServlet("/donationSaveServlet")
public class SaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
                if((type.equals("General"))){    
                
                try {
                    
		String name = request.getParameter("name");
                String date = request.getParameter("date");
                String to_whom = request.getParameter("to_whom");
                String location=request.getParameter("location");
                
                donation e = new donation();
				e.setName(name);
                                e.setDate(date);
                                e.setTo_whom(to_whom);
                                e.setLocation(location);
                
                int status1 = DonationDao.save(e);
                if (status1 > 0) {
                    out.print("<p>Record saved successfully!</p>");
                    request.getRequestDispatcher("donation.jsp").include(request, response);
                } else {
                    out.println("Sorry! unable to save record");
                    request.getRequestDispatcher("donation.jsp").include(request, response);
                }
            }
	
         catch(Exception ex){
          }
                }
                else{
                    out.println("Sorry! u r not allowed!!");
                    request.getRequestDispatcher("home.jsp").include(request, response);
                }
       }
        
}