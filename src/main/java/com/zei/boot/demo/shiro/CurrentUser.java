package com.zei.boot.demo.shiro;

import org.apache.shiro.SecurityUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-16 15:53
 */
public class CurrentUser {

    public static AccountProfile getUser() {
        AccountProfile accountProfile = (AccountProfile) SecurityUtils.getSubject().getPrincipal();
        return accountProfile;
    }
}
