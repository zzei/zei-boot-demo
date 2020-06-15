package com.zei.boot.demo.shiro;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-14 12:39
 */
@Data
public class AccountProfile implements Serializable {

    private static final long serialVersionUID = -4186481929554138652L;

    private Long id;

    private String account;

    private String username;

    private String avatar;
}
