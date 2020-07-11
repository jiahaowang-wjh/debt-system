package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusRealAuth;
import com.smart.bracelet.model.vo.debt.BusRealAuthVo;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRealAuthDao {

    int deleteByPrimaryKey(Long realId);

    int insertSelective(BusRealAuth record);

    BusRealAuth selectByPrimaryKey(Long realId);

    int updateByPrimaryKeySelective(BusRealAuthVo record);

}