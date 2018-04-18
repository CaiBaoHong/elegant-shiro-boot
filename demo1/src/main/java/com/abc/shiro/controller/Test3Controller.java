package com.abc.shiro.controller;

import org.apache.shiro.authz.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by CaiBaoHong at 2018/4/18 15:51<br>
 *     测试没有任何shiro注解情况下，接口是否可以访问
 */
@RestController
@RequestMapping("/t3")
public class Test3Controller {

    // 这里没有任何shiro注解，且在ShiroConfig配置了chain.addPathDefinition("/**", "anon");
    // 即任何请求都可以匿名访问。因此该接口无论是用户未登录还是用户登录了都可以访问
    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }

}
