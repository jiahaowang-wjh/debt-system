package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubExp;
import com.smart.bracelet.model.vo.user.PubExpVo;

public interface PubExpService {

    int deleteByPrimaryKey(Long expId) throws CustomerException;

    int insertSelective(PubExp record) throws CustomerException;

    PubExp selectByPrimaryKey(Long expId);

    int updateByPrimaryKeySelective(PubExpVo record) throws CustomerException;
}
