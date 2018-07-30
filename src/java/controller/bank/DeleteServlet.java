package controller.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.general.*;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

@WebServlet("/bankDeleteServlet")
public class DeleteServlet extends HttpServlet {
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
                HttpSession session=request.getSession();
                uID=session.getAttribute("uID").toString();
                }
                catch(Exception e){
                out.print("");
                }
                if((uID.equals("admin@"))){
            
                int sl = Integer.parseInt(request.getParameter("sl"));
		BankDao.delete(sl);
		response.sendRedirect("bankViewServlet");
                }
                else{
                out.print("u r not allowed to visit!!");
                request.getRequestDispatcher("/home.jsp").include(request, response);
	}
       }
}