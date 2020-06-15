package com.zei.boot.demo.module.system.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-15 11:07
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -7071128913495177538L;

    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("头像")
    private String avatar;
}
