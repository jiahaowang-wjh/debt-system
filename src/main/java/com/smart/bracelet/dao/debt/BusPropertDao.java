package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusPropert;
import com.smart.bracelet.model.vo.debt.BusPropertVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusPropertDao {
    int deleteByPrimaryKey(Long propertId);

    int insertSelective(BusPropert record);

    BusPropert selectByPrimaryKey(Long propertId);

    int updateByPrimaryKeySelective(BusPropertVo record);

    List<BusPropert> queryList();

}