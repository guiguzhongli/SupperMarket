package com.atguigu.market.service.impl;

import com.atguigu.market.bean.Role;
import com.atguigu.market.dao.RoleMapper;
import com.atguigu.market.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2022/5/25 11:24
 * @Version 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() {
        return roleMapper.getRoleList();
    }
}
