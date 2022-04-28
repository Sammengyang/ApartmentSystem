package com.zmy.demo.mapper;

import com.zmy.demo.pojo.Rent;
import java.util.List;

public interface RentMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Rent record);

    Rent selectByPrimaryKey(Integer rid);

    List<Rent> selectAll();

    int updateByPrimaryKey(Rent record);
}