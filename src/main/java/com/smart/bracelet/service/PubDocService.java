package com.smart.bracelet.service;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.PubDoc;
import com.smart.bracelet.model.vo.PubDocVo;

public interface PubDocService {
    int deleteByPrimaryKey(Long docId) throws CustomerException;

    int insertSelective(PubDoc record) throws CustomerException;

    PubDoc selectByPrimaryKey(Long docId);

    int updateByPrimaryKeySelective(PubDocVo record) throws CustomerException;
}
