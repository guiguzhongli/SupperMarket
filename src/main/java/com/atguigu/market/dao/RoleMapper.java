package com.atguigu.market.dao;

import com.atguigu.market.bean.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<Role> getRoleList();
}
