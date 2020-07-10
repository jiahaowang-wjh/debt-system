package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubArea;
import com.smart.bracelet.model.vo.user.PubAreaVo;

public interface PubAreaService {

    int deleteByPrimaryKey(Long areaId) throws CustomerException;

    int insertSelective(PubArea record) throws CustomerException;

    PubArea selectByPrimaryKey(Long areaId);

    int updateByPrimaryKeySelective(PubAreaVo record) throws CustomerException;
}
