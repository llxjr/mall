package cn.funwx.mall.component;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 捕获未处理异常
 * @author chj
 * @date 2018-1-17
 *
 */
@Aspect
@Component
public class LogAspect {
	
	private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);
	
	@AfterThrowing(throwing="ex", pointcut="execution(* cn.funwx.mall.service.*.*(..))")
	public void LogUnCatchEx(JoinPoint joinPoint, Throwable ex) {
		
		int line = ex.getStackTrace()[0].getLineNumber();
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		Object[] args = joinPoint.getArgs();
		
		StringBuilder argStr = new StringBuilder();
		if (args.length > 0) {
			for (Object arg : args) {
				argStr.append(arg + ",");
			}
		}
		System.out.println("时间:" + new Date() + ",错误方法" + signature.getMethod());
		System.out.println(",错误行:" + line + ",错误参数:" + args);
		System.out.println("异常内容:" + ex.toString());
		LOG.error(
				"时间:" + new Date() + ",错误方法" + signature
				+ ",错误行:" + line + ",错误参数:" + args 
				+ "异常内容:" + ex.toString() );
	}
}
