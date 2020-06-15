package com.zei.boot.demo.module.system.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zei.boot.demo.module.system.api.dto.UserLoginDTO;
import com.zei.boot.demo.module.system.dao.UserMapper;
import com.zei.boot.demo.module.system.entity.User;
import com.zei.boot.demo.module.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-14 12:33
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        User user = userMapper.selectById(userId);
        return user;
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("account", userLoginDTO.getAccount()));
        Assert.notNull(user, "用户不存在");

        if (!user.getPassword().equals(SecureUtil.md5(userLoginDTO.getPassword()))) {
            return null;
        }
        return user;
    }
}
