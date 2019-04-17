package cn.funwx.mall.controller.base;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.funwx.mall.exception.UnauthorizedException;

/** 
 * 
 * @author  liu66
 * 
 */
@ControllerAdvice
@SuppressWarnings("all")
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseBody
	public Map<String, Object> handlerUnauthorEx() {
		Map map = new HashMap();
		map.put("code", 403);
		map.put("msg", "unauthorized request!");
		return map;
	}
}
