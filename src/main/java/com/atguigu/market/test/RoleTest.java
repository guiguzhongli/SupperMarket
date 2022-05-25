package com.atguigu.market.test;

import com.atguigu.market.bean.Role;
import com.atguigu.market.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName RoleTest
 * @Description TODO
 * @Author Administrator
 * @Date 2022/5/25 11:27
 * @Version 1.0
 **/
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class RoleTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testGetRole(){
        List<Role> list = roleService.getAllRole();
        for (Role l: list) {
            System.out.println(l);
        }
    }

}
