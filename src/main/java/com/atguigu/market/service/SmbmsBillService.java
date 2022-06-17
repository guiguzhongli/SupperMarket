package com.atguigu.market.service;


import com.atguigu.market.bean.SmbmsBill;
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
public interface SmbmsBillService extends IService<SmbmsBill> {

    PageInfo<SmbmsBill> selectBills(Integer pageIndex, String queryname, String queryisPayment);

    void useraddsave(SmbmsBill bill);
}
