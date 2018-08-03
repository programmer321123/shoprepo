package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbpackage.db;
import entitycl.address;
import entitycl.user;

/**
 * Servlet implementation class updatead
 */
@WebServlet("/updatead")
public class updatead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<address> la = new ArrayList<address>();
		int hm = Integer.parseInt(request.getParameter("hmad"));
		HttpSession htps = request.getSession();
		user u = (user) htps.getAttribute("luser");         
         for(int i = 0;i<hm;i++) {
        	 la.add(new address(Integer.parseInt(request.getParameter("idad"+i)),request.getParameter("street"+i),request.getParameter("zipcode"+i),request.getParameter("city"+i),u.getId()));        	 
         }
         u.setLad(la);
         db db = new db();
         db.adduser(u);
        }

}
