package com.zmy.demo.mapper;

import com.zmy.demo.pojo.House;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface HouseMapper extends Mapper<House> {
    /**
     * 条件查询
     * @param serch
     * @return
     */
    List<House> serchHouseByparam(@Param("serch") String serch);

    /**
     * 添加房源信息
     * @param keys
     * @param values
     */
    int addHouse(@Param("key") String keys, @Param("value") String values);
}