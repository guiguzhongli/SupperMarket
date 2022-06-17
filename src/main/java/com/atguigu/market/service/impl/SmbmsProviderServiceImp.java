package com.atguigu.market.service.impl;

import com.atguigu.market.bean.SmbmsProvider;
import com.atguigu.market.dao.SmbmsProviderDao;

import com.atguigu.market.service.SmbmsProviderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangzhihao
 * @since 2022-06-15
 */
@Service
public class SmbmsProviderServiceImp extends ServiceImpl<SmbmsProviderDao, SmbmsProvider> implements SmbmsProviderService {

    @Autowired
    private SmbmsProviderDao providerDao;

    @Override
    public PageInfo<SmbmsProvider> proListAll(Integer pageIndex, String queryname, String queryUserRole) {
        QueryWrapper<SmbmsProvider> wrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(queryname)){
            wrapper.like("proName",queryname);
        }
        if (!StringUtils.isEmpty(queryUserRole)){
            wrapper.eq("",queryUserRole);
        }
        PageHelper.startPage(pageIndex,5);
        List<SmbmsProvider> smbmsProviders = providerDao.selectList(wrapper);

        return new PageInfo<SmbmsProvider>(smbmsProviders);
    }
}
