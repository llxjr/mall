package cn.funwx.mall.utils;

import java.util.Random;

public class RandomNumberUtil {

	/**
	 * 生成length位随机数字
	 * @param length
	 * @return
	 */
	public static String getStringRandom(int length){
		StringBuilder val = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length ; i++){
			val.append(random.nextInt(10));
		}
		//长度异常
		if (val.length() != length) {
			 return getStringRandom(length);
		}
		return val.toString();
	}

}
