package com.zei.boot.demo.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 基础查询条件类
 * </p>
 *
 * @author lvyouqiang
 * @since 2019-11-22 11:53
 */
@Data
abstract class BaseSearch implements Serializable {

    private static final long serialVersionUID = 9168956486844632916L;

    /**
     * 排序字段 xxx DESC
     */
    private String orderByField;

    /**
     * 页码
     */
    private int pageNo;

    /**
     * 每页记录数
     */
    private int pageSize;

    public int getPageNo() {
        return pageNo < 1 ? 1 : pageNo;
    }

    public int getPageSize() {
        return pageSize < 1 ? 10 : pageSize;
    }
}
