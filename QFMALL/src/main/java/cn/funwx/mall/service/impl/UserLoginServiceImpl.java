package cn.funwx.mall.service.impl;

import cn.funwx.mall.common.Constants;
import cn.funwx.mall.dao.UserLoginDao;
import cn.funwx.mall.pojo.User;
import cn.funwx.mall.service.UserLoginService;
import cn.funwx.mall.utils.RandomNumberUtil;
import cn.funwx.mall.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author liu66
 * 
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginServiceImpl.class);

    @Autowired
    private UserLoginDao userLoginDao;

    @Resource
    private RedisUtil redisUtil;

    public User getUserByPhoneNum(String phoneNum) {
        return userLoginDao.getUserByPhoneNum(phoneNum);
    }
    
    //获取要发送的验证码
    public Integer getVerifyCode(String key) {
    	//生成随机4位数
        String vCode = RandomNumberUtil.getStringRandom(4);
//        try {
//            redisUtil.set(key, vCode, Constants.MOBILE_VERIFYCODE_EXPIRE);
//        } catch (Exception ex) {
//            LOGGER.error("redis 插入失败", ex);
//            return null;
//        }
        return Integer.parseInt(vCode);
    }

    public User getUserByUnionId(String unionId) {
        return userLoginDao.getUserByUnionId(unionId);
    }

    @Transactional
    public int update(User user) {
        user.setOperateTime(new Date());
        return userLoginDao.updateUser(user);
    }

	public User getUserByUuId(String uuid) {
		// TODO Auto-generated method stub
		return userLoginDao.getUserByUuId(uuid);
	}

}
