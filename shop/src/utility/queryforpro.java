package utility;

public class queryforpro {

	public String queryfpro(String name,double price,String category,String sorting,int ifactive) {
		System.out.println("Dane wyszukiwania " + name + " " + price + " " + category + " " + sorting);
		boolean ifadand = false;
		StringBuilder  sb= new StringBuilder("from product  ");
		if(!name.equals("")||price!=0||!category.equals("category")||ifactive==1) {
			sb.append("where ");
		}
		
		if(!name.equals("")) {
			sb.append("name LIKE '%"+name+"%' ");
			ifadand = true;
		}
		if(price!=0){
			if(ifadand) {
			 sb.append(" AND ");
			}
			sb.append("price < "+price);
			ifadand = true;
		}
		
         if(ifactive==1) {
        	 if(ifadand) {
    			 sb.append(" AND ");
    			}
    			sb.append(" ifactive = '1'");
    			ifadand = true;
		}
		if(!category.equals("category")) {
			if(ifadand) {
				 sb.append(" AND ");
				}
			sb.append("category = '"+category+"' ");
		}
		switch(sorting) {
		case "alphabetical":
			sb.append(" ORDER BY name");
			break;
		case "from highest price":
			sb.append(" ORDER BY price DESC");
			break;
		case "from lowest price":
			sb.append(" ORDER BY price");
			break;
		}
		
		return sb.toString();
	}
	
	
	public String crqueryfcao(int idu,int ifca) {
		StringBuilder sb = new StringBuilder();
		sb.append("from cartandorders cartao where cartao.idwho='"+idu+"' and ");
		if(ifca==1) {
			sb.append("cartao.pstate ='1'");
		}else {
			sb.append("cartao.pstate ='2' or cartao.pstate ='3'");
		}
		return sb.toString();
	}
}
