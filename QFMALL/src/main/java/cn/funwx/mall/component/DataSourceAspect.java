package cn.funwx.mall.component;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 数据源切面
 * @author chj
 * @date 2017-11-6
 *
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("execution(* cn.funwx.mall.service.*.*(..))")
	 public void aspect() {
     }
      
    @Before(value = "aspect()")  
     public void before(JoinPoint point)  
     {  
    	String className = point.getTarget().getClass().getName();
        String method = point.getSignature().getName();
        logger.info(className + "." + method + "(" + StringUtils.join(point.getArgs(), ",") + ")");
        try {
            for (String key : ChooseDataSource.METHOD_TYPE_MAP.keySet()) {
                for (String type : ChooseDataSource.METHOD_TYPE_MAP.get(key)) {
                    if (method.startsWith(type)) {
                        HandleDataSource.putDataSource(key);
                        System.out.println("start mysql operate : " + key);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     }  
}
