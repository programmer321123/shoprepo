package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import dbpackage.db;
import entitycl.cartandorders;
import entitycl.user;
import utility.otodisplay;

/**
 * Servlet implementation class getmyorders
 */
@WebServlet("/getmyorders")
public class getmyorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getmyorders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession htps = request.getSession();
		user user = (entitycl.user) htps.getAttribute("luser");
		if(user==null)return;
		db db = new db();
		List<cartandorders> orderl = db.readmorders(user.getId());
		otodisplay otd = new otodisplay();
		otd.convertorders(orderl);
		JSONObject resp = new JSONObject();
		try {
			resp.put("type", "myorders");
			resp.put("data",otd.lordertos());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write(resp.toString());
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
