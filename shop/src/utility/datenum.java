package utility;

import java.util.Calendar;

public class datenum {
	public int getdate() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return  year*10000 + month*100+day;
	}
	
	public String datets(int date) {
		StringBuilder sb = new StringBuilder("");
		if(date%100<10)sb.append("0");
		sb.append(date%100);
		sb.append(".");
		date = date/100;
		if(date%100<10)sb.append("0");
		sb.append(date%100);
		sb.append(".");
		date = date/100;
		sb.append(date);
		return sb.toString();
	}
	
}
