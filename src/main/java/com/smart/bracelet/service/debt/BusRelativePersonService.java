package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.debt.BusRelativePersonVo;

public interface BusRelativePersonService {
    int deleteByPrimaryKey(Long relativePerId) throws CustomerException;

    int insertSelective(BusRelativePerson record) throws CustomerException;

    BusRelativePerson selectByPrimaryKey(Long relativePerId);

    int updateByPrimaryKeySelective(BusRelativePersonVo record) throws CustomerException;

}
