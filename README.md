# elegant-shiro-boot
演示SpringBoot优雅整合Shiro，以及3种实现访问、权限控制的方式

##如何运行
最好使用IDEA导入工程来运行，方便。
如果不想导入工程，则需要在命令行导航到项目目录，执行`gradle bootRun`来运行demo1、demo2、demo3。如：
~~~
D:\elegant-shiro-boot>cd demo1
D:\elegant-shiro-boot\demo1>gradle bootRun
~~~
项目运行后，可使用postman来发送请求，做测试。

demo*项目都设置了`context-path: /api/v1`，所以控制器的请求都应该加上前缀`/api/v1`，如：
~~~
/api/v1/user/login
/api/v1/t1/hello
~~~

