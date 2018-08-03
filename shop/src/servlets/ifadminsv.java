package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entitycl.user;

/**
 * Servlet implementation class ifadminsv
 */
@WebServlet("/foradmin")
public class ifadminsv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ifadminsv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sprawdzam czy jesteś admin");
		HttpSession htps = request.getSession();
		user u = (user) htps.getAttribute("luser");
		if(u==null) {
			request.getRequestDispatcher("/index.html").forward(request,response);
			System.out.println("nie jesteś admin bo jesteś null");
			}else {
		if(!u.getType().equals("admin")) {
			request.getRequestDispatcher("/index.html").forward(request,response);
			System.out.println("nie jesteś admin no nie");
		}else {
			System.out.println("jesteś admin");
			request.getRequestDispatcher("/foradmin.html").forward(request,response);
		}
		
			}

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
