package com.atguigu.market.controller;


import com.atguigu.market.bean.SmbmsProvider;
import com.atguigu.market.service.SmbmsProviderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangzhihao
 * @since 2022-06-15
 */
@Controller
@RequestMapping("/provider")
public class SmbmsProviderController {

    @Autowired
    private SmbmsProviderService providerService;

    @RequestMapping("prolist")
    public String prolist(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex, String queryname,
                          String queryUserRole, Model model){
        PageInfo<SmbmsProvider> pros =  providerService.proListAll(pageIndex,queryname,queryUserRole);
        model.addAttribute("pageResult",pros);
        return "provider/prolist";
    }

}
