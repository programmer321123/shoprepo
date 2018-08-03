package servlets;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import dbpackage.db;
import entitycl.product;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import utility.imgoperations;

/**
 * Servlet implementation class uppro
 */
@WebServlet("/uppro")
@MultipartConfig
public class uppro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uppro() {
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
		int icount =Integer.parseInt(request.getParameter("icount"));
		int id =Integer.parseInt(request.getParameter("id"));
		int active = Integer.parseInt(request.getParameter("active"));
		//System.out.println(request.getParameter("name") + request.getParameter("description") + Double.parseDouble(request.getParameter("price")));		
		 System.out.println("ile zdjec  " +icount);
		 product nproduct = new product(id,request.getParameter("name"),request.getParameter("description"),Double.parseDouble(request.getParameter("price")),icount,request.getParameter("category"),active);
		db db = new db();
		db.sendproduct(nproduct);
		System.out.println(" id" + nproduct.getId());
		if(nproduct.getId()==0)sendres("error",response);
		 imgoperations imgo = new imgoperations();
		 for(int i = 0; i<icount;i++) {
			 System.out.println("i img " + i);
			 if(imgo.scaleimg(request.getPart("img"+i).getInputStream(),1024,680)) {
					if(!imgo.saveimg(nproduct.getId(), nproduct.getName(), i))sendres("error",response);;
		
				}else{
					response.getWriter().write("error");
				}
		 }
		 sendres("sent",response);
	}
	
	
	private void sendres(String res,HttpServletResponse response) {
		 JSONObject  job = new JSONObject();
		    try {
				job.put("type","uppro");
				  job.put("result", res);
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
