package testCases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

import webDriver_JavaUtility.JavaUtility;

public class DataFormatTest {
		public static void main(String args[]) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String date=sdf.format(d);
		System.out.println("Simple Date Format:"+date);
		Calendar cal=sdf.getCalendar();
		if("Month".equalsIgnoreCase("month"))
			cal.add(Calendar.DAY_OF_MONTH, -30);
		else if("Week".equalsIgnoreCase("week"))
			cal.add(Calendar.DAY_OF_WEEK, -30);
		else if("year".equalsIgnoreCase("year"))
			cal.add(Calendar.DAY_OF_YEAR, -30);
		String dateReq=sdf.format(cal.getTime());
		
		System.out.println("Date Req:"+dateReq);
		  
		
	}
}
