package com.zmy.demo.service;

import com.zmy.demo.pojo.User;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-27 19:42
 */
public interface UserService {

    /**
     *  登录
     * @param uname
     * @param upassword
     * @return
     */
    User login(String uname,String upassword);

    /**
     *  获取登录人信息
     * @param uname
     * @return
     */
    User getUserInfo(String uname);
}
