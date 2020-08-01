package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPropert;
import com.smart.bracelet.model.vo.debt.BusPropertVo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BusPropertService {
    int deleteByPrimaryKey(Long propertId) throws CustomerException;

    int insertSelective(BusPropert record) throws CustomerException;

    BusPropert selectByPrimaryKey(Long propertId);

    int updateByPrimaryKeySelective(BusPropertVo record) throws CustomerException;

    List<BusPropert> queryList();

}