package cn.funwx.mall.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * copyList工具类
 * @author Administrator
 *
 * @param <S>
 * @param <T>
 */
public class CopyListUtil<S, T> {

	    private Class<T> targetType;
	    
	    public CopyListUtil(Class<T> targetType) {
	        this.targetType = targetType;
	    }
	    
	    public List<T> copy(List<S> src) {
	        List<T> target = new ArrayList<T>();
	        for ( S s : src ) {
	            T t = BeanUtils.instantiateClass(targetType);
	            BeanUtils.copyProperties(s, t);
	            target.add(t);
	        }
	        return target;
	    }
}
