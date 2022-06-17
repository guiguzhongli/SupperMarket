package com.atguigu.market.aop;

import java.lang.annotation.*;

/**
 * 登录日志 自定义注解
 *
 **/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auth {
}
