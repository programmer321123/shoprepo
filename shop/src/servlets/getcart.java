package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import dbpackage.db;
import entitycl.cartandorders;
import entitycl.user;
import utility.convettojson;
import utility.queryforpro;

/**
 * Servlet implementation class getcart
 */
@WebServlet("/getcart")
public class getcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getcart() {
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
		//queryforpro qfp = new queryforpro();
		cartandorders cart = db.readcart(user.getId());
		if(cart==null)return;		
		convettojson ctojs = new convettojson();
		JSONObject resp = new JSONObject();
		try {
			resp.put("type", "cartlist");
			resp.put("data", ctojs.carttoJson(cart.getLpro()));
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
		
		}
	
	
	
	
	


}
