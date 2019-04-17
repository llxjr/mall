package cn.funwx.mall.utils;

import java.util.UUID;

/**
 * Created by echoyu on 2016/9/19.
 * 用于生成不重复的序列
 * 1.id
 */
public class UUIDUtil {
	
	public static synchronized String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("\\-", "");
	}
	
}
