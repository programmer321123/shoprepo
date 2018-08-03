package utility;

import java.util.List;

import entitycl.address;
import entitycl.productcount;

public class convettojson {
	
	
	public String carttoJson(List<productcount> lp) {
		StringBuilder sb = new StringBuilder("[");
		for(productcount pro:lp) {
			sb.append(pro.getProduct().toJson(pro.getCount()));
			sb.append(",");
		}
		sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
	
	public String adtos(List<address> la) {
		StringBuilder sb = new StringBuilder("[");
		for(address ad : la) {
    		System.out.println(ad.toString());
    		sb.append(ad.toString());
    		sb.append(",");
    	}
		sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
		
	}

}
