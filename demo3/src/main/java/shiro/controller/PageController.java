package shiro.controller;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shiro.constant.Codes;
import shiro.vo.Json;

/**
 * 通过application-shiro.yml配置loginUrl,unauthorizedUrl映射到这两个请求处理方法。
 *
 * 在ShiroConfig中
 *
 * 通过对指定的路径应用"authc"来告诉shiro哪些请求需要登录才能访问，如果用户没有登录，则会跳转到loginUrl指定请求路径；
 *
 * 通过对指定的路径应用"roles[js]"来告诉shiro哪些已登录的用户需要有js角色才能访问，如果不满足条件会跳转到unauthorizedUrl指定请求路径；
 *
 * 通过对指定的路径应用"perms[mvn:install]"来告诉shiro哪些请求可以匿名访问，如果不满足条件会跳转到unauthorizedUrl指定请求路径；
 *
 * 通过对指定的路径应用"anon"来告诉shiro哪些请求可以匿名访问；
 *
 *
 *
 */
@RestController
@RequestMapping("/page")
public class PageController {

    // shiro.loginUrl映射到这里，我在这里直接抛出异常交给GlobalExceptionHandler来统一返回json信息，
    // 您也可以在这里json，不过这样子就跟GlobalExceptionHandler中返回的json重复了。
    @RequestMapping("/401")
    public Json page401() {
        throw new UnauthenticatedException();
    }

    // shiro.unauthorizedUrl映射到这里。由于demo3统一约定了url方式只做鉴权控制，不做权限访问控制，
    // 也就是说在ShiroConfig中如果没有roles[js],perms[mvn:install]这样的权限访问控制配置的话，
    // 是不会跳转到这里的。
    @RequestMapping("/403")
    public Json page403() {
        throw new UnauthorizedException();
    }

    @RequestMapping("/index")
    public Json pageIndex() {
        return new Json("index",true,1,"index page",null);
    }


}
