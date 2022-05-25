package com.atguigu.market.dao;

import com.atguigu.market.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User login(String userCode);


    List<User> getAllUser();

    public int getUserCount(@Param("userName")String userName, @Param("userRole")Integer userRole);

    //根据条件查询用户列表
    public List<User> getUserListByPage(@Param("userName")String userName,
                                        @Param("userRole")Integer userRole,
                                        @Param("currentPageNo")Integer currentPageNo,
                                        @Param("pageSize")Integer pageSize);
}
