package com.atguigu.market.service;


import com.atguigu.market.bean.SmbmsUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangzhihao
 * @since 2022-06-15
 */
public interface SmbmsUserService extends IService<SmbmsUser> {

    SmbmsUser toLogin(String userCode, String userPassword);

    PageInfo<SmbmsUser> selectUsers(Integer pageIndex,String queryUserName, String queryUserRole);

    void useraddsave(SmbmsUser user);

    SmbmsUser selectUserCodeExist(String userCode);

    boolean deleteUserById(int uid);
}
