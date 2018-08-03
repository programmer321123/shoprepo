package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import dbpackage.db;
import entitycl.address;
import entitycl.user;
import utility.convettojson;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		user user;
		convettojson ctojs = new convettojson();
		HttpSession htps = request.getSession();
		user = (user) htps.getAttribute("luser");
		if(user==null) {
		db db = new db();
	     user = db.login(request.getParameter("login"), request.getParameter("password"));
	      if(user==null) {
		   sendres("bad","",null,response);
		   return;
	      }
	      htps.setAttribute("luser",user);
		}
	    	System.out.println("ile adresów  " + user.getLad().size());
	    	sendres("good",user.toString(),ctojs.adtos(user.getLad()),response);
	  
	}
	
	
	
	
	private void sendres(String res,String us,String la,HttpServletResponse response) {
		 JSONObject  job = new JSONObject();
		    try {
				job.put("type","log");
				  job.put("result", res);
				  job.put("user",us);
				 job.put("lad",la);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		   try {
			response.getWriter().write(job.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
