package com.zmy.demo.controller;

import com.zmy.demo.TimeUtil;
import com.zmy.demo.pojo.Message;
import com.zmy.demo.pojo.Role;
import com.zmy.demo.pojo.User;
import com.zmy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-27 19:42
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *  登录
     * @param uname
     * @param upassword
     * @return
     */
    @PostMapping("/login/{uname}/{upassword}")
    @ResponseBody
    public Message Login(@PathVariable("uname")String uname,@PathVariable("upassword")String upassword){
        User user = userService.login(uname, upassword);
        if (user!=null){
            return Message.success().add("user",user);
        }
        return Message.fail();
    }

    /**
     * 获取登录人信息
     * @param uname
     * @return
     */
    @GetMapping("/user/{uname}")
    @ResponseBody
    public Message getUserInfo(@PathVariable("uname")String uname){
        // 获取登录人信息
        User user = userService.getUserInfo(uname);
        Date uaddtime = user.getUaddtime();
        String format = TimeUtil.format(uaddtime);
        System.out.println("format = " + format);
        Date parse = TimeUtil.parse(format);
        System.out.println(parse);
        System.out.println(user);
        return Message.success().add("user",user);
    }

    @GetMapping("/logout")
    @ResponseBody
    public Message logout(HttpSession session){
        System.out.println("session ==================== " + session);
        session.invalidate();
        return Message.success();
    }

}
