package com.atguigu.market.controller;



import com.alibaba.fastjson.JSONArray;
import com.atguigu.market.aop.Auth;
import com.atguigu.market.bean.SmbmsRole;
import com.atguigu.market.bean.SmbmsUser;

import com.atguigu.market.service.SmbmsRoleService;
import com.atguigu.market.service.SmbmsUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
public class SmbmsUserController {

    @Autowired
    private SmbmsUserService userService;

    @Autowired
    private SmbmsRoleService roleService;



    @Auth
    @PostMapping("dologin")
    public String login(@RequestParam("userCode")String userCode,
                        @RequestParam("userPassword")String userPassword,
                        HttpSession session){
        SmbmsUser user = userService.toLogin(userCode,userPassword);
        if (user==null){
            session.setAttribute("error","账号或者密码错误");
            return "index";
        }
        session.setAttribute("user",user);
        session.setAttribute("userCode",user.getUserName());
        return "redirect:userlist";
    }

    @RequestMapping("/userlist")
    public String listUser(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,String queryname, String queryUserRole, Model model){
        PageInfo<SmbmsUser> users = userService.selectUsers(pageIndex,queryname, queryUserRole);
        List<SmbmsRole> list = roleService.list();
        model.addAttribute("role",list);
        model.addAttribute("pageResult",users);
        return "user/userlist";

    }

    @RequestMapping("/useradd")
    public String userAdd(@RequestParam(value = "uid",required = false)String uid, SmbmsUser user,Model model){

        if (uid!=null&&!"".equals(uid)){
            SmbmsUser smbmsUser = userService.getById(uid);
            model.addAttribute("user",smbmsUser);
            return "user/usermodify";
        }
        return "user/useradd";
    }

    @PostMapping("/useraddsave")
    public String useraddsave(SmbmsUser user){
        if (user.getId()==null) {
            userService.useraddsave(user);
        }
        userService.updateById(user);
        return "redirect:userlist";
    }

    @RequestMapping("/delete")
    public void delete(String id){
        System.out.println(id);
    }

    @RequestMapping("/viewUser")
    public String viewUser(@RequestParam("uid")String uid,Model model){
        SmbmsUser byId = userService.getById(uid);
        SmbmsRole role = roleService.getById(byId.getUserRole());
        byId.setRole(role);
        model.addAttribute("user",byId);
        return "user/userview";
    }



    @GetMapping("/logout")
    public String logout(HttpSession session){
        Object user = session.getAttribute("user");
        if (user!=null){
            session.removeAttribute("user");
        }
        return "index";
    }

    @RequestMapping("/ucexist")
    @ResponseBody
    public String ucexist(@RequestParam String userCode){
        String data="{\"userCode\":\"noexist\"}";  //初始化字符串
        if(userCode==null||userCode.length()==0){  //如果userCode是空值
            data="{\"userCode\":\"exist\"}";  //空值直接返回已存在
        }
        else{
            SmbmsUser user = userService.selectUserCodeExist(userCode);
            if(user!=null)
                data="{\"userCode\":\"exist\"}";
            else
                data="{\"userCode\":\"noexist\"}";
        }
        return JSONArray.toJSONString(data);//将data转为json对象,并将结果发回给当前页面
    }


    //删除用户数据
    @RequestMapping(value="/deluser")
    @ResponseBody
    public Object deluser(@RequestParam int uid){
        String data="{\"delResult\":\"false\"}";  //初始化字符串
        boolean result= userService.deleteUserById(uid);
        if(result==true)
            data="{\"delResult\":\"true\"}"; //删除成功
        else
            data="{\"delResult\":\"false\"}"; //删除失败
        return JSONArray.toJSONString(data);//将data转为json对象,并将结果发回给当前页面
    }

}
