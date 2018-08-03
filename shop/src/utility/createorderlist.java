package utility;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import entitycl.address;
import entitycl.cartandorders;
import entitycl.product;
import entitycl.productcount;
import entitycl.user;


public class createorderlist {
	
	private datenum dn = new datenum();
	private List<ordertdis> lorderstd = new ArrayList<ordertdis>();
	/*
	 * zamówienie będzie wyświetlało się w formie produkty po przecinku, cena data
	 * pobiera listę wszystkich zamówień 
	 * przetwarza zamówienie na formę do wyświetlenia
	 */
	public void convertordersfa(List<cartandorders> lorders) {
		for(cartandorders order:lorders) {
			ordertdis otd = new ordertdis(order.getId(),dn.datets(order.getDate()),order.getPstate(),order.getDelad().getStreet(), order.getDelad().getZipcode(),order.getDelad().getStreet(), order.getDelad().getUs().getName(),order.getDelad().getUs().getSurname(),order.getDelad().getUs().getPhonenumber(), order.getDelad().getUs().getMail());
			otd.setpnap(order.getLpro());
			lorderstd.add(otd);
		}
		}
	

	
	
	
	
	
	
	public String  ordersfainj(){
		return new Gson().toJson(lorderstd).toString();
	}
	
private class ordertdis{
	private int id; 
	private String products;
	private String date;
	private double price = 0;
	private int state;
	private String street;
	private String zipcode;
	private String city;
	private String name;
	private String surname;
	private String pnumber;
	private String mail;
	ordertdis(int id,String date,int state, String street, String zipcode, String city, String name, String surname, String pnumber, String mail){
		this.date = date;
		this.state = state;
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
		this.name = name;
		this.surname = surname;
		this.pnumber = pnumber;
		this.mail = mail;
		this.id = id;
	}
	void setpnap(List<productcount> lp) {
		StringBuilder sb = new StringBuilder("[");
		for(productcount pro:lp) {
			price += pro.getCount()*pro.getProduct().getPrice();
			sb.append(pro.getProduct().toJson(pro.getCount()));
			sb.append(",");
		}
		sb.setLength(sb.length()-1);
		sb.append("]");
		products = sb.toString();
		}
	
	
	
	}
}
