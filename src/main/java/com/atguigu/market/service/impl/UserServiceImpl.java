package com.atguigu.market.service.impl;

import com.atguigu.market.bean.User;
import com.atguigu.market.dao.UserMapper;
import com.atguigu.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2022/5/13 13:11
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userCode) {
        return userMapper.login(userCode);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getAllUser();
    }

    @Override
    public int getUserCount(String queryUserName, int queryUserRole) {
        int count = 0;
        try {
            count=userMapper.getUserCount(queryUserName,queryUserRole);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<User> getUserListByPage(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        List<User> userList = null;

        try {
            userList=userMapper.getUserListByPage(queryUserName,queryUserRole,currentPageNo,pageSize);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userList;

    }
}
