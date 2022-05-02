package com.zmy.demo.service;

import com.zmy.demo.pojo.House;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-28 20:23
 */
public interface HouseService {
    /**
     * 获取所有房屋信息
     * @return
     */
    List<House> getAllHouse();

    /**
     * 添加房源
     * @param house
     * @return
     */
    int addHouse(House house);

    /**
     * 通过id获取房源信息
     * @param hid
     * @return
     */
    House getHouseByid(Integer hid);

    /**
     * 更新房源信息
     * @param house
     * @return
     */
    int updateHouse(House house);

    /**
     * 条件查询
     * @return
     */
    List<House> serchHouseByparam(@Param("serch")String serch);
}
