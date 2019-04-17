package cn.funwx.mall.dao;

import cn.funwx.mall.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author liu66
 */
@Repository
public interface UserLoginDao {

    /**
     * 根据手机号获取登录用户
     * @param loginName
     * @return
     */
    User getUserByPhoneNum(String loginName);

    /**
     * 新增
     * @param user
     * @return
     */
    int insertMobileUser(User user);

    /**
     * 根据unionid获取用户
     * @param unionId
     * @return
     */
    User getUserByUnionId(String unionId);
    
    /**
     * 根据uuid获取用户
     * @param unionId
     * @return
     */
    User getUserByUuId(String uuid);

    /**
     * 小程序 网页第三方登录 插入用户
     * @param user
     * @return
     */
    int insertWxUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);
}
