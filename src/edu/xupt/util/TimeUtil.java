package edu.xupt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	//精确到天
	public String getNowDate(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date date=new java.util.Date();  
		String str=sdf.format(date); 
		return str;
	}
	//精确到分
	public String getNowtime(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:MM");  
		java.util.Date date=new java.util.Date();  
		String str=sdf.format(date); 
		return str;
	}
	
	public static Date stringToDate(String str) throws ParseException{
		if(str.equals("")){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		return date;
	}
}
