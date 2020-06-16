package com.zei.boot.demo.module.system.service;

import com.zei.boot.demo.base.PageInfo;
import com.zei.boot.demo.module.system.api.dto.UserDTO;
import com.zei.boot.demo.module.system.api.dto.UserLoginDTO;
import com.zei.boot.demo.module.system.api.search.UserSearch;
import com.zei.boot.demo.module.system.api.vo.UserVO;
import com.zei.boot.demo.module.system.entity.User;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-14 12:33
 */
public interface IUserService {

    PageInfo<UserVO> queryUser(UserSearch search);

    boolean addUser(UserDTO userDTO);

    boolean updateUser(UserDTO userDTO);

    boolean removeUser(Long userId);

    User getUserById(Long userId);

    User login(UserLoginDTO userLoginDTO);
}
