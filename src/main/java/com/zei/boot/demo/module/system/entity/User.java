package com.zei.boot.demo.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zei.boot.demo.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("user")
public class User extends BaseEntity implements Serializable {

	/**
	 * 账号
	 */
	@TableField("account")
	private String account;
	/**
	 * 密码
	 */
	@TableField("password")
	private String password;
	/**
	 * 用户名
	 */
	@TableField("username")
	private String username;
	/**
	 * 头像
	 */
	@TableField("avatar")
	private String avatar;

}
