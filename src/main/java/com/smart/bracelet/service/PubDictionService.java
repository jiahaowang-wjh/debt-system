package com.smart.bracelet.service;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.PubDiction;
import com.smart.bracelet.model.vo.PubDictionVo;

public interface PubDictionService {
    /**
     * 通过Id删除字典
     * @param dictionId
     * @return
     */
    int deleteByPrimaryKey(Long dictionId) throws CustomerException;

    /**
     * 新增字典
     * @param record
     * @return
     */
    int insertSelective(PubDiction record) throws CustomerException;

    /**
     * 通过Id查询字典
     * @param dictionId
     * @return
     */
    PubDiction selectByPrimaryKey(Long dictionId);

    /**
     * 更新字典
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PubDictionVo record) throws CustomerException;

}
