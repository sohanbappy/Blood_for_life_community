package com.notice;



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

@WebServlet("/noticeSaveServlet")
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
                
                String uID="";
                try{
                HttpSession session=request.getSession();
                uID=session.getAttribute("Type").toString();
                }
                catch(Exception e){
                out.print("");
                }
                if((uID.equals("General"))||(uID.equals("Admin"))){
             
                try   
                 {
              
		String title = request.getParameter("title");
                String gr = request.getParameter("gr");
                String unit = request.getParameter("unit");
                String dist = request.getParameter("dist");
                String location=request.getParameter("location");
                String contact = request.getParameter("contact");
                String date = request.getParameter("date");
                String published_by = request.getParameter("published_by");
                
                               notice e = new notice();
				e.setTitle(title);
                                e.setGr(gr);
                                e.setUnit(unit);
                                e.setDist(dist);
                                e.setLocation(location);
                                e.setContact(contact);
                                e.setDate(date);
                                e.setPublished_by(published_by);
                
                int status1 = NoticeDao.save(e);
                if (status1 > 0) {
                    out.print("<p>Record saved successfully!</p>");
                    request.getRequestDispatcher("notice.jsp").include(request, response);
                } else {
                    out.println("Sorry! unable to save record");
                    request.getRequestDispatcher("notice.jsp").include(request, response);
                }
            }
            catch(Exception e)
            {
            
            }
                }
                else{
                out.println("Sorry! u r not eligible to visit!!");
                    request.getRequestDispatcher("home.jsp").include(request, response);
                }
	}
}