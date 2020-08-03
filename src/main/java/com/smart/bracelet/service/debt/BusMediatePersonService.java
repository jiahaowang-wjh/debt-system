package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusMediatePerson;
import com.smart.bracelet.model.vo.debt.BusMediatePersonVo;

import java.util.List;

public interface BusMediatePersonService {

    int deleteByPrimaryKey(Long mediatePersonId) throws CustomerException;

    int insertSelective(BusMediatePerson record) throws CustomerException;

    BusMediatePerson selectByPrimaryKey(Long mediatePersonId);

    int updateByPrimaryKeySelective(BusMediatePersonVo record) throws CustomerException;

    List<BusMediatePerson> queryList();
}
