package com.zmy.demo.service.Impl;

import com.zmy.demo.mapper.RoleMapper;
import com.zmy.demo.mapper.UserMapper;
import com.zmy.demo.pojo.Role;
import com.zmy.demo.pojo.User;
import com.zmy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-27 19:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User login(String uname,String upassword) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("uname",uname).andEqualTo("upassword",upassword);
        User user = userMapper.selectOneByExample(example);
        return user;
    }

    /**
     * 获取登录人信息
     * @param uname
     * @return
     */
    @Override
    public User getUserInfo(String uname) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("uname",uname);
        User user = userMapper.selectOneByExample(example);
        // 获取登录人权限
        List<Role> roles = roleMapper.getUserRoleByUname(user.getUid());
        user.setRoles(roles);
        return user;
    }
}
