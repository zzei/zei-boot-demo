package com.zei.boot.demo.shiro;

import com.zei.boot.demo.module.system.entity.User;
import com.zei.boot.demo.module.system.service.IUserService;
import com.zei.boot.demo.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-14 09:42
 */
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    IUserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        JwtToken token = (JwtToken) authenticationToken;

        String userId = jwtUtils.getClaimsByToken(token.getPrincipal().toString()).getSubject();

        User user = userService.getUserById(Long.valueOf(userId));
        if (user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        if (user.getState() == -1) {
            throw new LockedAccountException("账号已失效");
        }
        AccountProfile accountProfile = new AccountProfile();
        BeanUtils.copyProperties(user, accountProfile);

        return new SimpleAuthenticationInfo(accountProfile, token.getCredentials(), getName());
    }
}
