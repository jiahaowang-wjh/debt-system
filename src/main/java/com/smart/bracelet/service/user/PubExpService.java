package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubExp;
import com.smart.bracelet.model.vo.user.PubExpVo;

import java.util.List;

public interface PubExpService {

    int deleteByPrimaryKey(Long expId) throws CustomerException;

    int insertSelective(PubExp record) throws CustomerException;

    PubExp selectByPrimaryKey(Long expId);

    int updateByPrimaryKeySelective(PubExpVo record) throws CustomerException;
    /**
     * 查询所有公式
     * @return
     */
    List<PubExp> queryExpList();

    /**
     * 批量删除公式
     * @param expIds
     * @return
     */
    int delExpList(Long[] expIds) throws CustomerException;

}
