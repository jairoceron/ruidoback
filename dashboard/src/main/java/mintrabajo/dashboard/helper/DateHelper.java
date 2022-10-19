package mintrabajo.dashboard.helper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import mintrabajo.dashboard.model.dto.DateDTO;

public class DateHelper {
	private static final String GMT = "GMT-5";
	//private static final String DATE_FORMAT = "dd/MM/YYYY";
	public static Calendar getCalendar() {
		TimeZone.setDefault( TimeZone.getTimeZone(GMT));	
		Calendar now = Calendar.getInstance();
		return now;
	}
	public static List<DateDTO> getActDate(){
		 List<DateDTO> dto = new ArrayList<>();
		 dto.add(new DateDTO(dateFromData(2016,0,0), new Date()));
		 return dto;
	}
	
	public static List<DateDTO> getWeekly(){
		 List<DateDTO> dto = new ArrayList<>();
		 Calendar now = getCalendar();
		 int difToSaturday = 7-now.get(Calendar.DAY_OF_WEEK);
		 now.add(Calendar.DAY_OF_MONTH, (difToSaturday*-1));
		 Date to;
		 Date from;
		 for(int i = 0; i <4; i++) {
			 to = now.getTime();
			 now.add(Calendar.DAY_OF_MONTH, -7);
			 from = now.getTime();
			 dto.add(new DateDTO(from, to));
		 }
		 return dto;
	}	
	public static List<DateDTO> getMonthly(){
		 List<DateDTO> dto = new ArrayList<>();
		 Calendar now = getCalendar();
		 Date to = new Date();
		 Date from;
		 for(int i = 0; i <4; i++) {
			 now.set(Calendar.DAY_OF_MONTH, 0);
			 from = now.getTime();
			 dto.add(new DateDTO(from, to));
			 now.add(Calendar.DAY_OF_MONTH, -1);
			 to = now.getTime();
		 }
		 return dto;
	}
	
	public static List<DateDTO> getQuarterly(){
		 List<DateDTO> dto = new ArrayList<>();
		 Calendar now = getCalendar();
		 Date to = new Date();
		 int month = now.get(Calendar.MONTH);
		 int year = now.get(Calendar.YEAR);
		 to = now.getTime();
		 if(month<=2) {
			 //case 1
			 dto.add(new DateDTO(dateFromData(year,0,0), to));
			 dto.add(new DateDTO(dateFromData(year-1,9,0),dateFromData(year-1,11,30)));
			 dto.add(new DateDTO(dateFromData(year-1,6,0),dateFromData(year-1,8,29)));
			 dto.add(new DateDTO(dateFromData(year-1,3,0),dateFromData(year-1,5,29)));
		 } else if (month <= 5) {
			 //case 2
			 dto.add(new DateDTO(dateFromData(year,3,0), to));
			 dto.add(new DateDTO(dateFromData(year,0,0),dateFromData(year,2,30)));
			 dto.add(new DateDTO(dateFromData(year-1,9,0),dateFromData(year-1,11,30)));
			 dto.add(new DateDTO(dateFromData(year-1,6,0),dateFromData(year-1,8,29)));
		 } else if (month <=8) {
			 //case 3
			 dto.add(new DateDTO(dateFromData(year,6,0), to));
			 dto.add(new DateDTO(dateFromData(year,3,0),dateFromData(year,5,29)));
			 dto.add(new DateDTO(dateFromData(year,0,0),dateFromData(year,2,30)));
			 dto.add(new DateDTO(dateFromData(year-1,9,0),dateFromData(year-1,11,30)));
		 } else {
			 //case 4
			 dto.add(new DateDTO(dateFromData(year,9,0), to));
			 dto.add(new DateDTO(dateFromData(year,6,0),dateFromData(year,8,29)));
			 dto.add(new DateDTO(dateFromData(year,3,0),dateFromData(year,5,29)));
			 dto.add(new DateDTO(dateFromData(year,0,0),dateFromData(year,2,30)));
		 }
		 return dto;
	}
	
	public static List<DateDTO> getBiannual(){
		 List<DateDTO> dto = new ArrayList<>();
		 Calendar now = getCalendar();
		 Date to = new Date();
		 int month = now.get(Calendar.MONTH);
		 int year = now.get(Calendar.YEAR);
		 to = now.getTime();
		 if(month<=5) {
			 //case 1
			 dto.add(new DateDTO(dateFromData(year,0,0), to));
			 dto.add(new DateDTO(dateFromData(year-1,6,0),dateFromData(year-1,11,30)));
			 dto.add(new DateDTO(dateFromData(year-1,0,0),dateFromData(year-1,5,29)));
			 dto.add(new DateDTO(dateFromData(year-2,6,0),dateFromData(year-2,11,30)));
		 } else {
			 //case 4
			 dto.add(new DateDTO(dateFromData(year,6,0), to));
			 dto.add(new DateDTO(dateFromData(year,0,0),dateFromData(year,5,29)));
			 dto.add(new DateDTO(dateFromData(year-1,6,0),dateFromData(year-1,11,30)));
			 dto.add(new DateDTO(dateFromData(year-1,0,0),dateFromData(year-1,5,29)));
		 }
		 return dto;
	}
	public static List<DateDTO> getYearly(){
		 List<DateDTO> dto = new ArrayList<>();
		 Calendar now = getCalendar();
		 Date to = new Date();
		 int year = now.get(Calendar.YEAR);
		 to = now.getTime();
		 dto.add(new DateDTO(dateFromData(year,0,0), to));
		 dto.add(new DateDTO(dateFromData(year-1,0,0),dateFromData(year-1,11,30)));
		 dto.add(new DateDTO(dateFromData(year-2,0,0),dateFromData(year-2,11,30)));
		 dto.add(new DateDTO(dateFromData(year-3,0,0),dateFromData(year-3,11,30)));
		 return dto;
	}
	
	private static Date dateFromData(int year, int month, int day) {
		TimeZone.setDefault( TimeZone.getTimeZone(GMT));	
		Calendar cal  = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 1);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	public static Date stringDateToDate(String date) {
		String[] split  = date.split("-");
		Calendar data = getCalendar();
		data.set(Calendar.YEAR, Integer.parseInt(split[0]));
		data.set(Calendar.MONTH, Integer.parseInt(split[1]));
		data.set(Calendar.DAY_OF_MONTH, Integer.parseInt(split[2]));
		data.add(Calendar.MONTH, -1);
		data.set(Calendar.HOUR_OF_DAY, 0);
		data.set(Calendar.MINUTE, 1);
		data.set(Calendar.MILLISECOND, 0);
		return data.getTime();
	}
	public static String stringDateToString(String date) {
		String[] split  = date.split("-");
		return split[2]+"/"+split[1]+"/"+split[0];
	}
}
