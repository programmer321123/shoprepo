package dbpackage;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entitycl.address;
import entitycl.image;
import entitycl.product;
import entitycl.productcount;
import entitycl.cartandorders;
import entitycl.user;
public class db {
		private static SessionFactory sf;
		static {
			sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(user.class).addAnnotatedClass(product.class).addAnnotatedClass(image.class).addAnnotatedClass(cartandorders.class).addAnnotatedClass(address.class).addAnnotatedClass(productcount.class).buildSessionFactory();
		}	
		
		public void adduser(user user) {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
		    session.saveOrUpdate(user);
			session.getTransaction().commit();
		}
		
		public boolean iflexists(String login) {
		    user u = null;
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			try {
				u =(user)session.createQuery("from user u where u.login='"+login+"'").getSingleResult();
			}catch(NoResultException e) {
				e.printStackTrace();
			}finally {
			    session.getTransaction().commit();
			    }
			if(u!=null)return true;
			return false;
		}
		
		public user login(String login, String password) {
			user user = null;
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			try {
				user = (user)session.createQuery("from user u where u.login='"+login +"' and u.password = '"+password+"'").getSingleResult();
			}catch(NoResultException e) {
				e.printStackTrace();
			}finally {
			    session.getTransaction().commit();
			    }
			return user;
		}
		public int sendproduct(product product) {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
		    session.saveOrUpdate(product);
			session.getTransaction().commit();
			return product.getId();
		}
		
		
		public List<product> getproducts(String query){
			Session session = sf.getCurrentSession();
			session.beginTransaction();
		     List<product> lpro = session.createQuery(query).getResultList();
			 session.getTransaction().commit();
			 return lpro;
		}
		
		public void savecart(cartandorders cart){
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(cart);
			session.getTransaction().commit();
		}
		
		public cartandorders readcart(int idwho) {
			cartandorders cart =null;
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			try {
			 cart = (cartandorders)session.createQuery("from cartandorders cartao where cartao.idwho ='"+idwho+"' and cartao.pstate='1'").getSingleResult();
			}catch(NoResultException e) {
				e.printStackTrace();
			}finally {
			    session.getTransaction().commit();
			    }
			 return cart;
		}
		
		
		public cartandorders ifcartexist(int idwho) {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			cartandorders cart = null;
			 try { 
			    cart = (cartandorders) session.createQuery("from cartandorders cartao where cartao.idwho ='"+idwho+"' and cartao.pstate='1'").getSingleResult();
			 }catch(NoResultException e) {
			   	e.printStackTrace();
	   	     }finally {
			    session.getTransaction().commit();
			 }
			 return cart;
		}
		
		public List<cartandorders> readmorders(int idu) {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
		    List<cartandorders> lorders = session.createQuery("from cartandorders cartao where cartao.idwho ='"+idu+"' and cartao.pstate='2' or cartao.pstate='3'").getResultList();
			session.getTransaction().commit();
			 return lorders;
		}
		
		
		public void addptoct(productcount p) {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(p);
			session.getTransaction().commit();
		}
		
		public List<cartandorders> getcartaop(String query){
			Session session = sf.getCurrentSession();
			session.beginTransaction();
		     List<cartandorders> lp = session.createQuery(query).getResultList();
			 session.getTransaction().commit();
			 return lp;
		}
		
		
	 public void deleteprofct(productcount pc) {
		 Session session = sf.getCurrentSession();
		 session.beginTransaction();
		 session.delete(pc);	
		 session.getTransaction().commit();
	 }
		
		
		
		
		
		public void updateorderstate(int id,int state) {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update  cartandorders cartao set cartao.pstate ='"+state+"' where cartao.id ='"+id+"'").executeUpdate();
			  session.getTransaction().commit();
		}
		
		public List<cartandorders>getordersbstate(int state){
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			List<cartandorders> lorders = (List<cartandorders>) session.createQuery("from cartandorders order where order.pstate='"+state+"'").getResultList();
			session.getTransaction().commit();
			return lorders;
			}
		
		public user getuserbyId(int idu){
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			user u = (user) session.createQuery("from user user where user.id='"+idu+"'");
			session.getTransaction().commit();
			return u;
		}
		
		public address getadbyId(int idad) {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			address ad = (address) session.createQuery("from address ad where ad.idad='"+idad+"'");
			session.getTransaction().commit();
			return ad;
		}
		
		
		
		/*public void updateuser(user user){
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update user u set pinc.count ='"+pc.getCount()+"' where pinc.idpro ='"+pc.getIdpro()+"' and pinc.idwho='"+pc.getIdwho()+"'").executeUpdate();
			  session.getTransaction().commit();
		}*/
		
		

	}


