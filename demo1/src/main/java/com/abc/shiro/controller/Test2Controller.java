package com.abc.shiro.controller;

import org.apache.shiro.authz.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by CaiBaoHong at 2018/4/18 15:51<br>
 *     测试在类上加了访问控制注解后，两个接口是否可以访问
 */
@RestController
@RequestMapping("/t2")
@RequiresAuthentication
public class Test2Controller {

    // 由于TestController类上加了@RequiresAuthentication注解，
    // 而这个方法上没有其它shiro注解，所以会使用@RequiresAuthentication注解做访问控制
    // 所以这里hello接口不能访问，未登录访问会抛出UnauthenticatedException
    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }

    // 游客可访问，这个有点坑，游客的意思是指：subject.getPrincipal()==null
    // 所以用户在未登录时subject.getPrincipal()==null，接口可访问
    // 而用户登录后subject.getPrincipal()！=null，接口不可访问

    // 这里在类上有@RequiresAuthentication要求用户登录，而方法级别上要求游客访问@RequiresGuest。
    // 这两个注解结合起来是矛盾的。
    // 因此无论是用户登录了还是未登录，都会抛出UnauthenticatedException
    @RequiresGuest
    @GetMapping("/guest")
    public String guest() {
        return "@RequiresGuest";
    }



}
