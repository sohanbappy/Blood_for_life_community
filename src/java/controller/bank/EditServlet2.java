package controller.bank;


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

@WebServlet("/bankEditServlet2")
public class EditServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
                String uID="";
                
                try{
                HttpSession session=request.getSession();
                uID=session.getAttribute("Type").toString();
                }
                catch(Exception e1){
                out.print("");
                }
                if((uID.equals("bb"))||(uID.equals("Admin"))){
                
		int sl = Integer.parseInt(request.getParameter("sl"));
		String name = request.getParameter("name");
                String auth_id = request.getParameter("auth_id");
                String phone= request.getParameter("phone");
                String dist = request.getParameter("dist");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
                String gr_a1 = request.getParameter("gr_a1");
                String gr_a2 = request.getParameter("gr_a2");
                String gr_b1 = request.getParameter("gr_b1");
                String gr_b2 = request.getParameter("gr_b2");
                String gr_o1 = request.getParameter("gr_o1");
                String gr_o2 = request.getParameter("gr_o2");
                String gr_ab1 = request.getParameter("gr_ab1");
                String gr_ab2 = request.getParameter("gr_ab2");
                String conditions = request.getParameter("conditions");
                String location=request.getParameter("location");
                 String req=request.getParameter("req");
                
                //storing
		bankMember e = new bankMember();
                                e.setSl(sl);
				e.setName(name);
                                e.setAuth_id(auth_id);
                                e.setPhone(phone);
                                e.setDist(dist);
                                e.setMail(mail);
                                e.setPass(pass);
                                e.setGr_a1(gr_a1);
                                e.setGr_a2(gr_a2);
                                e.setGr_b1(gr_b1);
                                e.setGr_b2(gr_b2);
                                e.setGr_o1(gr_o1);
                                e.setGr_o2(gr_o2);
                                e.setGr_ab1(gr_ab1);
                                e.setGr_ab2(gr_ab2);
                                e.setConditions(conditions);
                                e.setLocation(location);
                                e.setReq(req);
		
		
		int status1 = BankDao.update(e);
		if (status1 > 0) {
                if((uID.equals("Admin"))){
		
			response.sendRedirect("bankViewServlet");
		}
                else{
                       response.sendRedirect("bankDash.jsp");
                }
               }
                else {
			out.println("Sorry! unable to update record");
                        request.getRequestDispatcher("home.jsp").include(request, response);
		 }
                }
                else{
                       response.sendRedirect("bankDash.jsp");
                }
		out.close();
	}

}