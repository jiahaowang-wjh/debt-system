package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusRealAuth;
import com.smart.bracelet.model.vo.debt.BusRealAuthVo;

public interface BusRealAuthService {
    int deleteByPrimaryKey(Long realId) throws CustomerException;

    int insertSelective(BusRealAuth record) throws CustomerException;

    BusRealAuth selectByPrimaryKey(Long realId);

    int updateByPrimaryKeySelective(BusRealAuthVo record) throws CustomerException;

}
