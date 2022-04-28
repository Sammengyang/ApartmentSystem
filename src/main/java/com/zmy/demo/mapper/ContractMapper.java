package com.zmy.demo.mapper;

import com.zmy.demo.pojo.Contract;
import java.util.List;

public interface ContractMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Contract record);

    Contract selectByPrimaryKey(Integer cid);

    List<Contract> selectAll();

    int updateByPrimaryKey(Contract record);
}