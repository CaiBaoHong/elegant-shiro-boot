package com.abc.shiro.controller;

import com.abc.shiro.constant.Codes;
import com.abc.shiro.vo.Json;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里定义了：
 * 用户未登录时跳转的请求路径 和
 * 用户没有访问权限时跳转的请求路径
 */
@RestController
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/401")
    public Json page401() {
        return new Json("401", false, Codes.UNAUTHEN, "未登录", null);
    }

    @RequestMapping("/403")
    public Json page403() {
        return new Json("403", false, Codes.UNAUTHZ, "用户没有访问权限", null);
    }


}
