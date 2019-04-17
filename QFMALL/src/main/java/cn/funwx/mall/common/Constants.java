package cn.funwx.mall.common;

/**
 * @author liu66
 * @description
 */
public class Constants {
    /** session */
    public static final String SESSION_USER = "qf_user";
    /** 成功处理请求 */ 
    public static final int RESULT_CODE_SUCCESS = 200; 
    /** 没有对应结果 */ 
    public static final int RESULT_CODE_SERVER_ERROR = 500;  
    /** 手机注册缓存验证码前缀 */
    public static final String MOBILE_REG_CACHE_PREFIX = "qf_mobile_";
    /** 手机验证码过期时间 */
    public static final int MOBILE_VERIFYCODE_EXPIRE = 180;
    /** 微信用户注册默认密码 */
    public static final String WX_USER_DEFAULT_PWD = "qf_123456";
}
