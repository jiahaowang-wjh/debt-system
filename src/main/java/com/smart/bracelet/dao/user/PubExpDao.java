package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.PubExp;
import com.smart.bracelet.model.vo.user.PubExpVo;
import org.springframework.stereotype.Repository;

@Repository
public interface PubExpDao {

    int deleteByPrimaryKey(Long expId);

    int insertSelective(PubExp record);

    PubExp selectByPrimaryKey(Long expId);

    int updateByPrimaryKeySelective(PubExpVo record);

}