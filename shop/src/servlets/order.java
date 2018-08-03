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
import utility.datenum;
import utility.queryforpro;

/**
 * Servlet implementation class order
 */
@WebServlet("/order")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order() {
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
		db db = new db();
		datenum dnum = new datenum();
		int dadid = 0;
		HttpSession htps = request.getSession();
		user user = (entitycl.user) htps.getAttribute("luser");
		if(request.getParameter("adid")!=null)dadid = Integer.parseInt(request.getParameter("adid"));
		if(user==null)return;
		cartandorders cart = db.ifcartexist(user.getId());
		if(cart==null)return;
		cart.setPstate(2);
		cart.setDadid(dadid);
		cart.setDate(dnum.getdate());
		db.savecart(cart);
		JSONObject resp = new JSONObject();
		try {
			resp.put("type", "ordersent");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write(resp.toString());
	}

}
