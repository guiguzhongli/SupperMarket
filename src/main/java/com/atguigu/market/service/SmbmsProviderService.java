package com.atguigu.market.service;


import com.atguigu.market.bean.SmbmsProvider;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangzhihao
 * @since 2022-06-15
 */
public interface SmbmsProviderService extends IService<SmbmsProvider> {

    PageInfo<SmbmsProvider> proListAll(Integer pageIndex, String queryname, String queryUserRole);
}
