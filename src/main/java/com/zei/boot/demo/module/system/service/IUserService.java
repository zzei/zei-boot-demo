package com.zei.boot.demo.module.system.service;

import com.zei.boot.demo.module.system.api.dto.UserLoginDTO;
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

    User getUserById(String userId);

    User login(UserLoginDTO userLoginDTO);
}
