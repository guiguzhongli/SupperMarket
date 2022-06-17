package com.atguigu.market.controller;


import com.atguigu.market.bean.SmbmsBill;
import com.atguigu.market.bean.SmbmsProvider;
import com.atguigu.market.bean.SmbmsUser;
import com.atguigu.market.service.SmbmsBillService;
import com.atguigu.market.service.SmbmsProviderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangzhihao
 * @since 2022-06-15
 */
@Controller
@RequestMapping("/bill")
public class SmbmsBillController {

    @Autowired
    SmbmsBillService billService;

    @Autowired
    SmbmsProviderService providerService;


    @RequestMapping("billlist")
    public String billList(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                           String queryname, String queryisPayment, Model model){

        PageInfo<SmbmsBill> users =billService.selectBills(pageIndex,queryname,queryisPayment);
        List<SmbmsProvider> providerList = providerService.list();

        model.addAttribute("providerList",providerList);
        model.addAttribute("pageResult",users);
        return "bill/billlist";
    }


    @RequestMapping("/billadd")
    public String billadd(){
        return "bill/billadd";
    }

    @PostMapping("/billaddsave")
    public String useraddsave(SmbmsBill bill){
        if (bill.getId()==null) {
            billService.useraddsave(bill);
        }
        billService.updateById(bill);
        return "redirect:billlist";
    }



}
