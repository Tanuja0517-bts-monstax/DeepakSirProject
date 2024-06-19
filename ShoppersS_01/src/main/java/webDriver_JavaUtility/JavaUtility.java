package webDriver_JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random=new Random();
		int num=random.nextInt(500);
		
		return num;
	}
	
	public String getSystemDate() {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String date=sdf.format(d);
		
		return date;
	}
	
	public String generateDateBeforeSpecifiedDays(int diff,String basedOn) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String date=sdf.format(d);
		System.out.println("Simple Date Format:"+date);
		Calendar cal=sdf.getCalendar();
		if(basedOn.equalsIgnoreCase("month"))
			cal.add(Calendar.DAY_OF_MONTH, diff);
		else if(basedOn.equalsIgnoreCase("week"))
			cal.add(Calendar.DAY_OF_WEEK, diff);
		else if(basedOn.equalsIgnoreCase("year"))
			cal.add(Calendar.DAY_OF_YEAR, diff);
		String dateReq=sdf.format(cal.getTime());
		
		System.out.println("Date Req:"+dateReq);
		  
		return dateReq;
	}
}
