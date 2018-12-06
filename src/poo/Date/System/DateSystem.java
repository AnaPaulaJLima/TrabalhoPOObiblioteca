package poo.Date.System;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSystem implements Data{

	
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	public Date getDataSystem() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		DateSystem dataSystem = new DateSystem();
		try {
			data = formato.parse(dataSystem.getDateTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
	public Date adicionarDias(int dias) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, + dias);
		String d = formato.format(c.getTime()); 
		
		
		
		
		Date data = new Date();
		try {
			data = formato.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
	

}
