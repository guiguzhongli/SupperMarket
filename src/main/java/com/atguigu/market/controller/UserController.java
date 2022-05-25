package com.atguigu.market.controller;

import com.atguigu.market.bean.Role;
import com.atguigu.market.bean.User;
import com.atguigu.market.service.RoleService;
import com.atguigu.market.service.UserService;
import com.atguigu.market.tools.PageSupport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Administrator
 * @Date 2022/5/13 13:06
 * @Version 1.0
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/getuserbylike")
    public void getUserByLike(@RequestParam("queryname") String queryname,
                                @RequestParam("queryUserRole")String queryUserRole){


    }



    @RequestMapping(value="/userlist")
    public String getUserList(Model model,HttpSession session,
                              @RequestParam(value="queryname",required=false) String queryUserName,
                              @RequestParam(value="queryUserRole",required=false) String queryUserRole,
                              @RequestParam(value="pageIndex",required=false) String pageIndex) throws Exception{
        if(session.getAttribute("user") == null){ //如果用户没有登录就直接来到userlist就回到syserror
            return "redirect:/syserror";
        }
        int _queryUserRole = 0;
        List<User> userList = null;
        //设置页面容量
        int pageSize = 5;
        //当前页码
        int currentPageNo = 1;

        if(queryUserName == null){
            queryUserName = "";
        }
        if(queryUserRole != null && !queryUserRole.equals("")){
            _queryUserRole = Integer.parseInt(queryUserRole);
        }

        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                return "redirect:/syserror";
            }
        }
        //总数量（表）
        int totalCount	= userService.getUserCount(queryUserName,_queryUserRole);
        //总页数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
//        int start = 0;
        //控制首页和尾页

        //设置分页的每一页的显示从哪里开始
        int start = ((currentPageNo-1) * pageSize);

        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }

        //这里的查询limit需要进行改动
        userList = userService.getUserListByPage(queryUserName,_queryUserRole,start,pageSize);
        model.addAttribute("userList", userList);
        List<Role> roleList = null;
        roleList = roleService.getAllRole();
        model.addAttribute("roleList", roleList);
        model.addAttribute("queryUserName", queryUserName);
        model.addAttribute("queryUserRole", queryUserRole);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "userlist";
    }

    @RequestMapping("/users")
    @ResponseBody
    public PageInfo getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        //1引进PageHelper分页插件
        //2.在查询前调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟这个查询就是一个分页查询
        List<User> users = userService.getUsers();
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面
        //封装了详细的分页信息，包括有我们查询出来的数据
        PageInfo page = new PageInfo(users,5);
        return page;
    }


    /**
     * 登陆
     * @param
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/dologin")
    public String login(@RequestParam String userCode, @RequestParam String userPassword, Model model, HttpSession session){
        User user1 = userService.login(userCode);
        System.out.println(user1);
        if (user1 == null){
            return "login";
        }else {
            if (userPassword.equals(user1.getUserPassword())){
                session.setAttribute("user",user1);
                model.addAttribute("user",user1);
                session.setAttribute("username",user1.getUserName());
                return "welcome";
            }else {
                model.addAttribute("error","账号不存在或密码错误！");
                return "login";
            }

        }
    }

    @RequestMapping("/syserror") //出错页面
    public String sysError(){
        return "syserror";
    }


    /**
     * 注销
     */
    @GetMapping("/logout")
    public String zhuxiao(HttpSession session,Model model){
        session.removeAttribute("username");
        User user = (User) model.getAttribute("user");
        System.out.println(user);
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String goLogin(){
        return "login";
    }



    @RequestMapping(value="/main")
    public String welcome(HttpSession session)  {
        if(session.getAttribute("user") == null){ //如果用户没有登录就直接来到main.html就回到login
            return "redirect:/syserror";
        }
        else
            return "welcome";
    }

}
