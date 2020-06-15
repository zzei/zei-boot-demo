package com.zei.boot.demo.module.system.controller;

import com.zei.boot.demo.base.Result;
import com.zei.boot.demo.constants.HeaderConstant;
import com.zei.boot.demo.module.system.api.dto.UserLoginDTO;
import com.zei.boot.demo.module.system.api.vo.UserVO;
import com.zei.boot.demo.module.system.entity.User;
import com.zei.boot.demo.module.system.service.IUserService;
import com.zei.boot.demo.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  用户接口
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-14 12:30
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    IUserService userService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result<UserVO> login(@Validated @RequestBody UserLoginDTO userLoginDTO, HttpServletResponse response) {

        User user = userService.login(userLoginDTO);
        if (user == null) {
            return Result.failed("密码不正确");
        }
        String token = jwtUtils.generateToken(user.getId());
        response.setHeader(HeaderConstant.HEADER_TOKEN, token);
        response.setHeader(HeaderConstant.ACCESS_HEADER, HeaderConstant.HEADER_TOKEN);

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);

        return Result.succeed(userVO);
    }

    @RequiresAuthentication
    @ApiOperation(value = "注销")
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succeed("ok");
    }
}
