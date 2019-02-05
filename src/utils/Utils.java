package utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static Utils instance;
	
	public static Date convertStringToDate(String s) {
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			// transforma a variavel String em data
			date = (java.util.Date) formatter.parse(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date convertStringToDateHour(String s) {
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			// transforma a variavel String em data
			date = (java.util.Date) formatter.parse(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Integer convertStringToInteger(String s) {
		return Integer.parseInt(s);
	}
	
	public static BigDecimal convertStringToDecimal(String s) {
		if(s.contains(",")) {
			s = s.replace(",", ".");
		}
		return new BigDecimal(s);
	}
	
	public static boolean isNull(Object object) {
		if(object != null) {
			return false;
		}
		return true;
	}
	
	public static boolean isNotNull(Object object) {
		if(object != null) {
			return true;
		}
		return false;
	}
}
