package com.zmy.demo.mapper;

import com.zmy.demo.pojo.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface RoleMapper extends Mapper<Role> {

    List<Role> getUserRoleByUname(Integer uid);
}