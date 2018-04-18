package com.abc.shiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by CaiBaoHong at 2018/4/18 15:51<br>
 * 测试shiro提供的注解及功能解释
 */
@RestController
@RequestMapping("/t4")
public class Test4Controller {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }

    @GetMapping("/changePwd")
    public String guest() {
        return "change pwd";
    }

    @GetMapping("/logout")
    public String authn() {
        return "logout";
    }

    @GetMapping("/user")
    public String user() {
        return "logined user or 'remember me' user";
    }

    @GetMapping("/mvnBuild")
    public String mvnBuild() {
        return "mvn:build";
    }

    @GetMapping("/gradleBuild")
    public String gradleBuild() {
        return "gradleBuild";
    }

    @GetMapping("/js")
    public String js() {
        return "js programmer";
    }

    @GetMapping("/python")
    public String python() {
        return "python programmer";
    }

}
