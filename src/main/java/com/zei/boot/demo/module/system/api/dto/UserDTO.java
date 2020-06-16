package com.zei.boot.demo.module.system.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-16 15:29
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 2854216555515042385L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty("头像")
    private String avatar;
}
