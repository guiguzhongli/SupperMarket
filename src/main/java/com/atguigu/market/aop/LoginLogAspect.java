package com.atguigu.market.aop;

/**
 * @ClassName LoginLogAspect
 * @Description TODO
 * @Author Administrator
 * @Date 2022/6/16 20:04
 * @Version 1.0
 **/

import com.atguigu.market.bean.SmbmsUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * 系统日志：切面处理类
 */

@Component
@Aspect
public class LoginLogAspect {
    private static final Logger logger = Logger.getLogger(LoginLogAspect.class);

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

    @AfterReturning(value = "execution(* com.atguigu.market.service.SmbmsUserService.toLogin(..))",returning="result")
    public void doLoginAfter(JoinPoint joinPoint,SmbmsUser result) {
        if (result!=null) {
            logger.debug("用户:" + result.getUserName() + "在" + simpleDateFormat.format(new Date()) + "登录成功");
        }
    }


    }




