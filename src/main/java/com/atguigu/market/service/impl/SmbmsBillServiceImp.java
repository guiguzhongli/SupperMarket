package com.atguigu.market.service.impl;

import com.atguigu.market.bean.SmbmsBill;
import com.atguigu.market.bean.SmbmsProvider;
import com.atguigu.market.bean.SmbmsRole;
import com.atguigu.market.bean.SmbmsUser;
import com.atguigu.market.dao.SmbmsBillDao;

import com.atguigu.market.service.SmbmsBillService;
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
public class SmbmsBillServiceImp extends ServiceImpl<SmbmsBillDao, SmbmsBill> implements SmbmsBillService {

    @Autowired
    private SmbmsProviderService providerService;

    @Override
    public PageInfo<SmbmsBill> selectBills(Integer pageIndex, String queryname, String queryisPayment) {

        QueryWrapper<SmbmsBill> wrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(queryisPayment)&&!"0".equalsIgnoreCase(queryisPayment)){
            wrapper.eq("providerId",queryisPayment);
        }
        if (!StringUtils.isEmpty(queryname)) {
            wrapper.like("productName",queryname);
        }
        PageHelper.startPage(pageIndex,5);
        List<SmbmsBill> bills = this.baseMapper.selectList(wrapper);

        for (SmbmsBill bill : bills) {
            SmbmsProvider byId = providerService.getById(bill.getProviderId());
            bill.setProvider(byId);
        }

        return new PageInfo<SmbmsBill>(bills);
    }

    @Override
    public void useraddsave(SmbmsBill bill) {
        int insert = this.baseMapper.insert(bill);
    }
}
