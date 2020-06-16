package com.zei.boot.demo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zei.boot.demo.shiro.CurrentUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 *  mybatis-plus自动填充字段
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-16 15:59
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入数据: {}", metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createBy", CurrentUser.getUser().getId(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", CurrentUser.getUser().getId(), metaObject);
        this.setFieldValByName("state", 1, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新数据: {}", metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", CurrentUser.getUser().getId(), metaObject);
    }

}
