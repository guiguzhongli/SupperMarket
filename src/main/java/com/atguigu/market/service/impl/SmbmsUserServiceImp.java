package com.atguigu.market.service.impl;

import com.atguigu.market.bean.SmbmsRole;
import com.atguigu.market.bean.SmbmsUser;
import com.atguigu.market.dao.SmbmsUserDao;

import com.atguigu.market.service.SmbmsRoleService;
import com.atguigu.market.service.SmbmsUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangzhihao
 * @since 2022-06-15
 */

@Service
public class SmbmsUserServiceImp extends ServiceImpl<SmbmsUserDao, SmbmsUser> implements SmbmsUserService {

    @Autowired
    private SmbmsRoleService roleService;

    @Autowired
    private SmbmsUserDao userDao;

    @Override
    public SmbmsUser toLogin(String userCode, String userPassword) {
        HashMap map = new HashMap<>();
        map.put("userCode",userCode);
        map.put("userPassword",userPassword);
        SmbmsUser user = this.baseMapper.selectOne(new QueryWrapper<SmbmsUser>().allEq(map));
        return user;
    }

    @Override
    public PageInfo<SmbmsUser> selectUsers(Integer pageIndex,String queryUserName, String queryUserRole) {
        QueryWrapper<SmbmsUser> wrapper = new QueryWrapper<>();
        PageHelper.startPage(pageIndex,5);
        List<SmbmsUser> users;

        if (!StringUtils.isEmpty(queryUserRole)&&!"0".equalsIgnoreCase(queryUserRole)){
            wrapper.eq("userRole",queryUserRole);
        }
        if (!StringUtils.isEmpty(queryUserName)) {
            wrapper.like("userName",queryUserName);
        }

        PageHelper.startPage(pageIndex,5);
         users = this.baseMapper.selectList(wrapper);

        for (SmbmsUser user : users) {
            SmbmsRole byId = roleService.getById(user.getUserRole());
            user.setRole(byId);
        }

        return new PageInfo<SmbmsUser>(users);
    }

    @Override
    public void useraddsave(SmbmsUser user) {
        int insert = userDao.insert(user);
    }

    @Override
    public SmbmsUser selectUserCodeExist(String userCode) {
        SmbmsUser user = null;
        try {
            user = userDao.selectOne(new QueryWrapper<SmbmsUser>().eq("userCode",userCode));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean deleteUserById(int uid) {
        boolean result = false;
        try {
            int i = userDao.deleteById(uid);
            if(i > 0)
                result = true; //删除成功
            else
                result=false;  //删除失败
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}
