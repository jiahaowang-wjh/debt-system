package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubExp;
import com.smart.bracelet.model.vo.PubExpVo;
import org.springframework.stereotype.Repository;

@Repository
public interface PubExpDao {

    int deleteByPrimaryKey(Long expId);

    int insertSelective(PubExp record);

    PubExp selectByPrimaryKey(Long expId);

    int updateByPrimaryKeySelective(PubExpVo record);

}