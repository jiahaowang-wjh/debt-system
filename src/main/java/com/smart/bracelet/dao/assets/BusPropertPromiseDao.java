package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusPropertPromise;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.assets.BusPropertPromiseVo;
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

    /**
     * 查询最后一条编号
     * @return
     */
    String selectNo();
}