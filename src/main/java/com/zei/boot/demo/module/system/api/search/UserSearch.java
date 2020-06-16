package com.zei.boot.demo.module.system.api.search;

import com.zei.boot.demo.base.BaseSearch;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-16 15:12
 */
@Data
public class UserSearch extends BaseSearch implements Serializable {

    private static final long serialVersionUID = 6255674125264364678L;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("账号")
    private String account;

}
