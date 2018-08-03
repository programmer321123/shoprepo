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

import com.google.gson.Gson;

import dbpackage.db;
import entitycl.cartandorders;
import entitycl.user;
import utility.createorderlist;

/**
 * Servlet implementation class getordersfa
 */
@WebServlet("/getordersfa")
public class getordersfa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getordersfa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int state = Integer.parseInt(request.getParameter("state"));
		HttpSession htps = request.getSession();
		user user = (entitycl.user) htps.getAttribute("luser");
		if(user==null)return;
		if(!user.getType().equals("admin"))return;
        db db = new db();
        List<cartandorders> lorders= db.getordersbstate(state);
        createorderlist crol = new createorderlist();
        crol.convertordersfa(lorders);
        JSONObject res = new JSONObject();
       try {
         res.put("type", "orders");
			 res.put("data",crol.ordersfainj());
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       response.getWriter().write(res.toString());
        /* zrób konwertowanie listy zamówień do jsona przeznaczonego do wyświetlania
           jeden obiekt ma zawierać  obiekt użytkownik imie nazwisko dane kontaktowe obiekt z  liste produktów i ich ilość, obiekt adres wysyłki 
       */
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
