package com.abc.shiro.controller;

import com.abc.shiro.entity.User;
import com.abc.shiro.service.UserService;
import com.abc.shiro.vo.Json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/**
 * created by CaiBaoHong at 2018/4/17 16:41<br>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 登录接口，由于UserService中是模拟返回用户信息的，
     * 所以用户名随意，密码123456
     *
     * @param body
     * @return
     */
    @PostMapping("/login")
    public Json login(@RequestBody String body){

        String oper = "user login";
        log.info("{}, body: {}",oper,body);

        JSONObject json = JSON.parseObject(body);
        String uname = json.getString("uname");
        String pwd = json.getString("pwd");

        if (StringUtils.isEmpty(uname)){
            return Json.fail(oper,"用户名不能为空");
        }
        if (StringUtils.isEmpty(pwd)){
            return Json.fail(oper,"密码不能为空");
        }

        Subject currentUser = SecurityUtils.getSubject();
        try {
            //登录
            currentUser.login( new UsernamePasswordToken(uname, pwd) );
            //从session取出用户信息
            User user = (User) currentUser.getPrincipal();
            if (user==null) throw new AuthenticationException();
            //返回登录用户的信息给前台，含用户的所有角色和权限
            return Json.succ(oper)
                    .data("uid",user.getUid())
                    .data("nick",user.getNick())
                    .data("roles",user.getRoles())
                    .data("perms",user.getPerms());

        } catch ( UnknownAccountException uae ) {
            log.warn("用户帐号不正确");
            return Json.fail(oper,"用户帐号或密码不正确");

        } catch ( IncorrectCredentialsException ice ) {
            log.warn("用户密码不正确");
            return Json.fail(oper,"用户帐号或密码不正确");

        } catch ( LockedAccountException lae ) {
            log.warn("用户帐号被锁定");
            return Json.fail(oper,"用户帐号被锁定不可用");

        } catch ( AuthenticationException ae ) {
            log.warn("登录出错");
            return Json.fail(oper,"登录失败："+ae.getMessage());
        }

    }


}
