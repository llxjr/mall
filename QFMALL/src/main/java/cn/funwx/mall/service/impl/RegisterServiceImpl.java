package cn.funwx.mall.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.funwx.mall.dao.UserLoginDao;
import cn.funwx.mall.pojo.User;
import cn.funwx.mall.service.RegisterService;
import cn.funwx.mall.utils.Result;
import cn.funwx.mall.utils.UUIDUtil;

/**
 * 
 * @author llz
 *
 */

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private UserLoginDao userLoginDao;
	
	public int registerUser(User user) {
		UUIDUtil uuidUtil = new UUIDUtil();
		user.setUuid(uuidUtil.getUUID());
		user.setAccountStatus(0);
		user.setNickName(user.getLoginName());
		return userLoginDao.insertMobileUser(user);
	}

}
