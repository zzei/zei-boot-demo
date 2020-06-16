package com.zei.boot.demo.module.system.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zei.boot.demo.base.PageInfo;
import com.zei.boot.demo.constants.GlobalConstant;
import com.zei.boot.demo.module.system.api.dto.UserDTO;
import com.zei.boot.demo.module.system.api.dto.UserLoginDTO;
import com.zei.boot.demo.module.system.api.search.UserSearch;
import com.zei.boot.demo.module.system.api.vo.UserVO;
import com.zei.boot.demo.module.system.dao.UserMapper;
import com.zei.boot.demo.module.system.entity.User;
import com.zei.boot.demo.module.system.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

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
    public PageInfo<UserVO> queryUser(UserSearch search) {
        PageInfo<UserVO> page = new PageInfo<>();
        page.setCurrent(search.getPageNo());
        page.setSize(search.getPageSize());

        List<UserVO> userVOS = userMapper.queryUser(page, search);
        page.setRecords(userVOS);
        return page;
    }

    @Override
    public boolean addUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setAccount(userDTO.getUsername());
        user.setPassword(SecureUtil.md5(GlobalConstant.NORMAL_PWD));
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        return userMapper.updateById(user) > 0;
    }

    @Override
    public boolean removeUser(Long userId) {
        User user = new User();
        user.setId(userId);
        user.setState(0);
        return userMapper.updateById(user) > 0;
    }

    @Override
    public User getUserById(Long userId) {
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
