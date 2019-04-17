package cn.funwx.mall.service;

import cn.funwx.mall.pojo.User;

/**
 * @author liu66
 * @description 校验注册信息合法性
 * 
 */
public interface CheckRegisterInfoLegalService {

    boolean accountValidator(String phoneNum);

    boolean verifyCodeValidator(String key, String code);
}
