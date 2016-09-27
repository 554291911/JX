package edu.xupt.util;

import java.text.SimpleDateFormat;

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
}
