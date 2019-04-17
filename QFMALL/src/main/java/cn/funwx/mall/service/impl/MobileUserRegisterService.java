package cn.funwx.mall.service.impl;

import cn.funwx.mall.common.Constants;
import cn.funwx.mall.dao.UserLoginDao;
import cn.funwx.mall.pojo.User;
import cn.funwx.mall.service.CheckRegisterInfoLegalService;
import cn.funwx.mall.service.UserLoginService;
import cn.funwx.mall.service.UserRegisterService;
import cn.funwx.mall.utils.RedisUtil;
import cn.funwx.mall.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liu66
 * @description 手机用户注册
 * 
 */
@Service
public class MobileUserRegisterService extends UserRegisterService implements CheckRegisterInfoLegalService {

    @Resource
    private UserLoginDao userLoginDao;

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private UserLoginService userLoginService;

    public boolean accountValidator(String loginName) {
        if (StringUtils.isNotBlank(loginName)) {
            String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(loginName);
            return matcher.matches();
        }
        return false;
    }

    public boolean verifyCodeValidator(String key, String code) {
        if (StringUtils.isNotBlank(key)) {
            String vCode = redisUtil.get(key);
            if (StringUtils.isNotBlank(vCode) && StringUtils.isNotBlank(code)) {
                return code != null && vCode.equals(code);
            }
        }
        return false;
    }

    @Override
    protected Result beforeReg(User user, String vCode) {
        String loginName = user.getLoginName();
        if (accountValidator(loginName)) {
            User usr = userLoginService.getUserByPhoneNum(loginName);
            if (usr == null) {
                String key = Constants.MOBILE_REG_CACHE_PREFIX + loginName;
                try {
                    if (verifyCodeValidator(key, vCode)) {
                        return Result.suc();
                    }
                } catch (Exception e) {
                    return Result.err("验证码异常！");
                }
                return Result.err("验证码错误！");
            }
            return Result.err("该手机号已经存在！");
        }
        return Result.err("请输入合法的手机号码！");
    }

    @Override
    @Transactional
    protected Result doReg(User user) {
        user.setGender(1);
        //手机号与登录名一致
        user.setPhoneNum(user.getLoginName());
        user.setNickName("mobile_" + user.getLoginName());
        int result = userLoginDao.insertMobileUser(user);
        if (result != 1) {
            throw new RuntimeException();
        }
        return Result.suc();
    }

}
