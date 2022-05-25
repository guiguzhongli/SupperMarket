package com.atguigu.market.controller;

import com.atguigu.market.bean.Role;
import com.atguigu.market.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author Administrator
 * @Date 2022/5/25 11:27
 * @Version 1.0
 **/
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("/roles")
    @ResponseBody
    public PageInfo getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        //1引进PageHelper分页插件
        //2.在查询前调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟这个查询就是一个分页查询
        List<Role> roles = roleService.getAllRole();
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面
        //封装了详细的分页信息，包括有我们查询出来的数据
        PageInfo page = new PageInfo(roles,5);
        return page;
    }


}
