package servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbpackage.db;
import entitycl.cartandorders;
import entitycl.productcount;
import entitycl.user;
import utility.datenum;

/**
 * Servlet implementation class addtocart
 */
@WebServlet("/addtocart")
public class addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
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
		// TODO Auto-generated method stub
		 cartandorders cart = null;
		db db = new db();
		HttpSession htps = request.getSession();
		user user = (user) htps.getAttribute("luser");
		datenum dnum = new datenum();
		if(user==null)return;
		System.out.println("dodaje do koszyka");
		//Integer.parseInt(request.getParameter("count"))  ,Integer.parseInt(request.getParameter("idpro"))
		//cartandorders pinc = new cartandorders(user.getId(),dnum.getdate(),1);
	
		 cart = db.ifcartexist(user.getId());
		 System.out.println("Sprawdziłczy koszyk istnieje");
		 if(cart==null) {
			 System.out.println("Dodaje nowy koszyk");
			 cart = new cartandorders(user.getId(),dnum.getdate(),1);
			 db.savecart(cart);
		 }
		 productcount pc = new productcount(Integer.parseInt(request.getParameter("count"))  ,Integer.parseInt(request.getParameter("idpro")),cart.getId());
		 System.out.println("doddaje produkt do koszyka");
		 pc.setIdpc(cart.idodpc(pc.getIdpro()));
		 System.out.println("Zapisuje produkt");
		 db.addptoct(pc);
				 
		 
	}
	
	

}
