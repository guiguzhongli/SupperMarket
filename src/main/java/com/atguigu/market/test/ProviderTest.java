package com.atguigu.market.test;

import com.atguigu.market.bean.Provider;
import com.atguigu.market.service.ProviderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName ProviderTest
 * @Description TODO
 * @Author Administrator
 * @Date 2022/5/25 18:21
 * @Version 1.0
 **/
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class ProviderTest {
    @Autowired
    private ProviderService providerService;

    @Test
    public void test1(){
        List<Provider> allProvider = providerService.getAllProvider();

        for (Provider p:allProvider) {
            System.out.println(p);
        }
    }

}
