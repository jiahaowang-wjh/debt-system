package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubDiction;
import com.smart.bracelet.model.vo.user.PubDictionVo;

import java.util.List;

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

    /**
     * 查询所有字典
     * @return
     */
    List<PubDiction> queryDicList();

    /**
     * 批量删除字典
     * @param dictionIds
     * @return
     */
    int delDictionList(Long[] dictionIds) throws CustomerException;

}
