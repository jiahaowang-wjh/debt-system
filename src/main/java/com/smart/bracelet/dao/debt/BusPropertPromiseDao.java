package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusPropertPromise;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.BusPropertPromiseVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusPropertPromiseDao {

    int deleteByPrimaryKey(Long promiseId);

    int insertSelective(BusPropertPromise record);

    BusPropertPromise selectByPrimaryKey(Long promiseId);

    int updateByPrimaryKeySelective(BusPropertPromiseVo record);

    List<DateAndDays> selectDaysCount();

    List<BusPropertPromise> queryList();
}