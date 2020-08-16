package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusPropertPromise;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.assets.BusPropertPromiseVo;

import java.util.List;


public interface BusPropertPromiseService {

    int deleteByPrimaryKey(Long promiseId) throws CustomerException;

    int insertSelective(BusPropertPromise record) throws CustomerException;

    BusPropertPromise selectByPrimaryKey(Long promiseId) throws CustomerException;

    int updateByPrimaryKeySelective(BusPropertPromiseVo record) throws CustomerException;

    List<BusPropertPromise> queryList();

    List<DateAndDays> selectDaysCount();
}