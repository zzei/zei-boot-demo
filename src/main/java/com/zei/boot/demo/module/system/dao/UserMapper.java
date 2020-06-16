package com.zei.boot.demo.module.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zei.boot.demo.base.PageInfo;
import com.zei.boot.demo.module.system.api.search.UserSearch;
import com.zei.boot.demo.module.system.api.vo.UserVO;
import com.zei.boot.demo.module.system.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-14 12:37
 */
public interface UserMapper extends BaseMapper<User> {

    List<UserVO> queryUser(PageInfo<UserVO> page, @Param("search") UserSearch search);
}
