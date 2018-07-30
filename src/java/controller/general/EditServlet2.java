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
import javax.servlet.http.HttpSession;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
                
                String type="";
                
                try{
                HttpSession session=request.getSession();
                type=session.getAttribute("Type").toString();
                }
                catch(Exception e1){
                out.print("");
                }
                if((type.equals("General"))||(type.equals("Admin"))){
                

		int sl = Integer.parseInt(request.getParameter("sl"));
		String name = request.getParameter("name");
                String phone= request.getParameter("phone");
		String mail = request.getParameter("mail");
                String bl_gr= request.getParameter("bl_gr");
                String age= request.getParameter("age");
                String weight= request.getParameter("weight");
		String pass = request.getParameter("pass");
		String status = request.getParameter("status");
                String last_given=request.getParameter("last_given");
		String dist = request.getParameter("dist");
                String location=request.getParameter("location");
                String req=request.getParameter("req");
                
                //storing
		generalMember e = new generalMember();
		e.setSl(sl);
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
                
		 String uID="";
		int status1 = GeneralDao.update(e);
		if (status1 > 0) {
               
                try{
                HttpSession session=request.getSession();
                uID=session.getAttribute("uID").toString();
                }
                catch(Exception e1){
                out.print("");
                }
                if((uID.equals("admin@"))){
		
			response.sendRedirect("ViewServlet");
		}
                else{
                       response.sendRedirect("generalDash.jsp");
                }
               }
                else {
			out.println("Sorry! unable to update record");
		 }
                }
                else{
                       response.sendRedirect("home.jsp");
                }
                
                
		out.close();
	}

}