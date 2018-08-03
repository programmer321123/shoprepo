package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import dbpackage.db;
import entitycl.product;
import utility.queryforpro;

/**
 * Servlet implementation class getproducts
 */
@WebServlet("/getproducts")
public class getproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getproducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		double price = 0;
		if(!request.getParameter("price").equals(""))price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		String sorting = request.getParameter("sorting");
		queryforpro qfp = new queryforpro();
		int ifactive = Integer.parseInt(request.getParameter("active"));
		String query = qfp.queryfpro(name, price, category, sorting,ifactive);
		System.out.println("Query " + query);
		db db = new db();
		List<product> lpro = db.getproducts(query);
		JSONObject job = new JSONObject();
		try {
			job.put("type", "products");
			job.put("data",  new Gson().toJson(lpro));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write(job.toString());
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
