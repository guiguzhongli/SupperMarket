package com.atguigu.market.dao;

import com.atguigu.market.bean.Provider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProviderMapper {


    List<Provider> getAllProvider();

}
