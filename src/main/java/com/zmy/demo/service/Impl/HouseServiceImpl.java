package com.zmy.demo.service.Impl;

import com.zmy.demo.TimeUtil;
import com.zmy.demo.mapper.HouseMapper;
import com.zmy.demo.pojo.House;
import com.zmy.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-28 20:24
 */
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    /**
     * 获取所有房屋信息
     * @return
     */
    @Override
    public List<House> getAllHouse() {
        return houseMapper.selectAll();
    }

    /**
     * 添加房源
     * @param house
     * @return
     */
    @Override
    public int addHouse(House house) {
        // 添加时间
        Date time = Date.from(Instant.now());
        house.setHaddtime(time);
        house.setHupdatetime(time);
        return houseMapper.insert(house);
    }

    /**
     * 通过id获取房源信息
     * @param hid
     * @return
     */
    @Override
    public House getHouseByid(Integer hid) {
        Example example = new Example(House.class);
        example.createCriteria().andEqualTo("hid",hid);
        return houseMapper.selectOneByExample(example);
    }

    /**
     * 更新房源信息
     * @param house
     * @return
     */
    @Override
    public int updateHouse(House house) {
        Date time = Date.from(Instant.now());
        house.setHupdatetime(time);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    /**
     * 任意条件查询
     * @param serch
     * @return
     */
    @Override
    public List<House> serchHouseByparam(String serch) {
        return houseMapper.serchHouseByparam(serch);
    }
}
