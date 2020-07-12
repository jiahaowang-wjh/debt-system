package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusCivil;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.BusCivilVo;

import java.util.List;

public interface BusCivilService {
    int deleteByPrimaryKey(Long civilId) throws CustomerException;

    int insertSelective(BusCivil record) throws CustomerException;

    BusCivil selectByPrimaryKey(Long civilId);

    int updateByPrimaryKeySelective(BusCivilVo record) throws CustomerException;

    /**
     * 按照日期查询每日报备数量
     * @return
     */
    List<DateAndDays> selectDaysCount();
}
