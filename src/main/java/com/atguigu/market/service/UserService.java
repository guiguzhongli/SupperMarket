package com.atguigu.market.service;

import com.atguigu.market.bean.User;

import java.util.List;

public interface UserService {

    User login(String userCode);

    List<User> getUsers();

    //根据条件查询用户表记录数
    public int getUserCount(String queryUserName,int queryUserRole);

    //根据条件查询用户列表
    public List<User> getUserListByPage (String queryUserName,int queryUserRole,int currentPageNo, int pageSize);
}
