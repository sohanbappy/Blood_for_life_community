package controller.general;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.general.*;
import dao.general.*;

@WebServlet("/SaveServlet")
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
            try  {
                
                
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String mail = request.getParameter("mail");
                String bl_gr = request.getParameter("bl_gr");
                String age = request.getParameter("age");
                String weight = request.getParameter("weight");
                String pass = request.getParameter("pass");
                String status = request.getParameter("status");
                String last_given = request.getParameter("last_given");
                String dist = request.getParameter("dist");
                String location = request.getParameter("location");
                String req=request.getParameter("req");
                
                generalMember e = new generalMember();
               
                
                e.setName(name);
                e.setPhone(phone);
                e.setMail(mail);
                e.setBl_gr(bl_gr);
                e.setAge(age);
                e.setWeight(weight);
                e.setPass(pass);
                e.setStatus(status);
                e.setLast_given(last_given);
                e.setDist(dist);
                e.setLocation(location);
                e.setReq(req);
                
                int status1 = GeneralDao.save(e);
                if (status1 > 0) {
                    out.print("<p>Record saved successfully!</p>");
                    request.getRequestDispatcher("general.jsp").include(request, response);
                } else {
                    out.println("Sorry! unable to save record");
                    request.getRequestDispatcher("home.jsp").include(request, response);
                }
            }
            catch(Exception ex){
                    out.println("Sorry!something wrong!!");
                    request.getRequestDispatcher("home.jsp").include(request, response);
            }
	}
}