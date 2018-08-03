package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import dbpackage.db;
import entitycl.user;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		user nuser = new user(request.getParameter("login"),request.getParameter("password"),request.getParameter("name"),request.getParameter("surname"),request.getParameter("phonenumber"),request.getParameter("mail"),"client");
		db db = new db();
		String result;
		if(!db.iflexists(nuser.getLogin())) {
			db.adduser(nuser);
			result = "good";
		}else {
			result = "This login already exist";
		}
		JSONObject resp = new JSONObject();
		try {
			resp.put("type", "regres");
			resp.put("result",result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			response.getWriter().write(resp.toString());
		
	}

}
