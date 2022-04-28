package com.zmy.demo.mapper;

import com.zmy.demo.pojo.Lessee;
import java.util.List;

public interface LesseeMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(Lessee record);

    Lessee selectByPrimaryKey(Integer lid);

    List<Lessee> selectAll();

    int updateByPrimaryKey(Lessee record);
}