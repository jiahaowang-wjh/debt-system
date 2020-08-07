package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusConfirm;
import com.smart.bracelet.model.vo.assets.BusConfirmVo;

import java.util.List;

public interface BusConfirmService {

    int deleteByPrimaryKey(Long confirmtId) throws CustomerException;

    int insertSelective(BusConfirm record) throws CustomerException;

    BusConfirm selectByPrimaryKey(Long confirmtId);

    int updateByPrimaryKeySelective(BusConfirmVo record) throws CustomerException;

    List<BusConfirm> queryList();
}
