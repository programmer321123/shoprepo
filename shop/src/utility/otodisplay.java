package utility;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import entitycl.cartandorders;
import entitycl.productcount;

public class otodisplay {
	private datenum dn = new datenum();
	private List<ordertdis> lorderstd = new ArrayList<ordertdis>();
	/*
	 * zamówienie będzie wyświetlało się w formie produkty po przecinku, cena data
	 * pobiera listę wszystkich zamówień 
	 * przetwarza zamówienie na formę do wyświetlenia
	 */
	public void convertorders(List<cartandorders> lorders) {
		for(cartandorders order:lorders) {
			ordertdis otd = new ordertdis(dn.datets(order.getDate()),order.getPstate());
			otd.setpnap(order.getLpro());
			lorderstd.add(otd);
		}
		}
	

	
	
	
	
	
	
	public String  lordertos(){
		return new Gson().toJson(lorderstd).toString();
	}
	
private class ordertdis{
	
	private String products;
	private String date;
	private double price = 0;
	private int state;
	ordertdis(String date,int state){
		this.date = date;
		this.state = state;
	}
	void setpnap(List<productcount> lp) {
		StringBuilder sb = new StringBuilder("");
		for(productcount pc :lp) {
			price += pc.getCount()*pc.getProduct().getPrice();
		    sb.append(pc.getProduct().getName() + " , ");	
		}
		if(sb.length()>2)sb.setLength(sb.length()-3);
		this.products = sb.toString();
		}
	
	
	
	}

       
        
}
