package com.zei.boot.demo.shiro;

import com.alibaba.fastjson.JSON;
import com.zei.boot.demo.base.Result;
import com.zei.boot.demo.constants.HeaderConstant;
import com.zei.boot.demo.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-14 09:57
 */
@Component
public class JwtFilter extends AuthenticatingFilter {

    @Autowired
    JwtUtils jwtUtils;

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String token = request.getHeader(HeaderConstant.HEADER_TOKEN);
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        return new JwtToken(token);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(HeaderConstant.HEADER_TOKEN);
        if (StringUtils.isEmpty(token)) {
            return true;
        } else {
            Claims claims = jwtUtils.getClaimsByToken(token);
            if (claims == null || jwtUtils.isTokenExpire(claims.getExpiration())) {
                throw new ExpiredCredentialsException("停留太久, 请重新登录");
            }
            return executeLogin(servletRequest, servletResponse);
        }
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        Throwable throwable = e.getCause() == null ? e : e.getCause();

        String result = JSON.toJSONString(Result.failed(throwable.getMessage()));

        try {
            httpServletResponse.getWriter().print(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
