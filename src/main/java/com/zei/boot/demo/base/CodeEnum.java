package com.zei.boot.demo.base;

/**
 * <p>
 *  返回实体状态码
 * </p>
 *
 * @author lvyouqiang
 * @since 2020年06月14日
 */
public enum CodeEnum {
    SUCCESS(200),
    ERROR(99999);

    private Integer code;
    CodeEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
