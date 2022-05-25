package com.atguigu.market.service.impl;

import com.atguigu.market.bean.Provider;
import com.atguigu.market.dao.ProviderMapper;
import com.atguigu.market.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProviderServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2022/5/25 17:58
 * @Version 1.0
 **/
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public List<Provider> getAllProvider() {
        return providerMapper.getAllProvider();
    }
}
