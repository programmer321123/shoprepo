package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import dbpackage.db;
import entitycl.user;

/**
 * Servlet implementation class compliteo
 */
@WebServlet("/compliteo")
public class compliteo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public compliteo() {
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
		int ido = Integer.parseInt(request.getParameter("id"));
		HttpSession htps = request.getSession();
		user user = (entitycl.user) htps.getAttribute("luser");
		if(user==null)return;
		if(!user.getType().equals("admin"))return;
        db db = new db();
        db.updateorderstate(ido, 3);
        JSONObject res = new JSONObject();
        try {
			res.put("type","oupdate");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.getWriter().write(res.toString());
	}

}
