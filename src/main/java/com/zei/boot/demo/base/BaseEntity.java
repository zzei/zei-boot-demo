package com.zei.boot.demo.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;


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

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long createBy;
    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 更新人
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    /**
     * 有效（1：有效 0：无效）
     */
    @TableField(value = "state", fill = FieldFill.INSERT)
    private Integer state;
}
