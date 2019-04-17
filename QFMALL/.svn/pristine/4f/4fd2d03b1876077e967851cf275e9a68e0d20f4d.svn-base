package cn.funwx.mall.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class RenderMap{

	public static Map returnMap(Map map,int code){
		return returnMap(map, code, null);
	}
	
	public static Map returnMap(Map map,int code,String message){
		return returnMap(map, code, message, null);
	}
	
	
	public static Map returnMap(Map map,int code,String message,String date){
		map.put("code", code);
		map.put("message", message);
		map.put("date", date);
		return map;
	}
}
