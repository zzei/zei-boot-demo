package com.zei.boot.demo.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-04-14 16:53
 */
@Data
public abstract class BaseEntity {

    @TableId(
            value = "id",
            type = IdType.ID_WORKER
    )
    private Long id;

}
