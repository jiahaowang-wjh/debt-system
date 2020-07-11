package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.vo.debt.BusPayDetailVo;

public interface BusPayDetailService {

    int deleteByPrimaryKey(Long payId) throws CustomerException;

    int insertSelective(BusPayDetail record) throws CustomerException;

    BusPayDetail selectByPrimaryKey(Long payId);

    int updateByPrimaryKeySelective(BusPayDetailVo record) throws CustomerException;

}
