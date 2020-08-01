package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPropertPromise;
import com.smart.bracelet.model.vo.debt.BusPropertPromiseVo;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BusPropertPromiseService {

    int deleteByPrimaryKey(Long promiseId) throws CustomerException;

    int insertSelective(BusPropertPromise record) throws CustomerException;

    BusPropertPromise selectByPrimaryKey(Long promiseId) throws CustomerException;

    int updateByPrimaryKeySelective(BusPropertPromiseVo record) throws CustomerException;

    List<BusPropertPromise> queryList();
}