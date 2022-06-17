package com.atguigu.market.test;

import com.atguigu.market.bean.SmbmsUser;

import com.atguigu.market.dao.SmbmsUserDao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName UserTest
 * @Description TODO
 * @Author Administrator
 * @Date 2022/5/25 12:40
 * @Version 1.0
 **/
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class UserTest {


    @Autowired
    SqlSession session;

    @Test
    public void test11(){
        SmbmsUserDao mapper = session.getMapper(SmbmsUserDao.class);
        List<SmbmsUser> users = mapper.selectList(new QueryWrapper<SmbmsUser>());
        System.out.println(users);
    }

//    @Test
//    public void testGetUserCount() {
//
//
//        int count=0;
//        String userName=null;
//        int userRole=0;
//        count = userService.getUserCount(userName,userRole);
//        System.out.println("共有"+count+"条记录");
//    }
//
//    @Test
//    public void testGetUserListByPage() {
//
//        int count = 0;
//        String userName = null;
//        int userRole = 0;
//        int currentPageNo = 0;
//        int pageSize = 5;
//        List<User> userList = userService.getUserListByPage(userName, userRole, currentPageNo, pageSize);
//        System.out.println("当前记录从"+currentPageNo+1+"开始");
//        System.out.println("共显示" + pageSize + "条记录");
//        for (User user : userList) {
//            System.out.println("ID:" + user.getId() +
//                    " 用户帐号：" + user.getUserCode() +
//                    " 用户姓名:" + user.getUserName() +
//                    " 用户角色:" + user.getRole().getRoleName() +
//                    " 地址:" + user.getAddress());
//        }
//    }

}
