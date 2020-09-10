package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusGuarantee;
import com.smart.bracelet.model.vo.debt.BusGuaranteeVo;

import java.util.List;

public interface BusGuaranteeService {

    int deleteByPrimaryKey(Long guaranteeId) throws CustomerException;

    int insertSelective(BusGuarantee record) throws CustomerException;

    List<BusGuarantee> selectByPrimaryKey(Long civilId);

    int updateByPrimaryKeySelective(BusGuaranteeVo record) throws CustomerException;

}
