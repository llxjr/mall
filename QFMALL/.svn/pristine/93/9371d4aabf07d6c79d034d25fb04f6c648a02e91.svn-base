package cn.funwx.mall.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.funwx.mall.exception.BusinessException;

public class DateUtil extends org.apache.commons.lang.time.DateUtils {
	
	public static boolean sameDate(Date d1, Date d2){  
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");  
	    //fmt.setTimeZone(new TimeZone()); // 如果需要设置时间区域，可以在这里设置  
	    return fmt.format(d1).equals(fmt.format(d2));  
	} 
	
	public static String getDay(Date date){
		 SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		 return dateFm.format(date);
	}
	
	public static List<Date> dateToWeek(Date mdate) {  
	    int b = mdate.getDay();  
	    Date fdate;  
	    if (b == 0){
	    	b=7;
	    }
	    List<Date> list = new ArrayList<Date>();  
	    Long fTime = mdate.getTime() - b * 24*3600000;  
	    for(int a = 1; a <= 7; a++) {  
	        fdate = new Date();  
	        fdate.setTime(fTime + (a * 24*3600000)); //一周从周一开始算，则使用此方式   
//	        fdate.setTime(fTime + ((a-1) * 24*3600000));  //一周从周日开始算，则使用此方式
	        list.add(a-1, fdate);  
	    }  
	    return list;  
	}  
	
	public static String formatDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return format.format(date);
	}

	public static String formatDate(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static Date parseDate(String date) {
		SimpleDateFormat format;
		try {
			if (date.indexOf("/") > 0) {
				if (date.length() > 12)
					format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				else
					format = new SimpleDateFormat("yyyy/MM/dd");
				return format.parse(date);
			}else if(date.indexOf("-")>0){
				if (date.length() > 12)
					format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				else
					format = new SimpleDateFormat("yyyy/MM/dd");
				return format.parse(date);
			}else{
				if (date.length() > 8)
					format = new SimpleDateFormat("yyyyMMddHHmmss");
				else
					format = new SimpleDateFormat("yyyyMMdd");
				return format.parse(date);
			}
		} catch (ParseException e) {
			throw new BusinessException(e);
		}
	}

	public static Date parseDate(String date, String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			throw new BusinessException(e);
		}
	}

	public static Date getStartDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			return format.parse("1900/01/01 00:00:00");
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date getEndDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			return format.parse("2100/01/01 00:00:00");
		} catch (ParseException e) {
			throw new BusinessException(e);
		}
	}

	public static Date getStartToday(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			return timeFormat.parse(dateFormat.format(date == null ? new Date() : date) + " 00:00:00");
		} catch (ParseException e) {
			throw new BusinessException(e);
		}
	}

	public static Date getEndToday(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			return timeFormat.parse(dateFormat.format(date == null ? new Date() : date) + " 23:59:59");
		} catch (ParseException e) {
			throw new BusinessException(e);
		}
	}
	public static String getCurrentDate(){
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
	    String currentDateTime = tempDate.format(new java.util.Date());
	    return currentDateTime;
	}
	public static String getCurrentDateNum(){
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMdd");
		String currentDateTime = tempDate.format(new java.util.Date());
		return currentDateTime;
	}
	public static String getCurrentDateTime(){
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = tempDate.format(new java.util.Date());
		return currentDateTime;
	}
	public static String getCurrentMillDateTime(){
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String currentDateTime = tempDate.format(new java.util.Date());
		return currentDateTime;
	}
	public static String getCurrentMillDateTimeNum(){
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String currentDateTime = tempDate.format(new java.util.Date());
		return currentDateTime;
	}
	public static String getCurrentLongMillDateTimeNum(){
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS");
		String currentDateTime = tempDate.format(new java.util.Date());
		return currentDateTime;
	}
	public static String getCurrentDateTimeNum(){
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDateTime = tempDate.format(new java.util.Date());
		return currentDateTime;
	}
	
	public static long getStringToDate(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try{
			date = sdf.parse(time);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}
	
}
