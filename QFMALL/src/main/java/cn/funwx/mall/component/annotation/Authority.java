package cn.funwx.mall.component.annotation;

import java.lang.annotation.*;

/**
 * @author chj
 * @description 需要登录权限
 * @date 2018/8/23 9:38
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authority {

    boolean required() default true;

    int code() default 0x10;
}
